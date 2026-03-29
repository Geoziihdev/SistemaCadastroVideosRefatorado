package SistemaView;

import SistemaController.SistemaController;
import javax.swing.*;
import java.awt.*;

public class CadastroCategoriaView extends JFrame {

    private JTextField txtNome, txtDescricao;
    private JButton btnCadastrar, btnVoltar;
    private final SistemaController controller;

    public CadastroCategoriaView() {
        setTitle("Cadastro de Categoria");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        controller = new SistemaController();

        JLabel lblTitulo = new JLabel("Cadastro de Categoria", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));

        txtNome = new JTextField();
        txtNome.setToolTipText("Nome da categoria");

        txtDescricao = new JTextField();
        txtDescricao.setToolTipText("Descrição da categoria");

        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.add(lblTitulo);
        panel.add(txtNome);
        panel.add(txtDescricao);
        panel.add(btnCadastrar);
        panel.add(btnVoltar);

        add(panel);

        btnCadastrar.addActionListener(e -> cadastrarCategoria());

        btnVoltar.addActionListener(e -> {
            new MenuView().setVisible(true);
            dispose();
        });
    }

    private void cadastrarCategoria() {
        String nome = txtNome.getText().trim();
        String descricao = txtDescricao.getText().trim();

        String mensagem = controller.cadastrarCategoria(nome, descricao);

        if (mensagem.equals("Categoria cadastrada com sucesso!")) {
            JOptionPane.showMessageDialog(this, mensagem);
            new MenuView().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroCategoriaView().setVisible(true));
    }
}