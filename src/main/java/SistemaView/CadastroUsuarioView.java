package SistemaView;

import SistemaController.SistemaController;

import javax.swing.*;
import java.awt.*;

public class CadastroUsuarioView extends JFrame {
    private JTextField txtEmail;
    private JPasswordField txtSenha, txtConfirmar;
    private final JButton btnCadastrar;
    private final JButton btnVoltar;
    private final SistemaController controller;

    public CadastroUsuarioView() {
        setTitle("Cadastro de Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        controller = new SistemaController();

        JLabel lblTitulo = new JLabel("Bem-vindos ao Sistema de Cadastro de Vídeos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));

        txtEmail = new JTextField("Nome de usuário ou E-mail");
        txtSenha = new JPasswordField("Crie uma senha");
        txtConfirmar = new JPasswordField("Confirme sua senha");

        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");

        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        panel.add(lblTitulo);
        panel.add(txtEmail);
        panel.add(txtSenha);
        panel.add(txtConfirmar);
        panel.add(btnCadastrar);
        panel.add(btnVoltar);

        add(panel);

        btnCadastrar.addActionListener(e -> cadastrarUsuario());

        btnVoltar.addActionListener(e -> {
            new LoginView().setVisible(true);
            dispose();
        });
    }

    private void cadastrarUsuario() {
        String email = txtEmail.getText().trim();
        String senha = new String(txtSenha.getPassword());
        String confirma = new String(txtConfirmar.getPassword());

        String mensagem = controller.cadastrarUsuario(email, senha, confirma);

        if (mensagem.equals("Usuário cadastrado com sucesso!")) {
            new SucessoView(mensagem).setVisible(true);
            dispose();
        } else {
            new ErroView(mensagem).setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroUsuarioView().setVisible(true));
    }
}