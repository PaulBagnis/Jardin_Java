package Flore;

public abstract class Vegetal {
	
	//Attributs
	private Etat etat;
	public String[] dessin = new String[6];

	public Vegetal() {
		this.dessin[0] = "_";
		this.dessin[1] = ".";
		this.dessin[2] = "|";
		this.dessin[5] = "#";
		this.etat = Etat.GRAINE;
	}

	@Override
	public String toString() {
        String dessinActuel;
        Integer etatActuel = this.etat.ordinal();

        dessinActuel = this.dessin[etatActuel];
        return dessinActuel;
	}
	
	public Etat getEtat() {
		return etat;
	}
	
	public void grandir() {
		this.etat = Etat.values()[this.etat.ordinal() + 1];
	}
}
