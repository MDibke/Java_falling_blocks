package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VuePieceTest {
    @Test
    public void testAfficherPiece() {
        Piece piece = new IPiece(new Coordonnees(0, 0), Couleur.ROUGE);
        VuePiece vuePiece = new VuePiece(piece, 5);
        assertEquals(new Color(255, 76,76), vuePiece.teinte(piece.getElements().get(0).getCouleur().getCouleurPourAffichage()));
    }
}
