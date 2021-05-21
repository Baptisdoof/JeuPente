class Pente{
    public static void main(String[] args){
    int plateau[][] = new int[19][19];
    int joueur = 1;
    int x = 5;
    int y = 5;
    int compteur = 0;
    plateau[2][2]= 1;
    plateau[3][3]= 2;
    plateau[4][4] = 2;
    plateau[4][6] = 2;
    plateau[3][7] = 2;
    plateau[2][8] = 1;
    plateau[x][y] = 1;
    compteur = compteur + testPierrePrise(plateau, joueur,x,y);
    if (compteur >= 5){
        System.out.println("C'est gagné gg a toi");
    }
    System.out.println(compteur);
    }


    static int testPierrePrise(int[][] plateau,int joueur, int x, int y){
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
                    }
                }
            }
        }
        return pierrePrise;
    }
}