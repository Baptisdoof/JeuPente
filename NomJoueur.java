import MG2D.Fenetre;
import MG2D.Couleur;
import java.util.Scanner;

import MG2D.geometrie.Texte;
import java.awt.Font;
import MG2D.geometrie.Point;

public class NomJoueur {
    public static void main ( String [] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir nom joueur1");
        String nomjoueur1 = scanner.nextLine();
        System.out.println("saisir nom joueur2");
        String nomjoueur2 = scanner.nextLine();




        Point a = new Point (600, 740);
        Point b = new Point (600, 710);
        Fenetre f = new Fenetre ("Nom",750,750);
        String joueur1 = "joueur1" ;
        String joueur2 = "joueur2" ;
        

        Font calibri = new Font("Calibri", Font.TYPE1_FONT, 25);

      
        Texte t1 = new Texte (new String (joueur1 +": " + nomjoueur1 ) , calibri , a );
        Texte t2 = new Texte (new String (joueur2 +": " + nomjoueur2 ) , calibri , b );
        
        f.ajouter(t1);
        f.ajouter(t2);
        f.rafraichir();
        
    }
}