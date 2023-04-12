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
        return "(" + this.abscisse + "," + this.ordonnee + ")";
    }

    public boolean equals(int abscisse, int ordonnee) {
        return (this.abscisse == abscisse && this.ordonnee == ordonnee);
    }

    public int hashCode() {
        return this.abscisse + this.ordonnee;
    }
}
