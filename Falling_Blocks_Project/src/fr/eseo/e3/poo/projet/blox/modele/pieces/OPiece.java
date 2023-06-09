package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

import java.util.List;

public class OPiece extends Piece {
    private List<Element> element;
    public OPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        this.element = super.getElements();
        this.element.clear();
        this.element.add(new Element(coordonnees, couleur));
        this.element.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1), couleur));
        this.element.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee()), couleur));
        this.element.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1), couleur));
    }

    @Override
    public String toString() {
        return "OPiece :\n" + super.toString();
    }

    @Override
    public void tourner(boolean sensHoraire) {
        //Ne doit rien faire
    }
}