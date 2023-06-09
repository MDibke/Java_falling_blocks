package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPieceTest {
    @Test
    public void testGetElementsSize() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        List<Element> elements = iPiece.getElements();
        assertEquals(4, elements.size(), "Test de la taille de la liste d'éléments");
    }

    @Test
    public void testSetElements() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        List<Element> elements = iPiece.getElements();
        assertEquals(new Element(coordonnees, couleur), elements.get(0), "Test de l'élément 0");
        assertEquals(new Element(new Coordonnees(coordonnees.getAbscisse(),
                coordonnees.getOrdonnee() - 1), couleur), elements.get(1), "Test de l'élément 1");
        assertEquals(new Element(new Coordonnees(coordonnees.getAbscisse(),
                coordonnees.getOrdonnee() - 2), couleur), elements.get(2), "Test de l'élément 2");
        assertEquals(new Element(new Coordonnees(coordonnees.getAbscisse(),
                coordonnees.getOrdonnee() + 1), couleur), elements.get(3), "Test de l'élément 3");
    }

    @Test
    public void testToString() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        String expected = "IPiece :\n" +
                "\t(1, 2) - " + couleur + "\n" +
                "\t(1, 1) - " + couleur + "\n" +
                "\t(1, 0) - " + couleur + "\n" +
                "\t(1, 3) - " + couleur + "\n";
        assertEquals(expected, iPiece.toString(), "Test de la méthode toString");
    }

    @Test
    public void testSetPosition() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        List<Element> elements = iPiece.getElements();
        iPiece.setPosition(2,3);
        assertEquals(new Element(new Coordonnees(2, 3), couleur),
                elements.get(0), "Test de l'élément 0");
        assertEquals(new Element(new Coordonnees(2, 2), couleur),
                elements.get(1), "Test de l'élément 1");
        assertEquals(new Element(new Coordonnees(2, 1), couleur),
                elements.get(2), "Test de l'élément 2");
        assertEquals(new Element(new Coordonnees(2, 4), couleur),
                elements.get(3), "Test de l'élément 3");
    }

    @Test
    public void testGetPuits() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        assertEquals(null, iPiece.getPuits(), "Test du getPuits");
    }

    @Test
    public void testSetPuits() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        Puits puits = new Puits();
        iPiece.setPuits(puits);
        assertEquals(puits, iPiece.getPuits(), "Test du setPuits");
    }

    @Test
    public void testDeplacerDe() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        String expected = "IPiece :\n" +
                "\t(2, 3) - " + couleur + "\n" +
                "\t(2, 2) - " + couleur + "\n" +
                "\t(2, 1) - " + couleur + "\n" +
                "\t(2, 4) - " + couleur + "\n";
        try {
            iPiece.deplacerDe(1, 1);
        } catch (Exception e) {
            assertEquals("La nouvelle position doit être supérieure ou égale à zéro.", e.getMessage(),
                    "Test de la méthode deplacerDe avec 1 en x et 1 en y");
        }
        assertEquals(expected, iPiece.toString(), "Test de la méthode deplacerDe");
    }
    @Test
    public void testDeplacerDe2() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        try {
            iPiece.deplacerDe(1, -1);
        } catch (Exception e) {
            assertEquals("La nouvelle position doit être supérieure ou égale à zéro.", e.getMessage(),
                    "Test de la méthode deplacerDe avec 1 en x et -1 en y");
        }
    }

    @Test
    public void testDeplacerDe3() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        Puits puits = new Puits();
        iPiece.setPuits(puits);
        String expected = "IPiece :\n" +
                "\t(2, 3) - " + couleur + "\n" +
                "\t(2, 2) - " + couleur + "\n" +
                "\t(2, 1) - " + couleur + "\n" +
                "\t(2, 4) - " + couleur + "\n";
        try {
            iPiece.deplacerDe(1, 1);
        } catch (BloxException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, iPiece.toString(), "Test de la méthode deplacerDe");
    }

    @Test
    public void testDeplacerDe4() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        Puits puits = new Puits();
        iPiece.setPuits(puits);
        String expected = "IPiece :\n" +
                "\t(2, 3) - " + couleur + "\n" +
                "\t(2, 2) - " + couleur + "\n" +
                "\t(2, 1) - " + couleur + "\n" +
                "\t(2, 4) - " + couleur + "\n";
        try {
            iPiece.deplacerDe(1, 1);
        } catch (BloxException e) {
            throw new RuntimeException(e);
        }
        assertEquals(expected, iPiece.toString(), "Test de la méthode deplacerDe");
    }

    @Test
    public void testTourner() {
        	Coordonnees coordonnees = new Coordonnees(1, 2);
            Couleur couleur = Couleur.ROUGE;
            IPiece iPiece = new IPiece(coordonnees, couleur);
            String expected = "IPiece :\n" +
                    "\t(1, 2) - " + couleur + "\n" +
                    "\t(2, 2) - " + couleur + "\n" +
                    "\t(3, 2) - " + couleur + "\n" +
                    "\t(0, 2) - " + couleur + "\n";
            iPiece.tourner(true);
            assertEquals(expected, iPiece.toString(), "Test de la méthode tourner");
    }

    @Test
    public void testTourner2() {
        	Coordonnees coordonnees = new Coordonnees(1, 2);
            Couleur couleur = Couleur.ROUGE;
            IPiece iPiece = new IPiece(coordonnees, couleur);
            String expected = "IPiece :\n" +
                    "\t(1, 2) - " + couleur + "\n" +
                    "\t(0, 2) - " + couleur + "\n" +
                    "\t(-1, 2) - " + couleur + "\n" +
                    "\t(2, 2) - " + couleur + "\n";
            iPiece.tourner(false);
            assertEquals(expected, iPiece.toString(), "Test de la méthode tourner");
    }
}
