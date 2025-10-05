package SistemaDAO;

import model.Video;
import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    public void cadastrarVideo(Video video) {
        if (video.getCategoria() == null || video.getCategoria().getIdCategoria() <= 0) {
            System.out.println("Erro: Categoria inválida. Cadastre uma categoria primeiro.");
            return;
        }

        String sql = "INSERT INTO video (titulo, descricao, data_publicacao, categoria_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, video.getTitulo());
            stmt.setString(2, video.getDescricao());
            if (video.getDataPublicacao() != null) {
                stmt.setDate(3, new java.sql.Date(video.getDataPublicacao().getTime()));
            } else {
                stmt.setDate(3, null);
            }
            stmt.setInt(4, video.getCategoria().getIdCategoria());

            int linhas = stmt.executeUpdate(); // retorna número de linhas afetadas
            if (linhas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    video.setIdVideo(rs.getInt(1));
                }
                System.out.println("Vídeo cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar vídeo: nenhuma linha afetada.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar vídeo: " + e.getMessage());
        }
    }

    public List<Video> listarVideos() {
        List<Video> lista = new ArrayList<>();
        String sql = "SELECT v.id AS idVideo, v.titulo, v.descricao, v.data_publicacao, " +
                     "c.id AS categoria_id, c.nome, c.descricao AS categoria_descricao " +
                     "FROM video v LEFT JOIN categoria c ON v.categoria_id = c.id";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setIdCategoria(rs.getInt("categoria_id"));
                cat.setNome(rs.getString("nome"));
                cat.setDescricao(rs.getString("categoria_descricao"));

                Video v = new Video();
                v.setIdVideo(rs.getInt("idVideo"));
                v.setTitulo(rs.getString("titulo"));
                v.setDescricao(rs.getString("descricao"));
                v.setDataPublicacao(rs.getDate("data_publicacao"));
                v.setCategoria(cat);

                lista.add(v);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar vídeos: " + e.getMessage());
        }

        return lista;
    }
}
