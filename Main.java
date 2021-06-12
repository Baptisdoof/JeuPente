import MG2D.*;
import MG2D.geometrie.*;
import java.util.Random;
import java.awt.Font;
import java.util.Scanner;



class Main{
    public static void main(String[] args){
         
        System.out.print(lancement()) ;
        int nbpierrej1 = 0 ;
        int nbpierrej2 = 0 ;
        int priseparallignement = 0 ;
        Couleur color = Couleur.ROSE;
        int joueur = lancement() ;
        int derx = 0;
        int dery = 0;
        int plateau[][] = new int[19][19];
        int tailleFenetre = 750;
        Fenetre f = new Fenetre("jeux",tailleFenetre,tailleFenetre);
        int tailleBordNord=100;
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir nom joueur1");
        String nomjoueur1 = scanner.nextLine();
        System.out.println("saisir nom joueur2");
        String nomjoueur2 = scanner.nextLine();

        Point j1 = new Point (600, 740);
        Point  j2 = new Point (600, 710);
        String joueur1 = "joueur1" ;
        String joueur2 = "joueur2" ;
        
        Font calibri = new Font("Calibri", Font.TYPE1_FONT, 25);

        Texte t1 = new Texte (new String (joueur1 +": " + nomjoueur1 ) , calibri , j1 );
        Texte t2 = new Texte (new String (joueur2 +": " + nomjoueur2 ) , calibri , j2 );
        
        f.ajouter(t1);
        f.ajouter(t2);
        f.rafraichir();

        Souris souris = f.getSouris();
        int indice = 0;
        while (nbpierrej1 < 5 && nbpierrej2 < 5 && priseparallignement == 0){
            while(!souris.getClicGauche()){
                try{
                    Thread.sleep(1);
                }
                catch(Exception e){}
            }
            Point p = new Point(souris.getPosition());
            Point g = new Point((((p.getX()-100)/tailleCase)*tailleCase+100+tailleCase/2),((p.getY()-100)/tailleCase)*tailleCase+100+tailleCase/2);
            derx = (g.getX()-100)/tailleCase;
            dery = (g.getY()-100)/tailleCase;
            if (plateau[((g.getX()-100)/tailleCase)][((g.getY()-100)/tailleCase)] == 0  ){
                plateau[((g.getX()-100)/tailleCase)][((g.getY()-100)/tailleCase)] = joueur ;
                if (joueur == 1){
                    color = Couleur.ROUGE ;
                } else {
                    color = Couleur.NOIR ;
                }
                Cercle c = new Cercle( color , g, 10, true);
                f.ajouter(c);
                priseparallignement = testAllignement(plateau, joueur , derx , dery);
                f.rafraichir();
                indice++;
                if (joueur==1){
                    nbpierrej1 = nbpierrej1 + testPierrePrise(plateau, joueur, derx , dery, tailleCase, f);
                    System.out.println("Tour du joueur2");
                    joueur = 2 ;
                } else{ 
                    nbpierrej2 = nbpierrej2 + testPierrePrise(plateau, joueur, derx , dery, tailleCase, f);
                    System.out.println("Tour du joueur1");
                    joueur = 1; 
                }

            } 

            System.out.println(nbpierrej1);
            System.out.println(nbpierrej2);
            System.out.println("");
            for (int y = 0; y < plateau.length; ++y) {
            for (int x = 0; x < plateau[y].length; ++x) {
                System.out.print(plateau[y][x]);
            }
            System.out.println("");
            }
        }
        victoire(f, joueur,nomjoueur1,nomjoueur2);
        f.rafraichir();
   } 

    public static int testPierrePrise(int[][] plateau,int joueur, int x, int y, int tailleCase, Fenetre f ){
        int[] coord1 =  {-1,+1,-1,+1,-1,+1,0,0};
        int[] coord2 =  {0,0,-1,+1,+1,-1,-1,+1};
        int pierrePrise = 0;
        int adversaire = 0;
        if(joueur == 1){
            adversaire = 2;
        }
        else{
            adversaire = 1;
        }
        for (int i=0; i<8; i++){
            int testx = x + coord1[i];
            int testy = y + coord2[i];
            if (plateau[testx][testy] == adversaire){
                testx = testx + coord1[i];
                testy = testy + coord2[i];
                if (plateau[testx][testy] == adversaire){
                    testx = testx + coord1[i];
                    testy = testy + coord2[i];
                    if (plateau[testx][testy] == joueur){
                        pierrePrise = pierrePrise + 1;
                        plateau[x + coord1[i]][y + coord2[i]] = 0;
                        plateau[x + 2*coord1[i]][y + 2*coord2[i]] = 0;
                        Point g = new Point((x + coord1[i])*tailleCase+100+tailleCase/2,(y + coord2[i])*tailleCase+100+tailleCase/2);
                        Cercle c = new Cercle( Couleur.JAUNE , g, 10, true);
                        Point g2 = new Point((x + coord1[i]*2)*tailleCase+100+tailleCase/2,(y + coord2[i]*2)*tailleCase+100+tailleCase/2);
                        Cercle c2 = new Cercle( Couleur.JAUNE , g2, 10, true);
                        f.ajouter(c);
                        f.ajouter(c2);
                        f.rafraichir();
                    }
                }
            }
        }
        return pierrePrise;
    }

    public static int testAllignement(int[][] plateau, int joueur, int x, int y) {
        int[] coord1 =  {-1,+1,-1,+1,-1,+1,0,0};
        int[] coord2 =  {0,0,-1,+1,+1,-1,-1,+1};
        int derx = x ;
        int dery = y ;
        int derx1 = x ;
        int dery1 = y ;
        int gagnant = 0 ;
        int compteur = 0;
        for (int i=0; i<8; i++){
            int x1 = derx + coord1[i] ;
            int y1 = dery + coord2[i] ;
            if (plateau[x1][y1] == joueur){
                derx1 = x;
                dery1 = y;
                for (int j=1; j<5; j++){
                    derx1 = derx1 + coord1[i];
                    dery1 = dery1 + coord2[i];
                    if (plateau[derx1][dery1]== joueur){
                        compteur = compteur + 1;
                        if (compteur >= 4 ){
                            gagnant = gagnant +1 ;
                        }   
                    }
                }
            }
            if (i == 1 || i ==3 || i == 5 || i == 7 ){
                compteur = 0;
            }
        }
        return gagnant;
    }

    public static int lancement() {
        Random r = new Random();
        int n = r.nextInt(2);
        n = n+1 ; 
        return n ;       
    }


    public static void victoire(Fenetre f, int joueur,String j1 , String j2  ){
        Point b = new Point ( 375, 635);
        Point c = new Point(0,600);
        String joueur_nom = "Mr.warin" ;
        String joueur_nom2 = "Jean-Marie Lepen";
        Rectangle deco = new Rectangle (Couleur.ORANGE,c,750,75,true);
        f.ajouter(deco);
        Font calibri = new Font("Calibri", Font.TYPE1_FONT, 40);
        if (joueur == 1) {
            Texte t1 = new Texte (new String (j1 + " a gagne") , calibri , b );
            f.ajouter(t1);
        }else {
            Texte t2 = new Texte (new String (j2 + " a gagne") , calibri , b );
            f.ajouter(t2);
        }
        f.rafraichir();
    }
}
