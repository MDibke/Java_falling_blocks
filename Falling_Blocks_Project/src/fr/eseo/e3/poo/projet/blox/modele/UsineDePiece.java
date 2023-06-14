package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

import java.util.Random;

public class UsineDePiece {
    public static final int CYCLIC = 1;
    public static final int ALEATOIRE_COMPLET = 2;
    public static final int ALEATOIRE_PIECE = 3;
    private static final int NOMBRE_PIECE = 7;
    private static Random random = new Random();
    private static int modeSelect = ALEATOIRE_PIECE;
    private static int pieceCycleSelector = 0;

    private UsineDePiece() {
    }

    public static void setMode(int mode) {
        UsineDePiece.modeSelect = mode;
        if(mode == CYCLIC) {
            pieceCycleSelector = 0;
        }
    }

    public static int getMode() {
        return UsineDePiece.modeSelect;
    }

    public static Piece genererPiece() {
        Piece pieceReturned;
        switch (modeSelect) {
            case CYCLIC:
                pieceReturned = pieceSelector(pieceCycleSelector, null, true);
                break;
            case ALEATOIRE_COMPLET:
                pieceReturned = genererPieceAleatoire(randomCouleur());
                break;
            default:
                pieceReturned = genererPieceAleatoire(null);
                break;
        }
        return pieceReturned;
    }

    private static Piece genererPieceAleatoire(Couleur colorPiece) {
        int randomPiece = random.nextInt(NOMBRE_PIECE);
        return pieceSelector(randomPiece, colorPiece, false);
    }

    private static Piece pieceSelector(int randomPiece, Couleur colorPiece, boolean cyclicMode) {
        Coordonnees initialCoordonnees = new Coordonnees(2, 3);
        Piece returnPiece;
        switch (randomPiece) {
            case 0:
                pieceCycleSelector = 1;
                returnPiece = new OPiece(initialCoordonnees, colorSelector(colorPiece, Couleur.ROUGE));
                break;
            case 1:
                pieceCycleSelector = 2;
                returnPiece = new IPiece(initialCoordonnees, colorSelector(colorPiece, Couleur.ORANGE));
                break;
            case 2:
                pieceCycleSelector = 3;
                returnPiece = new TPiece(initialCoordonnees, colorSelector(colorPiece, Couleur.BLEU));
                break;
            case 3:
                pieceCycleSelector = 4;
                returnPiece = new LPiece(initialCoordonnees, colorSelector(colorPiece, Couleur.VERT));
                break;
            case 4:
                pieceCycleSelector = 5;
                returnPiece = new JPiece(initialCoordonnees, colorSelector(colorPiece, Couleur.JAUNE));
                break;
            case 5:
                pieceCycleSelector = 6;
                returnPiece = new ZPiece(initialCoordonnees, colorSelector(colorPiece, Couleur.CYAN));
                break;
            default:
                pieceCycleSelector = 0;
                returnPiece = new SPiece(initialCoordonnees, colorSelector(colorPiece, Couleur.VIOLET));
                break;
        }
        return returnPiece;
    }

    private static Couleur colorSelector(Couleur colorPiece, Couleur couleur) {
        if(colorPiece == null)
            return couleur;
        else
            return colorPiece;
    }

    private static Couleur randomCouleur() {
        int randomColor = random.nextInt(7);
        Couleur couleur;
        switch (randomColor) {
            case 0:
                couleur = Couleur.ROUGE;
                break;
            case 1:
                couleur = Couleur.ORANGE;
                break;
            case 2:
                couleur = Couleur.BLEU;
                break;
            case 3:
                couleur = Couleur.VERT;
                break;
            case 4:
                couleur = Couleur.JAUNE;
                break;
            case 5:
                couleur = Couleur.CYAN;
                break;
            default:
                couleur = Couleur.VIOLET;
                break;
        }
        return couleur;
    }
}
