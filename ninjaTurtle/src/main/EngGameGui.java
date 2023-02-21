package main;

import javax.swing.*;
import java.awt.*;

public class EngGameGui {
    public EngGameGui() {
        JFrame window = new JFrame();
        JLabel koniec = new JLabel("koniec poziomu",SwingConstants.CENTER);
        koniec.setFont(new Font("Serif", Font.PLAIN, 45));

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Ending");
      window.setSize(new Dimension(540,750));
      window.add(koniec);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        // odpalenie pętli gry
//        gamePanel.startGameThread();
    }

    public static void main(String[] args) {
        new EngGameGui();
    }
}
