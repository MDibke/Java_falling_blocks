package fr.eseo.e3.poo.projet.blox.modele;

public class Coordonnees {
    private int abscisse;
    private int ordonnee;

    public Coordonnees(int abscisse, int ordonnee) {
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }
    public String toString() {
        return "(" + this.abscisse + ", " + this.ordonnee + ")";
    }

    public boolean equals(Object o) {
        if (o instanceof Coordonnees) {
            Coordonnees c = (Coordonnees) o;
            return this.abscisse == c.abscisse && this.ordonnee == c.ordonnee;
        }
        return false;
    }

    public int hashCode() {
        int result = 1;
        if (this.abscisse != 0) {
            result = 31 * result + this.abscisse;

        }
        if (this.ordonnee != 0) {
            result = 31 * result + this.ordonnee;
        }
        return result;
    }
}
