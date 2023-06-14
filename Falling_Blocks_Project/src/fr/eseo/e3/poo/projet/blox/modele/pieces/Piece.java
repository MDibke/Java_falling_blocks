package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private List<Element> elements = new ArrayList<>(4);
    protected Couleur couleur;
    protected Coordonnees coordonnees;
    private Puits puits;

    public Piece(Coordonnees coordonnees, Couleur couleur) {
        this.couleur = couleur;
        this.coordonnees = coordonnees;
        this.puits = null;
        this.setElements(this.coordonnees, this.couleur);
    }

    protected abstract void setElements(Coordonnees setCoordonnees, Couleur setCouleur);

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
    
    public Puits getPuits() {
        return puits;
    }
    
    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException, BloxException {
        boolean exceptionDeplacement = false;
        if(Math.abs(deltaX) > 1 || deltaY < 0) {
            throw new IllegalArgumentException("La nouvelle position doit être supérieure ou égale à zéro.");
            //throw new BloxException("La nouvelle position doit être supérieure ou égale à zéro.", BloxException.BLOX_SORTIE_PUITS);
        }
        else {
            for (Element element : this.elements) {
                if (this.puits == null) {
                    exceptionDeplacement = true;
                } else if (exeptionDeplacement(deltaX, deltaY, element)) {
                    exceptionDeplacement = true;
                } else {
                    exceptionDeplacement = false;
                }
            }
            testDeplacerDe(exceptionDeplacement, deltaX, deltaY);
        }
    }

    private void testDeplacerDe(boolean exception, int deltaX, int deltaY) {
        if (exception) {
            for (Element element : elements) {
                element.deplacerDe(deltaX, deltaY);
            }
        }
    }

    private boolean exeptionDeplacement(int deltaX, int deltaY, Element element) throws BloxException {
        boolean exception = false;
        for (Element[] elementRefLigne : this.puits.getTas().getElements()) {
            for (Element elementRefColonne : elementRefLigne) {
                int nextCoordX = element.getCoordonnees().getAbscisse() + deltaX;
                int nextCoordY = element.getCoordonnees().getOrdonnee() + deltaY;

                if(testColisionPuitsDeplacer(elementRefColonne, nextCoordX, nextCoordY) ||
                        testSortiePuitsDeplacer(nextCoordX, nextCoordY)) {
                    exception = true;
                }
            }
        }
        return !exception;
    }

    private boolean testColisionPuitsDeplacer(Element element, int nextCoordX, int nextCoordY) throws BloxException {
        boolean exception = false;
        if (element != null) {
            if (element.getCoordonnees().equals(new Coordonnees(nextCoordX, nextCoordY)))   {
                exception = true;
                throw new BloxException("La pièce entre en colision avec une autre pièce", BloxException.BLOX_COLLISION);
            }
        }
        return exception;
    }

    private boolean testSortiePuitsDeplacer(int nextCoordX, int nextCoordY) throws BloxException {
        boolean exception = false;
        if (nextCoordX < 0 || nextCoordX >= this.puits.getLargeur()) {
            exception = true;
            throw new BloxException("La pièce est sortie du puits", BloxException.BLOX_SORTIE_PUITS);
        }
        if (nextCoordY >= this.puits.getProfondeur()) {
            exception = true;
            throw new BloxException("La pièce à atteint le fond tas", BloxException.BLOX_COLLISION);
        }
        return exception;
    }

    public void tourner(boolean sensHoraire) throws IllegalArgumentException, BloxException {
        boolean exceptionTourner = false;
        Coordonnees newCoordonnees;

        // Iterate over all elements and rotate them around the pivot
        for (Element element : this.elements) {
            newCoordonnees = calculNewCoordonnees(sensHoraire, this.elements.get(0).getCoordonnees(), element.getCoordonnees());
            if(this.puits == null) {
                exceptionTourner = true;
            }
            else if (exeptionTourner(newCoordonnees)) {
                exceptionTourner = true;
            }
            else {
                exceptionTourner = false;
            }
        }
        testTourner(exceptionTourner, sensHoraire);
    }

    private void testTourner(boolean exception, boolean sensHoraire) {
        if (exception) {
            for (Element element : this.elements) {
                Coordonnees newCoordonnees = calculNewCoordonnees(sensHoraire, this.elements.get(0).getCoordonnees(), element.getCoordonnees());
                // Translate back to original coordinates and update element
                element.setCoordonnees(newCoordonnees);
            }
        }
    }

    private boolean exeptionTourner(Coordonnees coordonneesTest) throws BloxException {
        boolean exception = false;
        for (Element[] elementRefLigne : this.puits.getTas().getElements()) {
            for (Element elementRefColonne : elementRefLigne) {
                if(testColisionPuitsTourner(elementRefColonne, coordonneesTest) ||
                        testSortiePuitsTourner(coordonneesTest)) {
                    exception = true;
                }
            }
        }
        return !exception;
    }

    private boolean testColisionPuitsTourner(Element element, Coordonnees coordonneesTest) throws BloxException {
        boolean exception = false;
        if (element != null) {
            if (element.getCoordonnees().equals(coordonneesTest)) {
                exception = true;
                throw new BloxException("La pièce entre en colision avec une autre pièce", BloxException.BLOX_COLLISION);
            }
        }
        return exception;
    }

    private boolean testSortiePuitsTourner(Coordonnees coordonneesTest) throws  BloxException {
        boolean exception = false;
        if (coordonneesTest.getAbscisse() < 0 || coordonneesTest.getAbscisse() >= this.puits.getLargeur()) {
            exception = true;
            throw new BloxException("La pièce est sortie du puits", BloxException.BLOX_SORTIE_PUITS);
        }
        if (coordonneesTest.getOrdonnee() >= this.puits.getProfondeur()) {
            exception = true;
            throw new BloxException("La pièce à atteint le fond tas", BloxException.BLOX_COLLISION);
        }
        return exception;
    }

    private Coordonnees calculNewCoordonnees(boolean sensHoraire, Coordonnees coordonneesPivot, Coordonnees coordonneesInitiale) {
        double cos;
        double sin;
        // Get the pivot
        int pivotX = coordonneesPivot.getAbscisse();
        int pivotY = coordonneesPivot.getOrdonnee();

        // Calculate sin and cos based on rotation direction
        if (sensHoraire) {
            cos = Math.cos(Math.PI / 2);
            sin = Math.sin(Math.PI / 2);
        } else {
            cos = Math.cos(-1 * Math.PI / 2);
            sin = Math.sin(-1 * Math.PI / 2);
        }

        // Iterate over all elements and rotate them around the pivot
            // Translate element coordinates to origin
            int x = coordonneesInitiale.getAbscisse() - pivotX;
            int y = coordonneesInitiale.getOrdonnee() - pivotY;

            // Apply rotation transformation
            int rotatedX = (int) Math.round(x * cos - y * sin);
            int rotatedY = (int) Math.round(x * sin + y * cos);

            // Translate back to original coordinates and update element
            return new Coordonnees(rotatedX + pivotX, rotatedY + pivotY);
    }
}
