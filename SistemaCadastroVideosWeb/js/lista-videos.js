const tabelaVideos = document.getElementById("tabelaVideos");

const videos = [
  {
    titulo: "Lorem Ipsum",
    categoria: "Lorem Ipsum",
    data: "Lorem Ipsum"
  },
  {
    titulo: "Lorem Ipsum",
    categoria: "Lorem Ipsum",
    data: "Lorem Ipsum"
  },
  {
    titulo: "Lorem Ipsum",
    categoria: "Lorem Ipsum",
    data: "Lorem Ipsum"
  }
];

function carregarTabela() {
  tabelaVideos.innerHTML = "";

  videos.forEach(function (video) {
    const linha = document.createElement("tr");

    linha.innerHTML = `
      <td>${video.titulo}</td>
      <td>${video.categoria}</td>
      <td>${video.data}</td>
    `;

    tabelaVideos.appendChild(linha);
  });
}

function editarVideo() {
  alert("Edição simulada.");
}

function excluirVideo() {
  alert("Exclusão simulada.");
}

carregarTabela();