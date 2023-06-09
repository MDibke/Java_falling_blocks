package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Dimension;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VuePuitsTest {

    private VuePuits vuePuits;
    private Puits puits;

    @Test
    public void testConstructeur1() {
        this.puits = new Puits();
        this.vuePuits = new VuePuits(this.puits);
        assertEquals(this.puits, this.vuePuits.getPuits(),
                "Test du constructeur VuePuits(Puits)");
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, this.vuePuits.getTaille(),
                "Test du constructeur VuePuits(Puits)");
        assertEquals(new Dimension(VuePuits.TAILLE_PAR_DEFAUT * puits.getLargeur(),
                        VuePuits.TAILLE_PAR_DEFAUT * puits.getProfondeur()),
                this.vuePuits.getPreferredSize(), "Test du constructeur VuePuits(Puits)");
    }

    @Test
    public void testConstructeur2() {
        this.puits = new Puits();
        int taille = 30;
        this.vuePuits = new VuePuits(this.puits, taille);
        assertEquals(this.puits, this.vuePuits.getPuits(),
                "Test du constructeur VuePuits(Puits, int)");
        assertEquals(taille, this.vuePuits.getTaille(),
                "Test du constructeur VuePuits(Puits, int)");
        assertEquals(new Dimension(taille * puits.getLargeur(), taille * puits.getProfondeur()), this.vuePuits.getPreferredSize(),
                "Test du constructeur VuePuits(Puits, int)");
    }

    @BeforeEach
    public void setUp() {
        this.puits = new Puits();
        this.vuePuits = new VuePuits(this.puits);
    }

    @Test
    public void testGetPuits() {
        assertEquals(this.puits, this.vuePuits.getPuits(), "Test de la méthode getPuits()");
    }

    @Test
    public void testGetTaille() {
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, this.vuePuits.getTaille(), "Test de la méthode getTaille()");
    }

    @Test
    public void testSetPuits() {
        Puits newPuits = new Puits(8,16);
        this.vuePuits.setPuits(newPuits);
        assertEquals(newPuits, this.vuePuits.getPuits(), "Test de la méthode setPuits()");
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT,vuePuits.getTaille(), "Test de la méthode setPuits()");
    }

    @Test
    public void testSetTaille() {
        int newTaille = 30;
        this.vuePuits.setTaille(newTaille);
        assertEquals(newTaille, this.vuePuits.getTaille(), "Test de la méthode setTaille()");
    }
}
