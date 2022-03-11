

public class Methode_Position {
    public static void afficherTableau(int[][] tab) {
        System.out.println(" \t1   2   3   4   5   6   7   8");
        for (int i = 0; i < tab.length; i++) {
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < tab[1].length; j++) {
                if (tab[i][j] == 1) {
                    System.out.print("⬡" + "\t");
                } else if (tab[i][j] == 2) {
                    System.out.print("⬢" + "\t");
                } else if (tab[i][j] == 0) {
                    System.out.print("." + "\t");
                } else {
                    System.out.print("\u001B[31m" + "X" + "\u001B[0m" + "\t");
                }
            }
            System.out.println();
        }


//        for (int i = 0; i < tab.length; i++) {
//            for (int j = 0; j < tab[1].length; j++) {
//                System.out.print(tab[i][j] + "\t");
//            }
//            System.out.println();
//        }
    }

    public static void listDesCoJouablesFct(int[][] tab, int joueur) {
        int compteur=0;
        ResetPosJouable(tab);
        int CoDepX = -1, CoDepY = -1;

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[1].length; j++) {
                if (joueur == 1) {
                    if (tab[j][i] == 1) {
                        verifjouable(Plateau.tabint, i, j, -1, -1, compteur, 2, CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 1, -1, compteur, 2, CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, -1, 1, compteur, 2, CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 1, 1, compteur, 2, CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, -1, 0, compteur, 2, CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 1, 0, compteur, 2, CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 0, -1, compteur, 2,  CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 0, 1, compteur, 2,  CoDepX, CoDepY);
                    }
                } else {
                    if (tab[j][i] == 2) {
                        verifjouable(Plateau.tabint, i, j, -1, -1, compteur, 1,  CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 1, -1, compteur, 1,  CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, -1, 1, compteur, 1,  CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 1, 1, compteur, 1,  CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, -1, 0, compteur, 1,  CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 1, 0, compteur, 1,  CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 0, -1, compteur, 1,  CoDepX, CoDepY);

                        verifjouable(Plateau.tabint, i, j, 0, 1, compteur, 1,  CoDepX, CoDepY);
                    }
                }
            }
        }
        IABordure(tab);
    }

    public static void verifjouable(int[][] tab, int pionsX, int pionsY, int modx, int mody, int compteur, int pion, int CoDepX, int CodepY) {
        try {
            int newPosX = pionsX + modx, newposY = pionsY + mody;
            if (tab[newposY][newPosX] == pion) {
                if (compteur == 0) {
                    CoDepX = pionsX;
                    CodepY = pionsY;
                }
                compteur++;
                verifjouable(tab, newPosX, newposY, modx, mody, compteur, pion,  CoDepX, CodepY);
            } else if (tab[newposY][newPosX] <= 0 && compteur >= 1) {
                tab[newposY][newPosX] = tab[newposY][newPosX] - compteur;
            }
        } catch (Exception e) {
        }
    }

    public static void ResetPosJouable(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[1].length; j++) {
                if (tab[i][j] < 0) {
                    tab[i][j] = 0;
                }
            }
        }
    }
    public static void IABordure(int[][]tab){
        for (int i = 0; i <tab.length ; i++) {
            for (int j = 0; j <tab[1].length ; j++) {
                if (i==0||i==7){
                    if (tab[i][j]<0){
                        tab[i][j]=tab[i][j]-5;
                    }
                }
                if (j==0||j==7){
                    if (tab[i][j]<0){
                        tab[i][j]=tab[i][j]-5;
                    }
                }
            }
        }
    }
}