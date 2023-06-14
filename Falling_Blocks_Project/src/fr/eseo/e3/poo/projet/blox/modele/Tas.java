package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.Random;

public class Tas {
    private Puits puits;
    private Element[][] elements;

    public Tas(Puits puits, int nbElements, int nbLignes) {
        this.puits = puits;
        this.elements = new Element[this.puits.getProfondeur()][this.puits.getLargeur()];
        this.construireTas(nbElements, nbLignes, new Random());
    }
    public Tas(Puits puits, int nbElements) {
        this(puits, nbElements,(nbElements / puits.getLargeur()) + 1);
    }
    public Tas(Puits puits) {
        this(puits,0,0);
    }

    public Puits getPuits() {
        return this.puits;
    }

    public Element[][] getElements() {
        return this.elements;
    }

    public void ajouterElements(Piece pieceAjouter) {
        for(Element elementPiece : pieceAjouter.getElements()) {
            this.elements[elementPiece.getCoordonnees().getOrdonnee()][elementPiece.getCoordonnees().getAbscisse()] = elementPiece;
        }
    }

    private void construireTas(int nbElements, int nbLignes, Random rand) {
        if (nbElements != 0 && nbElements >= this.puits.getLargeur() * nbLignes) {
            throw new IllegalArgumentException("Le nombre d'éléments est trop grand");
        } else {
            int nbPlace = 0;
            while (nbPlace < nbElements) {
                int ordonnee = this.puits.getProfondeur() - (rand.nextInt(nbLignes) + 1);
                int abscice = rand.nextInt(this.puits.getLargeur());
                if (this.elements[ordonnee][abscice] == null) {
                    int indiceCouleur = rand.nextInt(Couleur.values().length);
                    this.elements[ordonnee][abscice] =
                            new Element(new Coordonnees(abscice, ordonnee), Couleur.values()[indiceCouleur]);
                    nbPlace++;
                }
            }
        }
    }

    public void lignePleine() {
        boolean ligneFull = false;
        int numeroLigneFull = this.puits.getProfondeur();
        for (Element[] elementColone : this.getElements()) {
            ligneFull = true;
            for (Element elementLigne : elementColone) {
                if (elementLigne == null) {
                    ligneFull = false;
                }
            }
            if (ligneFull) {
                break;
            }
            numeroLigneFull--;
        }
        if (ligneFull) {
            this.supprimerLigne(numeroLigneFull);
        }
    }

    public void supprimerLigne(int profondeur) {
        for(int i = this.puits.getProfondeur() - profondeur; i > 0; i--) {
            for(int j = 0; j < this.puits.getLargeur(); j++) {
                this.elements[i][j] = this.elements[i - 1][j];
                if(this.elements[i][j] != null)
                    this.elements[i][j].deplacerDe(0, 1);
            }
        }
    }
}
