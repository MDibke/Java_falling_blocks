package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
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
        assertEquals(4, elements.size());
    }

    @Test
    public void testSetElements() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        List<Element> elements = iPiece.getElements();
        assertEquals(new Element(coordonnees, couleur), elements.get(0));
        assertEquals(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1), couleur), elements.get(1));
        assertEquals(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 2), couleur), elements.get(2));
        assertEquals(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1), couleur), elements.get(3));
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
        assertEquals(expected, iPiece.toString());
    }

    @Test
    public void testSetPosition() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Couleur couleur = Couleur.ROUGE;
        IPiece iPiece = new IPiece(coordonnees, couleur);
        List<Element> elements = iPiece.getElements();
        iPiece.setPosition(2,3);
        assertEquals(new Element(new Coordonnees(2, 3), couleur), elements.get(0));
        assertEquals(new Element(new Coordonnees(2, 2), couleur), elements.get(1));
        assertEquals(new Element(new Coordonnees(2, 1), couleur), elements.get(2));
        assertEquals(new Element(new Coordonnees(2, 4), couleur), elements.get(3));
    }
}
