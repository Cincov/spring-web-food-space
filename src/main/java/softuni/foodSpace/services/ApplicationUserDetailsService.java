package softuni.foodSpace.services;

import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import softuni.foodSpace.domain.entities.UserEntity;
import softuni.foodSpace.domain.entities.UserRoleEntity;
import softuni.foodSpace.repositories.UserRepository;

import java.util.List;

public class ApplicationUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public ApplicationUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return
        userRepository.
            findByUsername(username).
            map(this::map).
            orElseThrow(() -> new UsernameNotFoundException("UserEntity with name " + username + " not found!"));
  }

  private UserDetails map(UserEntity userEntity) {
    return new User(
        userEntity.getEmail(),
        userEntity.getPassword(),
        extractAuthorities(userEntity)
    );
  }

  private List<GrantedAuthority> extractAuthorities(UserEntity userEntity) {
    return userEntity.
        getRoles().
        stream().
        map(this::mapRole).
        toList();
  }

  private GrantedAuthority mapRole(UserRoleEntity userRoleEntity) {
    return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
  }
}
