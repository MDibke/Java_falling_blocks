package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import org.junit.jupiter.api.Test;

public class GraviteTest {
    @Test
    public void testConstructor() throws BloxException {
        Puits puits = new Puits();
        Piece piece1 = UsineDePiece.genererPiece();
        Piece piece2 = UsineDePiece.genererPiece();
        puits.setPieceSuivante(piece1);
        puits.setPieceSuivante(piece2);
        piece1.setPuits(puits);
        piece2.setPuits(puits);
        piece1.setPosition(puits.getLargeur()/2, 1 );
        piece2.setPosition(puits.getLargeur()/2, 1 );
        for(int i = 0; i < 20; i++) {
            try {
                puits.gravite();
            } catch (BloxException e) {
                e.printStackTrace();
            }
        }
    }
}
