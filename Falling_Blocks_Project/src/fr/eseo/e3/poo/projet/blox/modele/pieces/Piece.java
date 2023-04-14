package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private List<Element> elements = new ArrayList<>(4);
    protected Couleur couleur;
    protected Coordonnees coordonnees;

    public Piece(Coordonnees coordonnees, Couleur couleur) {
        this.couleur = couleur;
        this.coordonnees = coordonnees;
        this.setElements(this.coordonnees, this.couleur);
    }

    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    public List<Element> getElements() {
        return elements;
    }

    public void setPosition(int abscisse, int ordonnee) {
        this.coordonnees.setAbscisse(abscisse);
        this.coordonnees.setOrdonnee(ordonnee);
        this.setElements(this.coordonnees, this.couleur);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Element e : this.elements) {
            sb.append("\t");
            sb.append(e.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
