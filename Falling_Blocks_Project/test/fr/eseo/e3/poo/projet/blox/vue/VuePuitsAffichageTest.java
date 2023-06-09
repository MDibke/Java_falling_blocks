package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class VuePuitsAffichageTest {
    public VuePuitsAffichageTest() {
        testConstructeurPuitsTaille();
        testConstructeurPuits();
    }

    // Run test thread
    public static void main (String [] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                new VuePuitsAffichageTest();
            }
        });
    }

    private void testConstructeurPuits() {
        // Instantiate puits
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits);

        // Register VuePuits as listener of Puits
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();
        puits.setPieceSuivante(piece1);
        puits.setPieceSuivante(piece2);
        //vuePuits.setVuePiece(new VuePiece(piece1, vuePuits.getTaille()));

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

    private void testConstructeurPuitsTaille() {
        // Instantiate puits
        Puits puits = new Puits();
        VuePuits vuePuits = new VuePuits(puits, 25);

        // Create frame
        JFrame frame = new JFrame("Puits et taille");
        frame.setSize(puits.getLargeur() * vuePuits.getTaille(), puits.getProfondeur() * vuePuits.getTaille());
        frame.setResizable(true); // Disable resize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit

        // Center the frame
        frame.setLocationRelativeTo(null);

        // Show frame
        frame.setVisible(true);
        frame.add(vuePuits);
    }
}
