package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class VueScore extends JPanel {
    private static int score;
    private VueScore() {
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        VueScore.score = score;
    }

    public static void addScore(int addScore) {
        VueScore.score += addScore;
    }

    public static void afficherScore(Graphics2D g) {
        Graphics2D g2D = (Graphics2D) g.create();

        g2D.setColor(Color.BLACK);
        g2D.setFont(new Font("Arial", Font.BOLD, 12));
        g2D.drawString("Score : " + getScore(), 2, 100);

        /*Puis nous liberons la memoire*/
        g2D.dispose();
    }
}
