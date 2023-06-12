package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

public class PieceRotation extends MouseAdapter implements MouseMotionListener {
    private VuePuits vuePuits;
    private Puits puits;
    boolean rotationSensHoraire = false;
    public PieceRotation(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    public void mouseClicked(MouseEvent event) {
        if(this.puits.getPieceActuelle() != null) {
            if(isLeftMouseButton(event)) {
                this.rotationSensHoraire = false;
            } else if(isRightMouseButton(event)) {
                this.rotationSensHoraire = true;
            }
            try {
                this.puits.getPieceActuelle().tourner(rotationSensHoraire);
                this.vuePuits.repaint();
            } catch (Exception e) {
                System.out.println("Erreur lors de la rotation de la pièce");
            }
            this.vuePuits.repaint();
        }
    }
}
