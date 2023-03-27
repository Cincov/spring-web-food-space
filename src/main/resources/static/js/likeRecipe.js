// let LikeRecipe = document.getElementById("likeRecipe").onclick;
let recipeId = document.getElementById(recipeId).getAttribute("value");
fetch(`http://localhost:8080/recipes/details/${recipeId}`)
    .then(res)