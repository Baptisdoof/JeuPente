import MG2D.*;
import MG2D.geometrie.*;

public class Plateau2 {
    public static void main(String[]args){
        int plateau[][] = new int[18][18];
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




        Souris souris = f.getSouris();
        int indice = 0;
        while (indice<500){
            while(!souris.getClicGauche()){
                try{
                    Thread.sleep(1);
                }
                catch(Exception e){}
            }
            Point p = new Point(souris.getPosition());
            Point g = new Point((((p.getX()-100)/tailleCase)*tailleCase+100+tailleCase/2),((p.getY()-100)/tailleCase)*tailleCase+100+tailleCase/2);
            plateau[((g.getX()-100)/tailleCase)][((g.getY()-100)/tailleCase)] = 1 ;
            Cercle c = new Cercle(Couleur.BLEU, g, 10, true);
            f.ajouter(c);
            f.rafraichir();
            indice++;
            for (int y = 0; y < plateau.length; ++y) {
            for (int x = 0; x < plateau[y].length; ++x) {
                System.out.print(plateau[y][x]);
            }
            System.out.println("");
            }
        }
        f.rafraichir();

    }
}
        
        
        
    

