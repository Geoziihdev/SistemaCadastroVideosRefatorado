const videoForm = document.getElementById("videoForm");

videoForm.addEventListener("submit", function (event) {
  event.preventDefault();

  const titulo = document.getElementById("tituloVideo").value.trim();
  const descricao = document.getElementById("descricaoVideo").value.trim();
  const data = document.getElementById("dataPublicacao").value.trim();
  const categoria = document.getElementById("categoriaVideo").value.trim();

  if (!titulo || !descricao || !data || !categoria) {
    window.location.href = "erro-cadastro-video.html";
    return;
  }

  window.location.href = "sucesso-video.html";
});