import java.util.ArrayList;

public class historique{
    public static void main(String[] args) {        //variables d'autres programmes: joueur1, victoire,position
        boolean joueur1 = false ;
        boolean victoire = false ;
        String position="test";
        String event="";
        remplir_historique(joueur1,victoire,position);
        System.out.println(event);
    }
    
    static void remplir_historique(boolean joueur1,boolean victoire,String position){
        ArrayList<String> liste_coups = new ArrayList<String>();
        int i = 0;
        while(victoire==false){
            if (joueur1){
                liste_coups.add(position);
                joueur1=false;
                System.out.println("Coup du joueur1: "+liste_coups.get(i));     //affichage
            }else{
                liste_coups.add(position);
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
        event = event+liste_coups.get(i);
    }
    return event;
    
}
}



