package mypackage;

import myclass.PlayerClass;
import java.util.Scanner;


public class MainKino {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PlayerClass a = new PlayerClass();
        a.kinoGame();
        
        System.out.println("TYPE OF GAME | BET | EARNINGS");
        
        for (int i = 0; i < a.getGameHistory().size(); i++) {
            System.out.println(a.getGameHistory().get(i)+" | "+a.getBetHistory().get(i)+" | "+a.getEarningHistory().get(i));
        }
        System.out.println("");
        System.out.println("TOTAL EARNINGS: "+ a.getTotalEarnings());
        System.out.println("TOTAL GAMES PLAYED: "+ PlayerClass.getNumberOfDraws());
    }
}