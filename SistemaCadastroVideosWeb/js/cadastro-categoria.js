const categoriaForm = document.getElementById("categoriaForm");

categoriaForm.addEventListener("submit", function (event) {
  event.preventDefault();

  const nome = document.getElementById("nomeCategoria").value.trim();
  const descricao = document.getElementById("descricaoCategoria").value.trim();

  if (!nome || !descricao) {
    window.location.href = "erro-cadastro-categoria.html";
    return;
  }

  window.location.href = "sucesso-categoria.html";
});