package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasTest {

    private int getNbElements(Tas tas) {
        Element[][] elements = tas.getElements();
        int nbElements = 0;

        // Get the total number of instanced elements in the two-dimensional array
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[i].length; j++) {
                if (elements[i][j] != null) nbElements++;
            }
        }
        return nbElements;
    }

    @Test
    public void testTas() {
        // Création d'un puits
        Puits puits = new Puits();

        // Création d'un tas avec 10 éléments répartis sur 3 lignes
        Tas tas = new Tas(puits);

        assertEquals(0, getNbElements(tas), "Test du nombre d'éléments du tas");
    }

    @Test
    public void testTas2() {
        // Création d'un puits
        Puits puits = new Puits();

        // Création d'un tas avec 10 éléments répartis sur 3 lignes
        Tas tas = new Tas(puits, 10);

        assertEquals(10, getNbElements(tas), "Test du nombre d'éléments du tas");
    }

    @Test
    public void testTas3() {
        // Création d'un puits
        Puits puits = new Puits();

        // Création d'un tas avec 10 éléments répartis sur 3 lignes
        Tas tas = new Tas(puits,10,4);

        assertEquals(10, getNbElements(tas), "Test du nombre d'éléments du tas");
    }

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
