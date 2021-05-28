import MG2D.*;
import MG2D.geometrie.*;

public class Plateau {
    public static void main(String[]args){
        int tailleFenetre = 1000;
        Fenetre f = new Fenetre("jeux",tailleFenetre-100,tailleFenetre);
        int tailleBordNord=200;
        int departCaseX = 100;
        int departCaseY = 100;
        int nbCase = 18;
        int tailleCase = (tailleFenetre-tailleBordNord-departCaseY)/nbCase;
        int taillePlateauTotal = tailleCase * nbCase;
        Point pDepart = new Point(departCaseX,departCaseY);
        Rectangle fond = new Rectangle(Couleur.JAUNE,pDepart,taillePlateauTotal,taillePlateauTotal);
        fond.setPlein(true);
        f.ajouter(fond);
        for (int i=0;i<nbCase;i++){
            Point pVertical = new Point(departCaseX,departCaseY+tailleCase*i);
            Rectangle rVertical = new Rectangle(Couleur.NOIR,pVertical,tailleCase,tailleCase);
            f.ajouter(rVertical);
            for (int a=0;a<nbCase;a++){
                Point pHorizontal = new Point(departCaseX+tailleCase*a,departCaseY+tailleCase*i);
                Rectangle rHorizontal = new Rectangle(Couleur.NOIR,pHorizontal,tailleCase,tailleCase);
                f.ajouter(rHorizontal);
            }
            
        }
        
        
        f.rafraichir();
        
        
        
    }
    
}
