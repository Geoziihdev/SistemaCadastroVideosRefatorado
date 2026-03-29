package SistemaView;

import SistemaController.SistemaController;

import javax.swing.*;
import java.awt.*;
public class CadastroVideoView extends JFrame {

    private final JTextField txtTitulo;
    private final JTextField txtDescricao;
    private final JTextField txtData;
    private final JTextField txtCategoria;
    private final JButton btnCadastrar;
    private final JButton btnVoltar;
    private final SistemaController controller;

    public CadastroVideoView() {
        setTitle("Cadastro de Vídeo");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        controller = new SistemaController();

        JLabel lblTituloTela = new JLabel("Cadastro de Vídeo", SwingConstants.CENTER);
        lblTituloTela.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel panelCampos = new JPanel(new GridLayout(4, 2, 10, 10));

        panelCampos.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelCampos.add(txtTitulo);

        panelCampos.add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        panelCampos.add(txtDescricao);

        panelCampos.add(new JLabel("Data (dd/MM/yyyy):"));
        txtData = new JTextField();
        panelCampos.add(txtData);

        panelCampos.add(new JLabel("ID da Categoria:"));
        txtCategoria = new JTextField();
        panelCampos.add(txtCategoria);

        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");

        JPanel panelBotoes = new JPanel(new FlowLayout());
        panelBotoes.add(btnCadastrar);
        panelBotoes.add(btnVoltar);

        setLayout(new BorderLayout(10, 10));
        add(lblTituloTela, BorderLayout.NORTH);
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(e -> cadastrarVideo());
        btnVoltar.addActionListener(e -> voltarMenu());
    }

    private void cadastrarVideo() {
        String titulo = txtTitulo.getText().trim();
        String descricao = txtDescricao.getText().trim();
        String dataStr = txtData.getText().trim();
        String categoriaStr = txtCategoria.getText().trim();

        String mensagem = controller.cadastrarVideo(titulo, descricao, dataStr, categoriaStr);

        if (mensagem.equals("Vídeo cadastrado com sucesso!")) {
            JOptionPane.showMessageDialog(this, mensagem);
            voltarMenu();
        } else {
            JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void voltarMenu() {
        new MenuView().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroVideoView().setVisible(true));
    }
}