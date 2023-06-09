package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsineDePieceTest {

    @Test
    public void testSetMode() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        assertEquals(UsineDePiece.ALEATOIRE_COMPLET, UsineDePiece.getMode(),
                "Test si le mode est bien ALEATOIRE_COMPLET");
    }

    @Test
    public void testSetMode2() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        assertEquals(UsineDePiece.ALEATOIRE_PIECE, UsineDePiece.getMode(),
                "Test si le mode est bien ALEATOIRE_COMPLET");
    }

    @Test
    public void testSetMode3() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        assertEquals(UsineDePiece.CYCLIC, UsineDePiece.getMode(),
                "Test si le mode est bien ALEATOIRE_COMPLET");
    }
    @Test
    public void testGenererPieceCyclic() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();
        Piece piece3 = UsineDePiece.genererPiece();
        assertTrue(piece1 instanceof OPiece, "Test si piece1 est une piece ce type OPiece");
        assertTrue(piece2 instanceof IPiece, "Test si piece2 est une piece ce type IPiece");
        assertTrue(piece3 instanceof OPiece, "Test si piece1 est une piece ce type OPiece");
    }

    @Test
    public void testGenererPieceComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Piece piece = UsineDePiece.genererPiece();
        assertTrue(piece instanceof OPiece || piece instanceof IPiece,
                "Test si piece est une piece de type OPiece ou IPiece");
    }

    @Test
    public void testGenererPiecePiece() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        Piece piece = UsineDePiece.genererPiece();
        assertTrue(piece instanceof OPiece || piece instanceof IPiece,
                "Test si piece est une piece de type OPiece ou IPiece");
    }

    @Test
    public void testGenererPiecePiece2() {
        Piece piece = UsineDePiece.genererPiece();
        assertTrue(piece instanceof OPiece || piece instanceof IPiece,
                "Test si piece est une piece de type OPiece ou IPiece");
    }
}
