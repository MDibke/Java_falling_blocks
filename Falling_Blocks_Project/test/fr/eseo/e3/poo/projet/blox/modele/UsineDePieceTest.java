package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        Piece piece;
        for(int i = 0; i < 7 ; i++) {
            piece = UsineDePiece.genererPiece();
            testGenererPieceCyclic(piece,i);
        }
    }

    private void testGenererPieceCyclic(Piece piece,int i) {
        switch (i) {
            case 0:
                assertTrue(piece instanceof OPiece, "Test si piece est une piece de type OPiece");
                break;
            case 1:
                assertTrue(piece instanceof IPiece, "Test si piece est une piece de type IPiece");
                break;
            case 2:
                assertTrue(piece instanceof TPiece, "Test si piece est une piece de type TPiece");
                break;
            case 3:
                assertTrue(piece instanceof LPiece, "Test si piece est une piece de type LPiece");
                break;
            case 4:
                assertTrue(piece instanceof JPiece, "Test si piece est une piece de type SPiece");
                break;
            case 5:
                assertTrue(piece instanceof ZPiece, "Test si piece est une piece de type SPiece");
                break;
            default:
                assertTrue(piece instanceof SPiece, "Test si piece est une piece de type SPiece");
                break;
        }
    }

    @Test
    public void testGenererPieceComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Piece piece = UsineDePiece.genererPiece();
        assertNotNull(piece, "Test si piece est une piece de type Piece");
    }

    @Test
    public void testGenererPiecePiece() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        Piece piece = UsineDePiece.genererPiece();
        assertNotNull(piece, "Test si piece est une piece de type Piece");
    }

    @Test
    public void testGenererPiecePiece2() {
        Piece piece = UsineDePiece.genererPiece();
        assertNotNull(piece, "Test si piece est une piece de type Piece");
    }
}
