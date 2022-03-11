// list (xpla , ypla , xdep ydep , nbrjetonrt)
public class Methode_Jeton {

    public static void placerJeton( int x , int y ,int jeton){

        boolean canPlace = Plateau.tabint[y][x] < 0;

        if (canPlace){
            System.out.println("jeton placé");

            Plateau.tabint[y][x] = jeton ;

            Game.rejouer = false ;
            retournerjeton( x , y , jeton);
        }
        else {
            System.out.println("impossible jouer ici ");
        }

    }




    public static void retournerjeton( int x , int y ,  int jeton ){

        //faire une troisieme list qui contien seulement le nombre de jeton retourné


//        System.out.println("max "+coArrive.size());
//        System.out.println("maxdepart "+coDepart.size());
//        System.out.println("nbrJeton "+nbrJeton.size());
        if (jeton == 1) {


            look(x , y , -1 , 0 ,2 , 1 , 0  , x , y );
            look(x , y , -1 , -1 ,2 , 1 , 0  , x , y );
            look(x , y , 0 , -1 ,2 , 1 , 0  , x , y );
            look(x , y , 1 , -1 ,2 , 1 , 0  , x , y );
            look(x , y , 1 , 0 ,2 , 1 , 0  , x , y );
            look(x , y , 1 , 1 ,2 , 1 , 0  , x , y );
            look(x , y , 0 , 1 ,2 , 1 , 0  , x , y );
            look(x , y , -1 , 1 ,2 , 1 , 0  , x , y );

        }
        else
        {
            look(x , y , -1 , 0 ,1 , 2 , 0  , x , y );
            look(x , y , -1 , -1 ,1 , 2 , 0  , x , y );
            look(x , y , 0 , -1 ,1 , 2 , 0  , x , y );
            look(x , y , 1 , -1 ,1 , 2 , 0  , x , y );
            look(x , y , 1 , 0 ,1 , 2 , 0  , x , y );
            look(x , y , 1 , 1 ,1 , 2 , 0  , x , y );
            look(x , y , 0 , 1 ,1 , 2 , 0  , x , y );
            look(x , y , -1 , 1 ,1 , 2 , 0  , x , y );


        }

    }






    public static void look(int x , int y , int directionX , int directionY , int what , int valjoueur , int compteur , int xini , int yini ){
        try {
            if(compteur == 0 ){
                if(Plateau.tabint[y+directionY][x+directionX] == what  ){
                    compteur++ ;

                    look(x+directionX ,y+directionY , directionX , directionY ,  what , valjoueur , compteur  , xini , yini);
                }

            }
            else {
                if(Plateau.tabint[y+ directionY][x+ directionX] == valjoueur){
                    fill(xini , yini , x  , y , valjoueur);
                }
                else if (Plateau.tabint[y+ directionY][x+ directionX] == what){
                    compteur++ ;
                    look(x+directionX ,y+directionY , directionX , directionY ,  what , valjoueur , compteur ,  xini ,yini );
                }
            }



        }catch (Exception e){



        }

    }



    public static void fill(int Xdep , int Ydep ,int Xend , int Yend , int valJoueur) {
        int Directx = (  Xend -Xdep );
        int Directy = (  Yend -Ydep) ;
        if (Directx < 0 )
            Directx = -1 ;
        else if (Directx > 0 )
            Directx = 1 ;

        if (Directy < 0 )
            Directy = -1 ;
        else if (Directy > 0 )
            Directy = 1 ;


        if (Xdep != Xend || Ydep != Yend ){
            Plateau.tabint[Ydep +Directy][Xdep +Directx] = valJoueur ;
            fill(Xdep+Directx ,Ydep+Directy , Xend , Yend , valJoueur );
        }
    }
}









