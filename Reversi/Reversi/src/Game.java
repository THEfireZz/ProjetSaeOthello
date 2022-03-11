import java.util.Scanner;
import  java.util.concurrent.TimeUnit ;

public class Game {

    public static boolean playGame= true ;
    public static boolean rejouer  = true ;
    public static void myGame( int ia ) throws InterruptedException {
        Scanner sc = new Scanner(System.in) ;
        Methode_Position.listDesCoJouablesFct(Plateau.tabint,1);

        System.out.println("Il faut saisire l'axe horizontal puis verticale ");
        int passCompt = 0 ;
        while (playGame) {

            int x ;
            int y ;



            rejouer = true ;
            Methode_Position.listDesCoJouablesFct(Plateau.tabint, 1);
            if (canPlay(passCompt) && playGame ){
                passCompt =  0 ;
                if(ia != 3 ){
                    do {

                        do {
                            System.out.println("c'est au noir de jouer ");
                            Methode_Position.listDesCoJouablesFct(Plateau.tabint, 1);
                            Methode_Position.afficherTableau(Plateau.tabint);

                            try {
                                x = Integer.parseInt(sc.nextLine());
                                y = Integer.parseInt(sc.nextLine());
                            } catch (Exception E) {
                                System.out.println("il faut ecrire des coordoner ");
                                x = -1;
                                y = -1;
                            }

                        } while (x < 1 || x > 8 || y < 1 || y > 8);

                        x-- ;
                        y-- ;
                        Methode_Jeton.placerJeton( x, y, 1);
                    }while (rejouer) ;



                }
                else {
                    System.out.println("c'est a l'ia ⬡  de jouer");
                    Methode_Position.listDesCoJouablesFct(Plateau.tabint, 1);
                    Methode_Position.afficherTableau(Plateau.tabint);



                    iaPlay(1) ;


                }


            }

            else if (playGame) {
                 System.out.println("Le joueur ⬡ ne peut pas jouer" );
                 passCompt++ ;
             }

            rejouer = true;
            //coordoner dans un int
            Methode_Position.listDesCoJouablesFct(Plateau.tabint, 2);
            if (canPlay(passCompt) && playGame){
                passCompt = 0 ;
                if (ia == 1) {
                    do {

                        do {
                            System.out.println("c'est au blanc de jouer ");
                            Methode_Position.listDesCoJouablesFct(Plateau.tabint, 2);
                            Methode_Position.afficherTableau(Plateau.tabint);

                            try {
                                x = Integer.parseInt(sc.nextLine());
                                y = Integer.parseInt(sc.nextLine());
                            } catch (Exception E) {
                                System.out.println("il faut ecrire des coordoner ");
                                x = -1;
                                y = -1;
                            }


                        } while (x < 1 || x > 8 || y < 1 || y > 8);
                        x--;
                        y--;

                        Methode_Jeton.placerJeton(x, y, 2);

                    } while (rejouer);
                }
                else {
                    System.out.println("c'est a l'ia ⬢  de jouer");
                    Methode_Position.listDesCoJouablesFct(Plateau.tabint, 2);
                    Methode_Position.afficherTableau(Plateau.tabint);
                    if(ia == 2){
                        TimeUnit.SECONDS.sleep(2);
                    }

                    iaPlay(2) ;
                }

            }
            else if (playGame)
            {
                System.out.println("le joueur ⬢ ne peut pas jouer");
                passCompt++ ;
            }
        }
        endGame() ;

    }

    private static void iaPlay( int valJoueur) {
        int x  = 0;
        int y = 0;
        int minus  = 0;


        for (int i = 0; i < Plateau.tabint.length; i++) {
            for (int j = 0; j < Plateau.tabint.length; j++) {

                if (Plateau.tabint[i][j] < minus){
                    x = j ;
                    y = i ;
                    minus = Plateau.tabint[i][j] ;
                }
                else if (minus ==  Plateau.tabint[i][j]){
                    int number = (int)(Math.random() * 10);

                    if (number < 5 ){

                        x = j ;
                        y = i ;
                    }

                }

            }


        }

        Methode_Jeton.placerJeton(x, y, valJoueur);


    }


    public static void endGame() throws InterruptedException {
        Scanner sc = new Scanner(System.in) ;
        int blanc = 0 ;
        int noire = 0 ;

        for (int i = 0; i < Plateau.tabint.length; i++) {
            for (int j = 0; j < Plateau.tabint.length; j++) {


                if ( Plateau.tabint[i][j] == 1){
                    noire++ ;
                }


                else if  ( Plateau.tabint[i][j] == 2) {
                    blanc++ ;

                }




            }



        }
        if ( noire >  blanc){
            System.out.println("Victoire des noire"); // s ????

        }
        else if (blanc > noire){
            System.out.println("Victoire des blanc"); // s???
        }
        else {
            System.out.println("Egalité personne ne gagne ");
        }
        System.out.println("Nombre de jeton noire :"+noire);
        System.out.println("Nombre de jeton blanc :"+blanc);


        Methode_Position.listDesCoJouablesFct(Plateau.tabint, 1);
        Methode_Position.afficherTableau(Plateau.tabint);

        System.out.println("Appuyer sur n'importe quel touche pour continuer ");
        int wait ;
        try {
            wait = Integer.parseInt(sc.nextLine()) ;
        }catch (Exception e){
            wait = 1 ;
        }
        Plateau.Restart();
        Menu.menu();





    }
    private static boolean canPlay(int pass) {
        if (pass >= 2){

            playGame = false ;
            System.out.println("personne ne peut jouer fin de partie ");
        }

        for (int i = 0; i < Plateau.tabint.length; i++) {

            for (int j = 0; j < Plateau.tabint.length; j++) {

                if (Plateau.tabint[i][j] < 0 ){

                    return true ;
                }

            }


        }

        return false ;
    }



}