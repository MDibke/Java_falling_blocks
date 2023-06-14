package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gravite implements ActionListener {
    private final VuePuits vuePuits;
    private final Puits puits;
    private Timer timer;

    private int periodicite;

    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        setPeriodicite(1000);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            this.puits.gravite();
        } catch (BloxException e) {
            throw new RuntimeException(e);
        }
        this.vuePuits.repaint();
    }

    public void setPeriodicite(int periode) {
        this.periodicite = periode;
        this.timer = new Timer(periodicite, this);
        this.timer.start();
    }

    public int getPeriodicite() {
        return this.periodicite;
    }


}
