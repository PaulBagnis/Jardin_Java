public class Terre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jardin monJardin = new Jardin(5,5);
		
		// On rempli le panier
		monJardin.ajoutPanier("Ail", 10);
		monJardin.ajoutPanier("Betterave", 10);
		monJardin.ajoutPanier("Carotte", 10);
		monJardin.ajoutPanier("Tomate", 10);
		
		monJardin.choix();
	}
}
