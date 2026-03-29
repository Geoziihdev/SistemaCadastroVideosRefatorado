package SistemaView;

import SistemaController.SistemaController;
import model.Video;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class ListaVideosView extends JFrame {

    private final SistemaController controller;

    public ListaVideosView() {
        setTitle("Lista de Vídeos");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        controller = new SistemaController();

        JLabel lblTitulo = new JLabel("Lista de Vídeos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

        String[] colunas = {"Título do vídeo", "Categoria", "Data de publicação"};

        Object[][] dados;
        try {
            List<Video> videos = controller.listarVideos();
            dados = new Object[videos.size()][3];
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            for (int i = 0; i < videos.size(); i++) {
                Video v = videos.get(i);
                dados[i][0] = v.getTitulo();
                dados[i][1] = v.getCategoria() != null ? v.getCategoria().getNome() : "";
                dados[i][2] = v.getDataPublicacao() != null ? sdf.format(v.getDataPublicacao()) : "";
            }
        } catch (Exception e) {
            new ErroView("Erro ao carregar vídeos!").setVisible(true);
            dados = new Object[0][3];
        }

        JTable tabela = new JTable(dados, colunas);

        JButton btnEditar = new JButton("Editar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnVoltar = new JButton("Voltar");

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botoes.add(btnEditar);
        botoes.add(btnExcluir);
        botoes.add(btnVoltar);

        add(lblTitulo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        btnEditar.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                new SucessoView("Edição simulada!").setVisible(true);
            } else {
                new ErroView("Selecione um vídeo para editar!").setVisible(true);
            }
        });

        btnExcluir.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha >= 0) {
                new SucessoView("Exclusão simulada!").setVisible(true);
            } else {
                new ErroView("Selecione um vídeo para excluir!").setVisible(true);
            }
        });

        btnVoltar.addActionListener(e -> {
            new MenuView().setVisible(true);
            dispose();
        });
    }
}