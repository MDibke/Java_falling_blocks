package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_E;
import static javax.swing.SwingUtilities.isLeftMouseButton;
import static javax.swing.SwingUtilities.isRightMouseButton;

public class PieceRotation extends MouseAdapter implements MouseMotionListener, KeyListener {
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

    @Override
    public void keyTyped(KeyEvent key) {

    }

    @Override
    public void keyPressed(KeyEvent key) {
        if (key.getKeyCode() == VK_A) {
            try {
                this.puits.getPieceActuelle().tourner(false);
                this.vuePuits.repaint();
            } catch (Exception e) {
                System.out.println("Erreur lors du déplacement horizontal de la pièce");
            }
        }
        if (key.getKeyCode() == VK_E) {
            try {
                this.puits.getPieceActuelle().tourner(true);
                this.vuePuits.repaint();
            } catch (Exception e) {
                System.out.println("Erreur lors du déplacement vertical de la pièce");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {

    }
}
