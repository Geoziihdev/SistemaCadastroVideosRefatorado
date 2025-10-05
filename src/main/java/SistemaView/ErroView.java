package SistemaView;

import javax.swing.*;
import java.awt.*;

public class ErroView extends JFrame {
    public ErroView(String mensagem) {
        setTitle("Erro");
        setSize(350, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel lblMsg = new JLabel(mensagem, SwingConstants.CENTER);
        lblMsg.setForeground(Color.RED);
        lblMsg.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnVoltar = new JButton("Voltar");

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(lblMsg, BorderLayout.CENTER);
        panel.add(btnVoltar, BorderLayout.SOUTH);

        add(panel);

        btnVoltar.addActionListener(e -> {
            this.dispose(); 
        });
    }
}
