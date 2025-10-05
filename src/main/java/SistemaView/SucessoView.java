package SistemaView;

import javax.swing.*;
import java.awt.*;

public class SucessoView extends JFrame {
    public SucessoView(String mensagem) {
        setTitle("Sucesso");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblMsg = new JLabel(mensagem, SwingConstants.CENTER);
        lblMsg.setForeground(new Color(0,128,0));
        lblMsg.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnVoltar = new JButton("Voltar");

        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.add(lblMsg, BorderLayout.CENTER);
        panel.add(btnVoltar, BorderLayout.SOUTH);

        add(panel);

        btnVoltar.addActionListener(e -> {
            new MenuView().setVisible(true);
            dispose();
        });
    }
}
