package SistemaView;

import SistemaDAO.VideoDAO;
import model.Categoria;
import model.Video;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroVideoView extends JFrame {

    private final JTextField txtTitulo;
    private final JTextField txtDescricao;
    private final JTextField txtData;
    private final JTextField txtCategoria;
    private final JButton btnCadastrar;
    private final JButton btnVoltar;
    private final VideoDAO videoDAO;

    public CadastroVideoView() {
        setTitle("Cadastro de Vídeo");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        videoDAO = new VideoDAO();

        JLabel lblTituloTela = new JLabel("Cadastro de Vídeo", SwingConstants.CENTER);
        lblTituloTela.setFont(new Font("Arial", Font.BOLD, 16));

        // Painel de campos
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

        // Botões
        btnCadastrar = new JButton("Cadastrar");
        btnVoltar = new JButton("Voltar");

        JPanel panelBotoes = new JPanel(new FlowLayout());
        panelBotoes.add(btnCadastrar);
        panelBotoes.add(btnVoltar);

        // Layout principal
        setLayout(new BorderLayout(10, 10));
        add(lblTituloTela, BorderLayout.NORTH);
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);

        // Ações
        btnCadastrar.addActionListener(e -> cadastrarVideo());
        btnVoltar.addActionListener(e -> voltarMenu());
    }

    private void cadastrarVideo() {
        try {
            String titulo = txtTitulo.getText().trim();
            String descricao = txtDescricao.getText().trim();
            String dataStr = txtData.getText().trim();
            String categoriaStr = txtCategoria.getText().trim();

            if (titulo.isEmpty() || descricao.isEmpty() || dataStr.isEmpty() || categoriaStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idCategoria = Integer.parseInt(categoriaStr);
            Date dataUtil = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            Categoria cat = new Categoria();
            cat.setIdCategoria(idCategoria);

            Video video = new Video();
            video.setTitulo(titulo);
            video.setDescricao(descricao);
            video.setDataPublicacao(dataSql);
            video.setCategoria(cat);

            videoDAO.cadastrarVideo(video);

            JOptionPane.showMessageDialog(this, "Vídeo cadastrado com sucesso!");
            voltarMenu();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID da categoria inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido! Use dd/MM/yyyy", "Erro", JOptionPane.ERROR_MESSAGE);
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
