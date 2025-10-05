package SistemaView;

import SistemaDAO.CategoriaDAO;
import model.Categoria;
import javax.swing.*;
import java.awt.*;

public class CadastroCategoriaView extends JFrame {

    private JTextField txtNome, txtDescricao;
    private JButton btnCadastrar, btnVoltar;

    public CadastroCategoriaView() {
        setTitle("Cadastro de Categoria");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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

        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String descricao = txtDescricao.getText().trim();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O campo nome é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Categoria cat = new Categoria();
                cat.setNome(nome);
                cat.setDescricao(descricao);

                CategoriaDAO dao = new CategoriaDAO();
                dao.cadastrarCategoria(cat); // salvar no banco

                JOptionPane.showMessageDialog(this, "Categoria cadastrada com sucesso!");
                new MenuView().setVisible(true);
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar categoria!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnVoltar.addActionListener(e -> {
            new MenuView().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroCategoriaView().setVisible(true));
    }
}
