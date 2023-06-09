package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        assertEquals(Couleur.ROUGE, element.getCouleur(), "Test de la couleur par défaut");
    }

    @Test
    public void testElement4() {
        Element element = new Element(new Coordonnees(1, 2), Couleur.BLEU);
        assertEquals(new Coordonnees(1, 2), element.getCoordonnees());
        assertEquals(Couleur.BLEU, element.getCouleur(), "Test de la couleur définie");
    }

    @Test
    public void testElement5() {
        Element element = new Element(1, 2);
        element.setCoordonnees(new Coordonnees(3, 4));
        assertEquals(new Coordonnees(3, 4), element.getCoordonnees(), "Test de la méthode setCoordonnees");
    }

    @Test
    public void testElement6() {
        Element element = new Element(1, 2);
        element.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU, element.getCouleur(), "Test de la méthode setCouleur");
    }

    @Test
    public void testToString() {
        Element element = new Element(1, 2);
        assertEquals("(1, 2) - ROUGE", element.toString(), "Test de la méthode toString");
    }

    @Test
    public void testToString2() {
        Element element = new Element(1, 2, Couleur.BLEU);
        assertEquals("(1, 2) - BLEU", element.toString(), "Test de la méthode toString");
    }

    @Test
    public void testEquals() {
        Element element = new Element(1, 2);
        Element element2 = new Element(1, 2);
        assertEquals(element, element2, "Test de la méthode equals");
    }

    @Test
    public void testEquals2() {
        Element element = new Element(1, 2);
        Element element2 = new Element(1, 3);
        assertNotEquals(element, element2, "Test de la méthode equals");
    }

    @Test
    public void testEquals3() {
        Element element = new Element(1, 2);
        Element element2 = new Element(1, 2, Couleur.BLEU);
        assertNotEquals(element, element2, "Test de la méthode equals");
    }

    @Test
    public void testEquals4() {
        Element element = new Element(1, 2, Couleur.ROUGE);
        Element element2 = new Element(1, 2, Couleur.ROUGE);
        assertEquals(element, element2, "Test de la méthode equals");
    }

    @Test
    public void hashCodeTest() {
        Coordonnees coordonnees = new Coordonnees(1, 2);
        Element element = new Element(coordonnees, Couleur.BLEU);
        Element element2 = new Element(coordonnees, Couleur.BLEU);
        assertEquals(element.hashCode(), element2.hashCode(), "Test de la méthode hashCode");
    }

    @Test
    public void testDeplacerDe() {
        Element element = new Element(1, 2);
        element.deplacerDe(1, 0);
        assertEquals(new Coordonnees(1 + 1, 2 + 0), element.getCoordonnees(),
                "Test de la méthode deplacerDe");
        try {
            Element element2 = new Element(1, 2);
            element2.deplacerDe(2, -2);
            assertEquals(new Coordonnees(1 + 2, 2 - 2), element2.getCoordonnees(),
                    "Test de la méthode deplacerDe");
        } catch (Exception e) {
            assertEquals("Le déplacement doit être de 1 ou -1", e.getMessage(),
                    "Test de la méthode deplacerDe");
        }
    }

    public static class TasTest {
        @Test
        public void testGetPuits() {
            // Création d'un puits
            Puits puits = new Puits();

            // Création d'un tas avec 10 éléments répartis sur 3 lignes
            Tas tas = new Tas(puits, 10, 3);

            // Vérification du puits associé au tas
            assertEquals(puits, tas.getPuits());
        }

        @Test
        public void testGetElements() {
            // Création d'un puits
            Puits puits = new Puits();

            // Création d'un tas avec 10 éléments répartis sur 3 lignes
            Tas tas = new Tas(puits, 10, 3);

            // Vérification des éléments du tas
            Element[][] elements = tas.getElements();
            assertEquals(puits.getProfondeur(), elements.length);
            assertEquals(puits.getLargeur(), elements[0].length);
        }
    }
}


