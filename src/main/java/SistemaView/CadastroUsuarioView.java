package SistemaView;

import SistemaDAO.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuarioView extends JFrame {
    private JTextField txtEmail;
    private JPasswordField txtSenha, txtConfirmar;
    private final JButton btnCadastrar;
    private final JButton btnVoltar;

    public CadastroUsuarioView() {
        setTitle("Cadastro de Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

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

        btnCadastrar.addActionListener((ActionEvent e) -> {
            String email = txtEmail.getText().trim();
            String senha = new String(txtSenha.getPassword());
            String confirma = new String(txtConfirmar.getPassword());
            
            if (email.isEmpty() || senha.isEmpty() || !senha.equals(confirma)) {
                new ErroView("Erro ao tentar cadastrar usuário!").setVisible(true);
            } else {
                Usuario usuario = new Usuario();
                usuario.setNome(email);
                usuario.setEmail(email);
                usuario.setSenha(senha);
                
                UsuarioDAO dao = new UsuarioDAO();
                dao.cadastrarUsuario(usuario);
                
                new SucessoView("Usuário cadastrado com sucesso!").setVisible(true);
                dispose();
            }
        });

        btnVoltar.addActionListener(e -> {
            new LoginView().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroUsuarioView().setVisible(true));
    }
}
