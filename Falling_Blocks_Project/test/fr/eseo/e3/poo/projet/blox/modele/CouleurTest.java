package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CouleurTest {

    @Test
    public void testGetCouleurPourAffichage() {
        Couleur couleur = Couleur.ROUGE;
        assertEquals(Color.RED, couleur.getCouleurPourAffichage());

        couleur = Couleur.ORANGE;
        assertEquals(Color.ORANGE, couleur.getCouleurPourAffichage());

        couleur = Couleur.BLEU;
        assertEquals(Color.BLUE, couleur.getCouleurPourAffichage());

        couleur = Couleur.VERT;
        assertEquals(Color.GREEN, couleur.getCouleurPourAffichage());

        couleur = Couleur.JAUNE;
        assertEquals(Color.YELLOW, couleur.getCouleurPourAffichage());

        couleur = Couleur.CYAN;
        assertEquals(Color.CYAN, couleur.getCouleurPourAffichage());

        couleur = Couleur.VIOLET;
        assertEquals(Color.MAGENTA, couleur.getCouleurPourAffichage());
    }
}
