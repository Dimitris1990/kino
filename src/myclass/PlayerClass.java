package myclass;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import myinterface.IKino;



public class PlayerClass implements IKino{
    
    static Scanner sc = new Scanner(System.in);
    
    private static int numberOfDraws;
    private static int totalEarnings;
    private static List<Integer> gameHistory;
    private static List<Integer> betHistory;
    private static List<Integer> earningHistory;
    
    private static int nG;
    private static int tGame;
    private static int bGame;
    
    public PlayerClass() {
        numberOfDraws++;
        gameHistory = new ArrayList();
        betHistory = new ArrayList();
        earningHistory = new ArrayList();
    }

    public static int getNumberOfDraws() {
        return numberOfDraws;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }


    public List<Integer> getGameHistory() {
        return gameHistory;
    }


    public List<Integer> getBetHistory() {
        return betHistory;
    }


    public List<Integer> getEarningHistory() {
        return earningHistory;
    }

     @Override
    public String toString() {
        return "PlayerClass{" + "totalEarnings=" + totalEarnings + ", gameHistory=" + gameHistory + ", betHistory=" + betHistory + ", earningHistory=" + earningHistory + '}';
    }
    
//MY METHODS
    public void kinoGame(){

        int nGames = numberOfGames();
        System.out.println(nGames);
        
        for (nG = 1; nG < nGames + 1; nG++) {
            tGame = typeOfGame();
            bGame = betOfGame();
            System.out.println("You are playing game " + nG + " of " + nGames + " games");
            
            switch(tGame){
                case 1: System.out.println("For game No "+ nG + " you chose ODD");
                break;
                case 2: System.out.println("For game No "+ nG + " you chose EVEN");
                break;
                case 3:System.out.println("For game No "+ nG + " you chose DRAW");
                break;
            }
            System.out.println("Your bet for Game No: " + nG + " is " + bGame + "\u20ac");
            System.out.println("");
            
            int even = calculateEarnings();
            }
    }
//Kino round   
    @Override
    public List<Integer> runADraw() {    
        Random randomNumbers = new Random();
        List<Integer> list1 = new ArrayList();
        Set<Integer> set1 = new LinkedHashSet();

        while (set1.size() < 20) {
            set1.add(randomNumbers.nextInt(80) + 1);
        }
        for (Integer a : set1) {
            list1.add(a);
        }
        return list1;
    }
    
//Kino Board printing and even calculation 
    @Override
    public int showDrawNumbers() {
        List<Integer> list1 = runADraw();
        
        int even = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) % 2 == 0) {
                even++;
            }
        }

        int jStart = 1;
        int jEnd = 10;
        System.out.println("-------------KINO------------");
        for (int i = 1; i <= 8; i++) {
            List<Integer> kinoLine = new ArrayList();

            for (int j = jStart; j <= jEnd; j++) {
                kinoLine.add(j);
            }
            
            for (int k = 0; k < 10; k++) {
                boolean ans = list1.contains(kinoLine.get(k));
                
                if (ans) {
                    System.out.print("\u001B[31m" + "");    //make the printing colour RED
                    System.out.format("%02d", kinoLine.get(k)); //to make the single digit numbers with a 0 in front
                    System.out.print(" ");
                    System.out.print("\u001B[37m" + "");    //return the printing colour to WHITE
                } else {
                    System.out.format("%02d", kinoLine.get(k));
                    System.out.print(" ");
                }
            }
            
            System.out.println("");

            jStart = jStart + 10;
            jEnd = jStart + 9;
        }
        System.out.println("-------------KINO------------");
        return even;
    }
    
    
    public static int numberOfGames() {
        
        int nGames = 0;
        System.out.println("Possible number of games: ");
        System.out.println("1 | 2 | 3 | 4 | 5 | 6 | 10 | 20 | 50 | 100 | 200");
        
        List<Integer> png = new ArrayList();
        png.add(1); png.add(2); png.add(3); png.add(4); png.add(5); png.add(6);
        png.add(10); png.add(20); png.add(50); png.add(100); png.add(200);
        
        nGames = intCheck();
        boolean ans = png.contains(nGames);
        while(true){
            if(ans){
                break;
            }else{
                System.out.println("Number of games not allowed");
                nGames = intCheck();
                ans = png.contains(nGames);
            }
        }
        numberOfDraws++;
        return nGames;
    }
    
    public static int typeOfGame(){
        
        int tGame = 0;
        System.out.println("Possible types of game: ");
        System.out.println("1.ODD | 2.EVEN | 3.DRAW");
        
        List<Integer> ptg = new ArrayList();
        ptg.add(1); ptg.add(2); ptg.add(3); 
        
        tGame = intCheck();
        boolean ans = ptg.contains(tGame);
        while(true){
            if(ans){
                break;
            }else{
                System.out.println("Type of game not allowed");
                tGame = intCheck();
                ans = ptg.contains(tGame);
            }
        }
        
        return tGame;
    }
    public static int betOfGame(){
        
        int bGame = 0;
        System.out.println("Possible bets per game: ");
        System.out.println("1\u20ac | 2\u20ac | 3\u20ac | 5\u20ac | 10\u20ac |"
                + " 15\u20ac | 20\u20ac | 30\u20ac | 50\u20ac | 100\u20ac");
        
        List<Integer> pbg = new ArrayList();
        pbg.add(1); pbg.add(2); pbg.add(3); pbg.add(5); pbg.add(10); pbg.add(15);
        pbg.add(20); pbg.add(30); pbg.add(50); pbg.add(100); 
        
        bGame = intCheck();
        boolean ans = pbg.contains(bGame);
        while(true){
            if(ans){
                break;
            }else{
                System.out.println("Bet of game not allowed");
                bGame = intCheck();
                ans = pbg.contains(bGame);
            }
        }
        
        return bGame;
    }
//Number checking method   
    public static int intCheck(){
        
        int x = 0;
        while (true) {
            if (sc.hasNextInt()) {
                x = sc.nextInt();
                break;
            } else {
                String m = sc.next();
                System.out.println("Wrong input. Use only numbers.");
            }
        }
        return x;
    }
    
//Calculation and printing of earnings for each draw
    @Override
    public int calculateEarnings() {
        int even = showDrawNumbers();
        System.out.println("");
        gameHistory.add(tGame);
        betHistory.add(bGame);
        
        switch(tGame){
                case 1: 
                    System.out.println("EVEN numbers drawn: " + (even));
                    System.out.println("ODD numbers drawn: " + (20-even));
                    if (even<10) {
                        System.out.println("You have won " + (2 * bGame)+"\u20ac");
                        System.out.println("");
                        totalEarnings = totalEarnings + (2 * bGame);
                        earningHistory.add(2 * bGame);
                    }else{
                        System.out.println("You have lost " + bGame +"\u20ac");
                        System.out.println("");
                        totalEarnings = totalEarnings - bGame;
                        earningHistory.add(-1 * bGame);
                }
                    
                break;
                case 2: 
                    System.out.println("EVEN numbers drawn: " + (even));
                    System.out.println("ODD numbers drawn: " + (20-even));
                    if (even>10) {
                        System.out.println("You have won " + (2 * bGame)+"\u20ac");
                        System.out.println("");
                        totalEarnings = totalEarnings + (2 * bGame);
                        earningHistory.add(2 * bGame);
                    }else{
                        System.out.println("You have lost " + bGame +"\u20ac");
                        System.out.println("");
                        totalEarnings = totalEarnings - bGame;
                        earningHistory.add(-1 * bGame);
                }
                break;
                case 3:
                    System.out.println("EVEN numbers drawn: " + (even));
                    System.out.println("ODD numbers drawn: " + (20-even));
                    if (even==10) {
                        System.out.println("You have won " + (4 * bGame)+"\u20ac");
                        System.out.println("");
                        totalEarnings = totalEarnings + (4 * bGame);
                        earningHistory.add(4 * bGame);
                    }else{
                        System.out.println("You have lost " + bGame +"\u20ac");
                        System.out.println("");
                        totalEarnings = totalEarnings - bGame;
                        earningHistory.add(-1 * bGame);
                }
                break;
            }
        return even;
    }
}
