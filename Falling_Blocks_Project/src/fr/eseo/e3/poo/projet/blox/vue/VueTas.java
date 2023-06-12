package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueTas {
    public static final double MULTIPLIER_NUANCE = 0.5;
    private final VuePuits vuePuits;
    private final Tas tas;
    public VueTas(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.tas = this.vuePuits.getPuits().getTas();
    }

    public Color nuance(Color couleur) {
        return new Color(
                (int)(couleur.getRed() * (1-MULTIPLIER_NUANCE)),
                (int)(couleur.getGreen() * (1-MULTIPLIER_NUANCE)),
                (int)(couleur.getBlue() * (1-MULTIPLIER_NUANCE)));
    }

    public void afficher(Graphics2D g2D) {
        for (Element[] elementsLigne : this.tas.getElements()) {
            for (Element element : elementsLigne) {
                if(element != null) {
                    g2D.setColor(nuance(element.getCouleur().getCouleurPourAffichage()));

                    g2D.fill3DRect(
                            element.getCoordonnees().getAbscisse() * this.vuePuits.getTaille(),
                            element.getCoordonnees().getOrdonnee() * this.vuePuits.getTaille(),
                            this.vuePuits.getTaille(),
                            this.vuePuits.getTaille(),
                            true
                    );
                }
            }
        }
    }

    public VuePuits getVuePuits() {
        return this.vuePuits;
    }
}
