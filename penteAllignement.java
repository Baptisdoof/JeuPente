class penteAllignement{
    public static void main(String[] args) {
        int plateau[][] = new int[19][19];
        plateau[10][10] = 1 ;
        plateau[11][11] = 1 ;
        plateau[12][12] = 1 ;
        plateau[9][9] = 1 ;
        plateau[8][8] = 1 ;
        int joueur = 1;
        int x = 10;
        int y = 10;
        int value = penteAllignement.testAllignement(plateau, joueur ,x,y);
        System.out.println(value);
    }


    private static int testAllignement(int[][] plateau, int joueur, int x, int y) {
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
}