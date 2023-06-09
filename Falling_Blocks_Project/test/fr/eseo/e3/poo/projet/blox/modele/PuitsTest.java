package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuitsTest {

    @Test
    public void testPuits() {
        Puits puits = new Puits();
        assertEquals(20, puits.getProfondeur(), "Test de la profondeur du puits");
        assertEquals(10, puits.getLargeur(), "Test de la largeur du puits");
    }

    @Test
    public void testPuits2() {
        Puits puits = new Puits(12,17);
        assertEquals(17, puits.getProfondeur(), "Test de la profondeur du puits");
        assertEquals(12, puits.getLargeur(), "Test de la largeur du puits");
    }

    @Test
    public void testPuits3() {
        try {
            Puits puits = new Puits(16, 15);
        } catch (IllegalArgumentException e) {
            assertEquals("La largeur doit être comprise entre 5 et 15", e.getMessage(),
                    "Test de la largeur du puits");
        }
    }

    @Test
    public void testPuits4() {
        try {
            Puits puits = new Puits(5, 10);
        } catch (IllegalArgumentException e) {
            assertEquals("La profondeur doit être comprise entre 15 et 25", e.getMessage(),
                    "Test de la largeur du puits");
        }
    }

    @Test
    public void testPuits5() {
        try {
            Puits puits = new Puits(15, 22, 10, 10);
            assertEquals(22, puits.getProfondeur(), "Test de la profondeur du puits");
            assertEquals(15, puits.getLargeur(), "Test de la largeur du puits");
            assertEquals(10, puits.getNbElements(), "Test du nombre d'éléments du puits");
            assertEquals(10, puits.getNbLignes(), "Test du nombre de lignes du puits");
        } catch (IllegalArgumentException e) {
            assertEquals("La profondeur doit être comprise entre 15 et 25", e.getMessage(),
                    "Test de la largeur du puits");
        }
    }

    @Test
    public void testSetProfondeur() {
        Puits puits = new Puits();
        puits.setProfondeur(16);
        assertEquals(16, puits.getProfondeur(), "Test de la profondeur du puits");
    }

    @Test
    public void testSetLargeur() {
        Puits puits = new Puits();
        puits.setLargeur(12);
        assertEquals(12, puits.getLargeur(), "Test de la largeur du puits");
    }

    @Test
    public void testSetProfondeur2() {
        Puits puits = new Puits();
        try {
            puits.setProfondeur(4);
        } catch (IllegalArgumentException e) {
            assertEquals("La profondeur doit être comprise entre 15 et 25", e.getMessage(),
                    "Test de la profondeur du puits");
        }
    }

    @Test
    public void testSetProfondeur3() {
        Puits puits = new Puits();
        try {
            puits.setProfondeur(26);
        } catch (IllegalArgumentException e) {
            assertEquals("La profondeur doit être comprise entre 15 et 25", e.getMessage(),
                    "Test de la profondeur du puits");
        }
    }

    @Test
    public void testSetLargeur2() {
        Puits puits = new Puits();
        try {
            puits.setLargeur(4);
        } catch (IllegalArgumentException e) {
            assertEquals("La largeur doit être comprise entre 5 et 15", e.getMessage(),
                    "Test de la largeur du puits");
        }
    }

    @Test
    public void testSetLargeur3() {
        Puits puits = new Puits();
        try {
            puits.setLargeur(16);
        } catch (IllegalArgumentException e) {
            assertEquals("La largeur doit être comprise entre 5 et 15", e.getMessage(),
                    "Test de la largeur du puits");
        }
    }

    @Test
    public void setPieceSuivante() {
        Puits puits = new Puits();
        IPiece iPiece = new IPiece(new Coordonnees(1, 2), Couleur.ROUGE);
        puits.setPieceSuivante(iPiece);
        assertEquals(iPiece, puits.getPieceSuivante(), "Test de la pièce suivante");
    }

    @Test
    public void setPieceSuivante2() {
        Puits puits = new Puits();
        IPiece iPiece = new IPiece(new Coordonnees(1, 2), Couleur.ROUGE);
        puits.setPieceSuivante(iPiece);
        assertEquals(null, puits.getPieceActuelle(), "Test de la pièce actuelle");
    }

    @Test
    public void testToString3() {
        Puits puits = new Puits();
        IPiece iPiece = new IPiece(new Coordonnees(0, 2), Couleur.ROUGE);
        OPiece oPiece = new OPiece(new Coordonnees(0, 2), Couleur.ROUGE);
        puits.setPieceSuivante(iPiece);
        puits.setPieceSuivante(oPiece);
        String expected = "Puits : Dimension 10 x 20\n" + "Piece Actuelle : " + "IPiece :\n" +
                "\t(5, -4) - ROUGE\n" + "\t(5, -5) - ROUGE\n" + "\t(5, -6) - ROUGE\n" + "\t(5, -3) - ROUGE\n" +
                "Piece Suivante : " + "OPiece :\n" +
                "\t(0, 2) - ROUGE\n" + "\t(0, 1) - ROUGE\n" + "\t(1, 2) - ROUGE\n" + "\t(1, 1) - ROUGE\n";
        assertEquals(iPiece, puits.getPieceActuelle(), "Test de la pièce actuelle");
        assertEquals(expected, puits.toString(), "Test de la méthode toString");
    }

    @Test
    public void testToString() {
        Puits puits = new Puits();
        String expected = "Puits : Dimension 10 x 20\n" + "Piece Actuelle : <aucune>\n" +
                "Piece Suivante : <aucune>\n";
        assertEquals(expected, puits.toString(), "Test de la méthode toString");
    }

    @Test
    public void testToString2() {
        Puits puits = new Puits();
        IPiece iPiece = new IPiece(new Coordonnees(0, 2), Couleur.ROUGE);
        puits.setPieceSuivante(iPiece);
        String expected = "Puits : Dimension 10 x 20\n" + "Piece Actuelle : <aucune>\n" +
                "Piece Suivante : " + "IPiece :\n" +
                "\t(0, 2) - ROUGE\n" + "\t(0, 1) - ROUGE\n" + "\t(0, 0) - ROUGE\n" + "\t(0, 3) - ROUGE\n";
        assertEquals(expected, puits.toString(), "Test de la méthode toString");
    }
}
