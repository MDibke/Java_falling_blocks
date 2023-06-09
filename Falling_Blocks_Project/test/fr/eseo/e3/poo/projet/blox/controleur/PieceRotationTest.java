package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PieceRotationTest {
    public PieceRotationTest() {
    testConstructeurPuits();
}

    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new PieceDeplacementTest();
            }
        });
    }

    private void testConstructeurPuits() {
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);

        // Register VuePuits as listener of Puits
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();
        puits.setPieceSuivante(piece1);
        puits.setPieceSuivante(piece2);
        //vuePuits.setVuePiece(new VuePiece(piece1, vuePuits.getTaille()));

        piece1.setPuits(puits);
        piece2.setPuits(puits);

        int largeur = puits.getLargeur() * vuePuits.getTaille();
        int profondeur = puits.getProfondeur() * vuePuits.getTaille();

        // Create frame
        JFrame frame = new JFrame("Puits");
        frame.setSize(largeur, profondeur);
        frame.setResizable(true); // Disable resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Show frame
        frame.setVisible(true);
        frame.add(vuePuits);
    }
}
