import java.util.HashMap;
import java.util.Scanner;

import Flore.Ail;
import Flore.Betterave;
import Flore.Carotte;
import Flore.Etat;
import Flore.Tomate;

public class Jardin {

	// Attributs
	private int longueur;
	private int largeur;
	private Emplacement emplacement[][];
	private HashMap<String, Integer> panier;
	

	//Constructeur
	public Jardin(int longueur, int largeur) {
		
		this.longueur = longueur;
		this.largeur = largeur;
		this.panier = new HashMap<String, Integer>();
		this.emplacement = new Emplacement[longueur][largeur];
	}
	
	// Méthode ajoutPanier pour ajouter une graine
	public void ajoutPanier(String nomDuVegetal, Integer quantite) {
		
		this.panier.put(nomDuVegetal, quantite);
	}
	
	//Affichage Jardin
	public void afficherJardin() {
		
		System.out.print(" ");
		// On boucle sur la hauteur
		for(int x = 0; x < longueur; x++) {
			// On boucle sur la largeur
			for(int y = 0; y < largeur; y++) {
				// On vérifie si quelque chose est planté à cet emplacement
				if(this.emplacement[x][y] == null) {
					System.out.print("o ");
				} else {
					// On détermine dans quel état est la plante pour afficher le char correspondant
					System.out.print((this.emplacement[x][y].getPlante()).toString() + " ");
				}
			}
			System.out.print("\n ");
		}
	}
	
	// To String
	@Override
	public String toString() {
		
		System.out.println("Voici notre jardin :\n");
		afficherJardin();
		return "\nEt notre panier contient : \n\n Tomate : " +  panier.get("Tomate") + " graine(s)"
		        + " \n Carotte : " + panier.get("Carotte")  + " graine(s)" +  "\n Ail : " +
		        panier.get("Ail")  + " graine(s)" +  "\n Betterave : " +
		        panier.get("Betterave")  + " graine(s)\n\n";
	}

	public void choix() {
		
		Scanner scanner = new Scanner(System.in);
		int res = 0;
		do {
			// On affiche le jardin
			System.out.print(this.toString());
			
			// On demande a l'utilisateur ce qu'il veut faire
			System.out.println("Que souhaitez vous faire maintenant :");
			System.out.println("1. Semer une graine");
			System.out.println("2. Récolter les plantes qui sont matures");
			System.out.println("3. Passer à la saison suivante (toutes les plantes grandissent");
			System.out.println("4. Quitter");
			System.out.println("Entrez le NUMERO de la réponse de votre choix.");
			
			// On scanne sa réponse pour savoir si on boucle ou non
			res = scanner.nextInt();
			if (res < 1 || res > 4) {
				System.out.println("Je vais être plus clair, veuillez choisir une option entre 1 et 4. Tout le monde a droit à une autre chance.");
				res = scanner.nextInt();
			} else if (res == 1) {
				this.semer();
			} else if (res == 2) {
				this.recolter();
			} else if (res == 3) {
				this.saisonSuivante();
			}
		}
		while (res != 4);
	}
	
	public void semer() {
		
		Scanner scanner = new Scanner(System.in);
		int resPlante = 0;
		int resEmp1 = 6;
		int resEmp2 = 6;
		
		// L'utilisateur choisi une plante
		System.out.println("\nQuel plante souhaitez vous planter ?\n1. L'ail\n2. La betterave\n3. La carotte\n4. La tomate\nEntrez le NUMERO correspondant à la plante choisie.");
		do {
			resPlante = scanner.nextInt();
		} while (resPlante < 1 || resPlante > 4);
		// L'utilisateur choisi un emplacement
		System.out.println("Choisissez maintenant l'emplacement auquel vous souhaitez planter cette belle graine.\nLa première valeur représente la coordonnée verticale, la deuxième que vous rentrerez, l'horizontale.\nRAPPEL: Votre jardin est d'une taille de 5 sur 5 !");
		// L'utilisateur choisi X
		do {
			resEmp1 = scanner.nextInt();
			resEmp1 = resEmp1 - 1;
		} while (resEmp1 < 0 || resEmp1 > 4);
		// L'utilisateur choisi Y
		do {
			resEmp2 = scanner.nextInt();
			resEmp2 = resEmp2 - 1;
		} while (resEmp2 < 0 || resEmp2 > 4);
		// On plante la graine à l'emplacement choisi en vérifiant s'il reste des graines 
		if (resPlante == 1 && panier.get("Ail") > 0) {
			this.emplacement[resEmp1][resEmp2] = new Emplacement(new Ail());
			int nombreGraine = panier.get("Ail") - 1;
			this.ajoutPanier("Ail", nombreGraine);
		} else if (panier.get("Ail") == 0) {
			System.out.println("Il ne reste plus de graine.");
		} else if (resPlante == 2 && panier.get("Betterave") > 0) {
			this.emplacement[resEmp1][resEmp2] = new Emplacement(new Betterave());
			int nombreGraine = panier.get("Betterave") - 1;
			this.ajoutPanier("Betterave", nombreGraine);
		} else if (panier.get("Betterave") == 0) {
			System.out.println("Il ne reste plus de graine.");
		} else if (resPlante == 3 && panier.get("Carotte") > 0) {
			this.emplacement[resEmp1][resEmp2] = new Emplacement(new Carotte());
			int nombreGraine = panier.get("Carotte") - 1;
			this.ajoutPanier("Carotte", nombreGraine);
		}else if (panier.get("Carotte") == 0) {
			System.out.println("Il ne reste plus de graine.");
		}  else if (resPlante == 4 && panier.get("Tomate") > 0) {
			this.emplacement[resEmp1][resEmp2] = new Emplacement(new Tomate());
			int nombreGraine = panier.get("Tomate") - 1;
			this.ajoutPanier("Tomate", nombreGraine);
		} else if (panier.get("Tomate") == 0) {
			System.out.println("Il ne reste plus de graine.");
		} 
	}
	
	public void recolter() {
		// On boucle sur le tableau du jardin
		for(int i = 0; i < longueur; i++) {
			for(int j = 0; j < largeur; j++) {
				// On vérifie si quelque chose est planté à cet emplacement et son état, s'il est FLEUR ou MORT, on le supprime
				if (this.emplacement[i][j] != null) {
					if(this.emplacement[i][j].getPlante().getEtat() == Etat.FLEUR || this.emplacement[i][j].getPlante().getEtat() == Etat.MORT) {
						this.emplacement[i][j] = null;
					}
				}
			}
		}
		System.out.println("Vous avez récolté toutes les plantes matures !");
	}
	
	public void saisonSuivante() {
		for(int x = 0; x < longueur; x++) {
			for(int y = 0; y < largeur; y++) {
				if (this.emplacement[x][y] != null) {
					this.emplacement[x][y].getPlante().grandir();
				}
			}
		}
	}
	
}
