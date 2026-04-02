package SistemaController;

import SistemaDAO.CategoriaDAO;
import SistemaDAO.UsuarioDAO;
import SistemaDAO.VideoDAO;
import model.Categoria;
import model.Usuario;
import model.Video;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaController {
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final VideoDAO videoDAO = new VideoDAO();

    private final ValidadorCadastroUsuario validadorCadastroUsuario = new ValidadorCadastroUsuario();

    public void cadastrarCategoria(Categoria categoria) {
        categoriaDAO.cadastrarCategoria(categoria);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioDAO.cadastrarUsuario(usuario);
    }

    public void cadastrarVideo(Video video) {
        videoDAO.cadastrarVideo(video);
    }

    public java.util.List<Video> listarVideos() {
        return videoDAO.listarVideos();
    }

    public String cadastrarVideo(String titulo, String descricao, String dataStr, String categoriaStr) {
        try {
            if (titulo.isEmpty() || descricao.isEmpty() || dataStr.isEmpty() || categoriaStr.isEmpty()) {
                return "Preencha todos os campos!";
            }

            int idCategoria = Integer.parseInt(categoriaStr);
            Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            Categoria categoria = new Categoria();
            categoria.setIdCategoria(idCategoria);

            Video video = new Video();
            video.setTitulo(titulo);
            video.setDescricao(descricao);
            video.setDataPublicacao(dataSql);
            video.setCategoria(categoria);

            videoDAO.cadastrarVideo(video);

            return "Vídeo cadastrado com sucesso!";

        } catch (NumberFormatException e) {
            return "ID da categoria inválido!";
        } catch (ParseException e) {
            return "Formato de data inválido! Use dd/MM/yyyy";
        }
    }

    public String cadastrarCategoria(String nome, String descricao) {
        if (nome.isEmpty()) {
            return "O campo nome é obrigatório!";
        }

        try {
            Categoria categoria = new Categoria();
            categoria.setNome(nome);
            categoria.setDescricao(descricao);

            categoriaDAO.cadastrarCategoria(categoria);
            return "Categoria cadastrada com sucesso!";

        } catch (Exception e) {
            return "Erro ao cadastrar categoria!";
        }
    }

    public String cadastrarUsuario(String email, String senha, String confirma) {

        if (!validadorCadastroUsuario.camposObrigatoriosPreenchidos(email, senha, confirma)) {
            return "Preencha todos os campos!";
        }

        if (!validadorCadastroUsuario.emailValido(email)) {
            return "E-mail inválido!";
        }

        if (!validadorCadastroUsuario.senhasConferem(senha, confirma)) {
            return "As senhas não coincidem!";
        }

        try {
            Usuario usuario = new Usuario();
            usuario.setNome(email);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            usuarioDAO.cadastrarUsuario(usuario);
            return "Usuário cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao tentar cadastrar usuário!";
        }
    }

    public boolean autenticarUsuario(String email, String senha) {
        if (email == null || email.trim().isEmpty() || senha == null || senha.trim().isEmpty()) {
            return false;
        }

        return usuarioDAO.autenticar(email, senha);
    }
}
