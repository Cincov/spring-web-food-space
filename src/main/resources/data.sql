-- some test users

INSERT INTO roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

INSERT INTO users (id, email, first_name, last_name, username, is_active, password)
VALUES
    (1, 'admin@example.com', 'Admin', 'Adminov', 'admin', 1, '$2a$10$YelHxdnNur5Wc3MKWuYA6OQGGTARcX1ub9z7F0Ty/5Tlm/80loZhi');


INSERT INTO users_roles (user_id, role_id)
VALUES
    (1, 1),
    (1, 2);
