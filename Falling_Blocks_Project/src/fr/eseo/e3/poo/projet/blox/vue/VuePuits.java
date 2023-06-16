package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuits extends javax.swing.JPanel implements PropertyChangeListener {
    public static final int TAILLE_PAR_DEFAUT = 15;
    private Puits puits;
    private VuePiece vuePiece;
    private final VueTas vueTas;
    private int taille;
    public PieceDeplacement pieceDeplacement;
    public PieceRotation pieceRotation;
    private Gravite gravite;

    public VuePuits(Puits puits, int taille) {
        setPuits(puits);
        setTaille(taille);
        setBackground(java.awt.Color.WHITE);
        this.puits.addPropertyChangeListener(this);
        this.vueTas = new VueTas(this);

        pieceDeplacement = new PieceDeplacement(this);
        pieceRotation = new PieceRotation(this);

        //ajout du MouseMotionListener
        this.addMouseMotionListener(pieceDeplacement);

        //ajout du MouseListener
        this.addMouseListener(pieceDeplacement);
        this.addMouseListener(pieceRotation);

        //ajout du MouseWheelListener
        this.addMouseWheelListener(pieceDeplacement);

        //ajout du KeyListener
        this.addKeyListener(pieceRotation);
        this.addKeyListener(pieceDeplacement);

        this.setFocusable(true);
    }

    public VuePuits(Puits puits) {
        this(puits,TAILLE_PAR_DEFAUT);
    }

    public VuePiece getVuePiece() {
        return this.vuePiece;
    }

    public VueTas getVueTas() {
        return this.vueTas;
    }

    public Puits getPuits() {
        return this.puits;
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    public int getTaille() {
        return this.taille;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
        setPreferredSize(new Dimension(this.taille * this.puits.getLargeur(),
                this.taille * this.puits.getProfondeur()));
    }

    public void setTaille(int taille) {
        this.taille = taille;
        setPreferredSize(new Dimension(this.taille * this.puits.getLargeur(),
                this.taille * this.puits.getProfondeur()));
    }

    protected void paintComponent(Graphics g) {

        // Methode de Romain C. pour eviter le bug 3.7.2
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g.create();

        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, puits.getLargeur()*taille, puits.getProfondeur()*taille);

        g2D.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i<= puits.getLargeur(); i++){
            int x = i * taille;
            g2D.drawLine(x, 0, x, puits.getProfondeur() * taille);
        }
        for (int i = 0; i <= puits.getProfondeur(); i++) {
            int y = i * taille;
            g2D.drawLine(0, y, puits.getLargeur() * taille, y);
        }

        if (getVuePiece()!= null) {
            getVuePiece().afficherPiece(g2D);
        }

        if (this.vueTas!= null){
            this.vueTas.afficher(g2D);
        }

        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
            Piece nouvellePiece = (Piece) event.getNewValue();
            this.setVuePiece(new VuePiece(nouvellePiece, this.taille));
        }
    }

    public void setGravite(Gravite gravite) {
        this.gravite = gravite;
        this.puits.setGravite(gravite);
    }
}
