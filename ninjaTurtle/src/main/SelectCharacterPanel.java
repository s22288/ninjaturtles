package main;

import javax.swing.*;

public class SelectCharacterPanel {


    public  void choose() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       SeclectHeroPanel seclectHeroPanel = new SeclectHeroPanel();
        window.setResizable(false);
        window.setTitle("SelectHero");
        window.add(seclectHeroPanel);



        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        // odpalenie pętli gry


    }
}
