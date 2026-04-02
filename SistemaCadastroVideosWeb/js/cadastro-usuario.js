const usuarioForm = document.getElementById("usuarioForm");

usuarioForm.addEventListener("submit", function (event) {
  event.preventDefault();

  const email = document.getElementById("emailUsuario").value.trim();
  const senha = document.getElementById("senhaUsuario").value.trim();
  const confirmar = document.getElementById("confirmarSenhaUsuario").value.trim();

  if (!email || !senha || !confirmar) {
    window.location.href = "erro-cadastro-usuario.html";
    return;
  }

  if (!email.includes("@") || !email.includes(".")) {
    window.location.href = "erro-cadastro-usuario.html";
    return;
  }

  if (senha !== confirmar) {
    window.location.href = "erro-cadastro-usuario.html";
    return;
  }

  window.location.href = "index.html";
});