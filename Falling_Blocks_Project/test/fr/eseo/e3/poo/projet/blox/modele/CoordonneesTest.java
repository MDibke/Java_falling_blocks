package fr.eseo.e3.poo.projet.blox.modele;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordonneesTest {
    @Test
    public void deplacerVersTest() {
        Coordonnees c = new Coordonnees(0, 0);
        c.setAbscisse(1);
        c.setOrdonnee(1);
        assertEquals(1, c.getAbscisse());
        assertEquals(1, c.getOrdonnee());
    }
    @Test
    public void deplacerDeTest() {
        Coordonnees c = new Coordonnees(0, 0);
        c.setAbscisse(1);
        c.setOrdonnee(1);
        assertEquals(1, c.getAbscisse());
        assertEquals(1, c.getOrdonnee());
    }

    @Test
    public void equalsTest() {
        Coordonnees c1 = new Coordonnees(0, 0);
        Coordonnees c2 = new Coordonnees(1, 1);
        assertEquals(false, c1.equals(c2));
    }
    @Test
    public void hashCodeTest() {
        Coordonnees c1 = new Coordonnees(0, 0);
        assertEquals(961, c1.hashCode());
    }
    @Test
    public void toStringTest() {
        Coordonnees c1 = new Coordonnees(0, 0);
        assertEquals("(0, 0)", c1.toString());
    }
}
