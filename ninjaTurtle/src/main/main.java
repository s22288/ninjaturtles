package main;

import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Ninja Turtle");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        // odpalenie pętli gry
        gamePanel.startGameThread();

    }
}
