import java.util.ArrayList;

public class historique{
    public static void main(String[] args) {        
        boolean joueur1 = false ;
        boolean victoire = false ;
        int testx=0;
        int testy=0;
        String sortie="";
        remplir_historique(joueur1,victoire,testx,testy);
        System.out.println(sortie);
    }
    
    static void remplir_historique(boolean joueur1,boolean victoire,int testx,int testy){
        ArrayList<String> liste_coups = new ArrayList<String>();
        int i = 0;
        while(victoire==false){
            if (joueur1){
                liste_coups.add("("+testx+","+testy+")");
                joueur1=false;
                System.out.println("Coup du joueur1: "+liste_coups.get(i));     //affichage
            }else{
                liste_coups.add("("+testx+","+testy+")");
                joueur1=true;
                System.out.println("Coup du joueur2: "+liste_coups.get(i));     //affichage
            }
            i++;   
            //temporaire
            if(i==5){
                victoire=true;
            }}
            
           
    }
    public String toString(){
    for (int j=0;j<liste_coups.size();j++){
        sortie = sortie+liste_coups.get(i);
    }
    return sortie;
    
}
}



