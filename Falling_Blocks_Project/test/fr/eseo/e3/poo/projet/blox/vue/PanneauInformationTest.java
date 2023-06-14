package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PanneauInformationTest {
    @Test
    public void PanneauInformation() {
        PanneauInformation panneauInformation = new PanneauInformation(new Puits(10, 20));
        assertTrue(panneauInformation.getPreferredSize().getWidth() == 70);
    }
}
