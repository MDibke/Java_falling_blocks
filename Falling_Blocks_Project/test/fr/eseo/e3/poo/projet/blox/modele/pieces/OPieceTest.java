package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OPieceTest {
    @Test
    public void testGetElementsSize() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        OPiece oPiece = new OPiece(coordonnees, couleur);
        List<Element> elements = oPiece.getElements();
        assertEquals(4, elements.size(), "Test de la taille de la liste d'éléments");
    }

    @Test
    public void testSetElements() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        OPiece oPiece = new OPiece(coordonnees, couleur);
        List<Element> elements = oPiece.getElements();
        assertEquals(new Element(coordonnees, couleur), elements.get(0), "Test de l'élément 0");
        assertEquals(new Element(new Coordonnees(coordonnees.getAbscisse(),
                coordonnees.getOrdonnee() - 1), couleur), elements.get(1), "Test de l'élément 1");
        assertEquals(new Element(new Coordonnees(coordonnees.getAbscisse() + 1,
                coordonnees.getOrdonnee()), couleur), elements.get(2), "Test de l'élément 2");
        assertEquals(new Element(new Coordonnees(coordonnees.getAbscisse() + 1,
                coordonnees.getOrdonnee() - 1), couleur), elements.get(3), "Test de l'élément 3");
    }

    @Test
    public void testToString() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        OPiece oPiece = new OPiece(coordonnees, couleur);
        String expected = "OPiece :\n" +
                "\t(1, 2) - " + couleur + "\n" +
                "\t(1, 1) - " + couleur + "\n" +
                "\t(2, 2) - " + couleur + "\n" +
                "\t(2, 1) - " + couleur + "\n";
        assertEquals(expected, oPiece.toString(), "Test de la méthode toString");
    }

    @Test
    public void testSetPosition() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        OPiece oPiece = new OPiece(coordonnees, couleur);
        Coordonnees coordonnees2 = new Coordonnees(3, 4);
        List<Element> elements = oPiece.getElements();
        oPiece.setPosition(coordonnees2.getAbscisse(), coordonnees2.getOrdonnee());
        assertEquals(new Element(coordonnees2, couleur), elements.get(0), "Test de l'élément 0");
        assertEquals(new Element(new Coordonnees(coordonnees2.getAbscisse(),
                coordonnees2.getOrdonnee() - 1), couleur), elements.get(1), "Test de l'élément 1");
        assertEquals(new Element(new Coordonnees(coordonnees2.getAbscisse() + 1,
                coordonnees2.getOrdonnee()), couleur), elements.get(2), "Test de l'élément 2");
        assertEquals(new Element(new Coordonnees(coordonnees2.getAbscisse() + 1,
                coordonnees2.getOrdonnee() - 1), couleur), elements.get(3), "Test de l'élément 3");
    }

    @Test
    public void testGetPuits() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        OPiece oPiece = new OPiece(coordonnees, couleur);
        assertEquals(null, oPiece.getPuits(), "Test du getPuits");
    }

    @Test
    public void testSetPuits() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        OPiece oPiece = new OPiece(coordonnees, couleur);
        Puits puits = new Puits();
        oPiece.setPuits(puits);
        assertEquals(puits, oPiece.getPuits(), "Test du setPuits");
    }

    @Test
    public void testTourner() {
    	Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        OPiece oPiece = new OPiece(coordonnees, couleur);
        OPiece oPiceRef = oPiece;
        oPiece.tourner(true);
        assertEquals(oPiceRef.toString(), oPiece.toString(), "Test de l'orientation");
    }

    @Test
    public void testTourner2() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        OPiece oPiece = new OPiece(coordonnees, couleur);
        OPiece oPiceRef = oPiece;
        oPiece.tourner(false);
        assertEquals(oPiceRef.toString(), oPiece.toString(), "Test de l'orientation");
    }
}