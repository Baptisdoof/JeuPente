import java.util.Random;

public class Commencer {
    public static void main(String args[]) {

        // génération nombre entre 0 et 1
        Random r = new Random();
        int n = r.nextInt(2);
        System.out.println(n);         
    }
}

