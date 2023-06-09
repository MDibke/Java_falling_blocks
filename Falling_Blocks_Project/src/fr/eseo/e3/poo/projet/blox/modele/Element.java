package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {

    private Coordonnees coordonnees;
    private Couleur couleur = Couleur.ROUGE;

    public Element(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public Element(int abscisse, int ordonnee) {
        this(new Coordonnees(abscisse, ordonnee));
    }

    public Element(Coordonnees coordonnees, Couleur couleur) {
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    public Element(int abscisse, int ordonnee, Couleur couleur) {
        this(new Coordonnees(abscisse, ordonnee), couleur);
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public String toString() {
        return "(" + this.coordonnees.getAbscisse() + ", " + this.coordonnees.getOrdonnee() + ") - "+ this.couleur;
    }

    public void deplacerDe(int deltaX, int deltaY) {
        setCoordonnees(new Coordonnees(getCoordonnees().getAbscisse() + deltaX,
                getCoordonnees().getOrdonnee() + deltaY));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return Objects.equals(getCoordonnees(), element.getCoordonnees()) && getCouleur() == element.getCouleur();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordonnees(), getCouleur());
    }
}
