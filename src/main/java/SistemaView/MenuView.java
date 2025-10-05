package SistemaView;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {

    public MenuView() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lbl = new JLabel("Bem-vindos ao Sistema de Cadastro de Vídeos", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnCategoria = new JButton("Cadastro de Categoria");
        JButton btnVideo = new JButton("Cadastro de Vídeo");
        JButton btnLista = new JButton("Lista de Vídeos");
        JButton btnSair = new JButton("Sair");

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(lbl);
        panel.add(btnCategoria);
        panel.add(btnVideo);
        panel.add(btnLista);
        panel.add(btnSair);

        add(panel);

        btnCategoria.addActionListener(e -> {
            new CadastroCategoriaView().setVisible(true);
            dispose();
        });

        btnVideo.addActionListener(e -> {
            new CadastroVideoView().setVisible(true);
            dispose();
        });

        btnLista.addActionListener(e -> {
            new ListaVideosView().setVisible(true);
            dispose();
        });

        btnSair.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuView().setVisible(true));
    }
}
