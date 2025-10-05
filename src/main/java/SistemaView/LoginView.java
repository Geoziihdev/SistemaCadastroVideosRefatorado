package SistemaView;

import SistemaDAO.UsuarioDAO;
import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private final JButton btnEntrar, btnCadastrar;

    public LoginView() {
        setTitle("Tela de Login");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Bem-vindos ao Sistema de Cadastro de Vídeos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));

        txtUsuario = new JTextField();
        txtSenha = new JPasswordField();
        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Cadastre-se");

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.add(lblTitulo);
        panel.add(txtUsuario);
        panel.add(txtSenha);
        panel.add(btnEntrar);
        panel.add(btnCadastrar);
        add(panel);

        btnEntrar.addActionListener(e -> {
            String email = txtUsuario.getText().trim();
            String senha = new String(txtSenha.getPassword());

            UsuarioDAO dao = new UsuarioDAO();
            if (dao.autenticar(email, senha)) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                new MenuView().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCadastrar.addActionListener(e -> {
            new CadastroUsuarioView().setVisible(true); 
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
}
