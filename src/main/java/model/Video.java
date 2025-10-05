package model;

import java.util.Date;

public class Video {
    private int idVideo;
    private String titulo;
    private String descricao;
    private Date dataPublicacao; 
    private Categoria categoria;  

    public Video(int idVideo, String titulo, String descricao, Date dataPublicacao, Categoria categoria) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
    }

    public Video() {
        
    }

    public int getIdVideo() { return idVideo; }
    public void setIdVideo(int idVideo) { this.idVideo = idVideo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Date getDataPublicacao() { return dataPublicacao; }
    public void setDataPublicacao(Date dataPublicacao) { this.dataPublicacao = dataPublicacao; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public void cadastrarVideo() {
        System.out.println("Vídeo " + titulo + " cadastrado!");
    }

    public void editarVideo() {
        System.out.println("Vídeo " + titulo + " editado!");
    }

    public void excluirVideo() {
        System.out.println("Vídeo " + titulo + " excluído!");
    }

    public void listarVideos() {
        System.out.println("Listando vídeos...");
    }
}
