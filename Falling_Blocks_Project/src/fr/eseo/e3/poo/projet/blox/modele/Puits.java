package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static fr.eseo.e3.poo.projet.blox.modele.UsineDePiece.genererPiece;

public class Puits {
    public static final int LARGEUR_PAR_DEFAUT = 10;
    private int nbElements;
    private int nbLignes;
    private int largeur;
    public static final int PROFONDEUR_PAR_DEFAUT = 20;
    private int profondeur;
    private Piece pieceActuelle;
    public static final String MODIFICATION_PIECE_ACTUELLE = "modification_piece_actuelle";
    private Piece pieceSuivante;
    public static final String MODIFICATION_PIECE_SUIVANTE = "modification_piece_suivante";
    private PropertyChangeSupport pcs;
    private Tas tas;

    public Puits(int largeur, int profondeur) {
        this(largeur, profondeur,0,0);
    }
    public Puits() {
        this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT,0,0);
    }

    public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
        setProfondeur(profondeur);
        setLargeur(largeur);
        this.nbElements = nbElements;
        this.nbLignes = nbLignes;
        this.pcs = new PropertyChangeSupport(this);
        this.tas = new Tas(this, this.nbElements, this.nbLignes);
    }

    public Piece getPieceActuelle() {
        return this.pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return this.pieceSuivante;
    }

    public int getProfondeur() {
        return this.profondeur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public Tas getTas() {
        return this.tas;
    }

    public int getNbElements() {
        return this.nbElements;
    }

    public int getNbLignes() {
        return this.nbLignes;
    }

    public void setPieceSuivante(Piece pieceSuivante) {
        Piece anciennePieceActuelle = this.pieceActuelle;
        if (this.pieceSuivante != null) {
            this.pieceActuelle = this.pieceSuivante;
            this.pieceActuelle.setPosition(this.largeur / 2, -4);
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, anciennePieceActuelle, this.pieceActuelle);
        }
        Piece anciennePieceSuivante = this.pieceSuivante;
        this.pieceSuivante = pieceSuivante;
        this.pieceSuivante.setPuits(this);
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, anciennePieceSuivante, this.pieceSuivante);
    }

    public void setProfondeur(int profondeur) {
        if(profondeur >= 15 && profondeur <= 25)
            this.profondeur = profondeur;
        else
            throw new IllegalArgumentException("La profondeur doit être comprise entre 15 et 25");
    }

    public void setLargeur(int largeur) {
        if(largeur >= 5 && largeur <= 15)
            this.largeur = largeur;
        else
            throw new IllegalArgumentException("La largeur doit être comprise entre 5 et 15");
    }

    public void setTas(Tas tas) {
        this.tas = tas;
    }

    public void setNbElements(int nbElements) {
        this.nbElements = nbElements;
    }

    public void setNbLignes(int nbLignes) {
        this.nbLignes = nbLignes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Puits : Dimension " + this.largeur + " x " + this.profondeur + "\n");
        if(this.pieceActuelle != null)
            sb.append("Piece Actuelle : " + this.pieceActuelle.toString());
        else
            sb.append("Piece Actuelle : <aucune>\n");
        if(this.pieceSuivante != null)
            sb.append("Piece Suivante : " + this.pieceSuivante.toString());
        else
            sb.append("Piece Suivante : <aucune>\n");
        return sb.toString();
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    private void gererCollision () {
        this.tas.ajouterElements(pieceActuelle);
        this.setPieceSuivante(genererPiece());
    }

    public void gravite() throws BloxException {
        try {
            this.pieceActuelle.deplacerDe(0, 1);
        } catch (BloxException event) {
            if (event.getType() == BloxException.BLOX_COLLISION) {
                gererCollision();
            } else {
                throw event;
            }
        }
    }
}
