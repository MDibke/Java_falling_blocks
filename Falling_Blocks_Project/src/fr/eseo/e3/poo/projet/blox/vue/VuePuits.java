package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuits extends javax.swing.JPanel implements PropertyChangeListener {
    public static final int TAILLE_PAR_DEFAUT = 15;
    private Puits puits;
    private VuePiece vuePiece;
    private int taille;
    public PieceDeplacement pieceDeplacement;
    public PieceRotation pieceRotation;

    public VuePuits(Puits puits, int taille) {
        super();
        setPuits(puits);
        setTaille(taille);
        setBackground(java.awt.Color.WHITE);
        this.puits.addPropertyChangeListener(this);

        pieceDeplacement = new PieceDeplacement(this);
        pieceRotation = new PieceRotation(this);
        //ajout du MouseMotionListener
        this.addMouseMotionListener(pieceDeplacement);
        //ajout du MouseListener
        this.addMouseListener(pieceDeplacement);
        this.addMouseListener(pieceRotation);
        //ajout du MouseWheelListener
        this.addMouseWheelListener(pieceDeplacement);
    }

    public VuePuits(Puits puits) {
        this(puits,TAILLE_PAR_DEFAUT);
    }

    public VuePiece getVuePiece() {
        return this.vuePiece;
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
        super.paintComponent(g);
        /* appel vers super pour remplir le fond du JPanel */
        /*Le paramètre g est copie en utilisant la méthode copie()
         * puis converti en instance de Graphics2D grâce à
         * un transtypage (cast) explicite.
         */
        Graphics2D g2D = (Graphics2D) g.create();
        /* Nous utiliserons l'instance de Graphics2D*/

        // Set background color as white
        g2D.setColor(java.awt.Color.WHITE);
        g2D.fillRect(0, 0, getWidth(), getHeight());

        // Draw grid as light gray lines
        g2D.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < getWidth(); x += this.taille) {
            for (int y = 0; y < getHeight(); y += this.taille) {
                g2D.drawRect(x, y, this.taille, this.taille);
            }
        }

        if(this.vuePiece != null){
            this.vuePiece.afficherPiece(g2D);
        }

        /*Puis nous liberons la memoire*/
        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
            Piece nouvellePiece = (Piece) event.getNewValue();
            this.setVuePiece(new VuePiece(nouvellePiece, this.taille));
        }
    }
}
