package SistemaView;

import SistemaDAO.CategoriaDAO;
import SistemaDAO.UsuarioDAO;
import SistemaDAO.VideoDAO;
import model.Categoria;
import model.Usuario;
import model.Video;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Categoria cat = new Categoria();
        cat.setNome("Tecnologia");
        cat.setDescricao("Vídeos sobre programação");
        new CategoriaDAO().cadastrarCategoria(cat);

        Usuario u = new Usuario();
        u.setNome("Geovana");
        u.setEmail("geo@email.com");
        u.setSenha("1234");
        new UsuarioDAO().cadastrarUsuario(u);

        Video v = new Video();
        v.setTitulo("CRUD em Java");
        v.setDescricao("Tutorial de CRUD com JDBC");
        v.setDataPublicacao(new Date());
        v.setCategoria(cat);
        new VideoDAO().cadastrarVideo(v);

        System.out.println("Todos os dados cadastrados com sucesso no banco!");
    }
}
