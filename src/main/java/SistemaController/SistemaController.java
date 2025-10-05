package SistemaController;

import SistemaDAO.CategoriaDAO;
import SistemaDAO.UsuarioDAO;
import SistemaDAO.VideoDAO;
import model.Categoria;
import model.Usuario;
import model.Video;

public class SistemaController {
    private final CategoriaDAO categoriaDAO = new CategoriaDAO();
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final VideoDAO videoDAO = new VideoDAO();

    public void cadastrarCategoria(Categoria categoria) {
        categoriaDAO.cadastrarCategoria(categoria);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioDAO.cadastrarUsuario(usuario);
    }

    public void cadastrarVideo(Video video) {
        videoDAO.cadastrarVideo(video);
    }

    public void listarVideos() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
