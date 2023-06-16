package fr.eseo.e3.poo.projet.blox;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import static fr.eseo.e3.poo.projet.blox.modele.UsineDePiece.setMode;
import static fr.eseo.e3.poo.projet.blox.vue.VueScore.setScore;

public class FallingBloxVersion2 {
    private FallingBloxVersion2() {
    }

    public static void main(String[] args) {
        int largeur =10;
        int profondeur = 20;
        setScore(0);
        Puits puits;
        switch (args.length) {
            case 1:
                puits = new Puits(largeur, profondeur, Integer.parseInt(args[0]),
                        (Integer.parseInt(args[0])/ largeur)+1);
                break;
            case 2:
                puits = new Puits(largeur, profondeur, Integer.parseInt(args[0]),
                        Integer.parseInt(args[1]));
                break;
            default:
                puits = new Puits(largeur, profondeur);
                break;
        }
        VuePuits vuePuits = new VuePuits(puits,20);
        PanneauInformation panneauInformation = new PanneauInformation(puits);

        // Register VuePuits as listener of Puits
        setMode(UsineDePiece.ALEATOIRE_COMPLET);

        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();
        puits.setPieceSuivante(piece1);
        puits.setPieceSuivante(piece2);

        vuePuits.setGravite(new Gravite(vuePuits));

        int largeurFrame = (puits.getLargeur() +1 ) * vuePuits.getTaille() + panneauInformation.getPreferredSize().width;
        int profondeurFrame = (puits.getProfondeur() + 2) * vuePuits.getTaille();

        // Create frame
        JFrame frame = new JFrame("Falling Blox");
        frame.setSize(largeurFrame, profondeurFrame);
        frame.setResizable(false); // Disable resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit

        frame.add(panneauInformation, BorderLayout.EAST);

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Show frame
        frame.setVisible(true);
        frame.add(vuePuits);
    }
}
