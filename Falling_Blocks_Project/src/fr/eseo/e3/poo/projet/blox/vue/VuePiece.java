package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Color;
import java.awt.Graphics2D;

public class VuePiece {
    public static final double MULTIPLIER_TEINTE = 0.3;

    private final int taille;

    private final Piece piece;

    public VuePiece(Piece piece, int taille) {
        this.taille = taille;
        this.piece = piece;
    }

    public Color teinte(Color couleur) {
        return new Color(
                (int) (couleur.getRed() + (255 - couleur.getRed()) * MULTIPLIER_TEINTE),
                (int) (couleur.getGreen() + (255 - couleur.getGreen()) * MULTIPLIER_TEINTE),
                (int) (couleur.getBlue() + (255 - couleur.getBlue()) * MULTIPLIER_TEINTE)
        );
    }

    public void afficherPiece(Graphics2D g2D) {
        int point0 = 0;
        for (Element elements : this.piece.getElements()){
            if(point0 == 0){
                g2D.setColor(teinte(elements.getCouleur().getCouleurPourAffichage()));
            }else {
                g2D.setColor(elements.getCouleur().getCouleurPourAffichage());
            }
            point0++;
            g2D.fill3DRect(
                    elements.getCoordonnees().getAbscisse() * this.taille,
                    elements.getCoordonnees().getOrdonnee() * this.taille,
                    this.taille,
                    this.taille,
                    true
            );
        }

    }
}