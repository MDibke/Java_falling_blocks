package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {
    @Test
    public void testElement1() {
        Element element = new Element(1, 2);
        assertEquals(1, element.getCoordonnees().getAbscisse());
        assertEquals(2, element.getCoordonnees().getOrdonnee());
    }

    @Test
    public void testElement2() {
        Element element = new Element(1, 2, Couleur.BLEU);
        assertEquals(1, element.getCoordonnees().getAbscisse());
        assertEquals(2, element.getCoordonnees().getOrdonnee());
        assertEquals(Couleur.BLEU, element.getCouleur());
    }

    @Test
    public void testElement3() {
        Element element = new Element(new Coordonnees(1, 2));
        assertEquals(new Coordonnees(1, 2), element.getCoordonnees());
        assertEquals(Couleur.ROUGE, element.getCouleur());
    }

    @Test
    public void testElement4() {
        Element element = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        assertEquals(new Coordonnees(1, 2), element.getCoordonnees());
        assertEquals(Couleur.BLEU, element.getCouleur());
    }

    @Test
    public void testElement5() {
        Element element = new Element(1, 2);
        element.setCoordonnees(new Coordonnees(3, 4));
        assertEquals(new Coordonnees(3, 4), element.getCoordonnees());
    }

    @Test
    public void testElement6() {
        Element element = new Element(1, 2);
        element.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU, element.getCouleur());
    }

    @Test
    public void testToString() {
        Element element = new Element(1, 2);
        assertEquals("(1, 2) - ROUGE", element.toString());
    }

    @Test
    public void testToString2() {
        Element element = new Element(1, 2, Couleur.BLEU);
        assertEquals("(1, 2) - BLEU", element.toString());
    }

    @Test
    public void testEquals() {
        Element element = new Element(1, 2);
        Element element2 = new Element(1, 2);
        assertEquals(true, element.equals(element2));
    }

    @Test
    public void testEquals2() {
        Element element = new Element(1, 2);
        Element element2 = new Element(1, 3);
        assertEquals(false, element.equals(element2));
    }

    @Test
    public void testEquals3() {
        Element element = new Element(1, 2);
        Element element2 = new Element(1, 2, Couleur.BLEU);
        assertEquals(false, element.equals(element2));
    }

    @Test
    public void testEquals4() {
        Element element = new Element(1, 2, Couleur.ROUGE);
        Element element2 = new Element(1, 2, Couleur.ROUGE);
        assertEquals(true, element.equals(element2));
    }

    @Test
    public void hashCodeTest() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees, Couleur.BLEU);
        Element element2 = new Element(coordonnees, Couleur.BLEU);
        assertEquals(element.hashCode(), element2.hashCode(), "Test de la méthode hashCode");
    }
}
