import java.util.Random;
public class Commencer{

    public static void main(String[] args){
            

            int joueur1 = 1;
            int joueur2 = 2;
    
            Random random = new Random();
    
            int value = random.nextInt(joueur2 + joueur1) + joueur1;
            System.out.println(value);
            

    }
}

}