import Flore.Vegetal;

public class Emplacement {
	
	// Attribut
	private Vegetal plante;
	
	// Accesseur publique
	public Vegetal getPlante() {
		return plante;
	}

	// Constructeur
	public Emplacement(Vegetal plante) {
		this.plante = plante;
	}
	
	// Setter
	public void setVegetal(Vegetal plante) {
        this.plante = plante;
    }
	
	// To String
	@Override
    public String toString() {
         return plante.toString();
    }


}
