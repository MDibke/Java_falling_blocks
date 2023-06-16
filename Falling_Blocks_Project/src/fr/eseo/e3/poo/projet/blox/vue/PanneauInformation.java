package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {

    private Puits puits;
    private int taille;
    private VuePiece vuePiece;

    public PanneauInformation(Puits puits) {
            setPuits(puits);
            setTaille(70);
            this.puits.addPropertyChangeListener(this);
        }

    public void setPuits(Puits puits) {
        this.puits = puits;
        setPreferredSize(new Dimension(this.taille * this.puits.getLargeur(),
                this.taille * this.puits.getProfondeur()));
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    public void setTaille(int taille) {
        this.taille = taille;
        setPreferredSize(new Dimension(this.taille,
                this.taille));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        if (this.vuePiece != null) {
            this.vuePiece.afficherPiece(g2D);
            repaint();
        }

        VueScore.afficherScore(g2D);

        /*Puis nous liberons la memoire*/
        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
            Piece nouvellePiece = (Piece) event.getNewValue();
            this.setVuePiece(new VuePiece(nouvellePiece, 10));
        }
    }
}
