package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_Q;
import static java.awt.event.KeyEvent.VK_S;

public class PieceDeplacement extends MouseAdapter implements MouseMotionListener, KeyListener {
    private VuePuits vuePuits;
    private Puits puits;
    private int derniereColonne;


    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.derniereColonne = -100;
    }

    public void mouseMoved(MouseEvent event) {
        int nouvelleColonne = event.getX() / this.vuePuits.getTaille();
        if (this.puits.getPieceActuelle() != null) {
            if(this.derniereColonne == -100) {
                this.derniereColonne = nouvelleColonne;
            } else if (this.derniereColonne != event.getX()) {
                try {
                    int deltaDeplacement = nouvelleColonne - this.derniereColonne;
                    this.puits.getPieceActuelle().deplacerDe(deltaDeplacement, 0);
                    this.derniereColonne = nouvelleColonne;
                    this.vuePuits.repaint();
                } catch (Exception e) {
                    System.out.println("Erreur lors du déplacement horizontal de la pièce");
                }
            }
            this.vuePuits.repaint();
        }
    }

    public void mouseDragged(MouseEvent event) {
        // Implémentation facultative de la méthode mouseDragged si nécessaire
    }

    public void mouseExited(MouseEvent event){

    }

    public void mousePressed(MouseEvent event){

    }

    public void mouseReleased(MouseEvent event){

    }

    public void mouseClicked(MouseEvent event){

    }

    public void mouseEntered(MouseEvent event) {
        // Implémentation facultative de la méthode mouseEntered si nécessaire
        this.derniereColonne = -100;
    }


    public void mouseWheelMoved(MouseWheelEvent event) {
        // Implémentation facultative de la méthode mouseExited si nécessaire
        if(this.puits.getPieceActuelle() != null) {
            int whellRotation = event.getWheelRotation();
            if(whellRotation > 0) {
                try {
                    this.puits.getPieceActuelle().deplacerDe(0,whellRotation);
                    this.vuePuits.repaint();
                } catch (Exception e) {
                    System.out.println("Erreur lors du déplacement vertical de la pièce");
                }
            }
            this.vuePuits.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent key) {

    }

    @Override
    public void keyPressed(KeyEvent key) {
        int deltaX = 0;
        int deltaY = 0;

        if (key.getKeyCode() == VK_Q) {
            deltaX = -1;
            deltaY = 0;
        }
        if (key.getKeyCode() == VK_D) {
            deltaX = 1;
            deltaY = 0;
        }
        if (key.getKeyCode() == VK_S) {
            deltaX = 0;
            deltaY = 1;
        }
        if(key.getKeyCode() == KeyEvent.VK_SPACE) {
            boolean toucherFond = false;
            while(!toucherFond) {
                try {
                    this.puits.getPieceActuelle().deplacerDe(0, 1);
                    this.vuePuits.repaint();
                } catch (Exception e) {
                    toucherFond = true;
                }
            }
        }

        try {
            this.puits.getPieceActuelle().deplacerDe(deltaX, deltaY);
            this.vuePuits.repaint();
        } catch (Exception e) {
            System.out.println("Erreur lors du déplacement de la pièce");
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {

    }
}
