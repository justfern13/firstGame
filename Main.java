import java.util.Scanner;

public class Main {
   
   public static void main(String[] args) {
      boolean gameRunning = true;
      boolean inBattle = false; 
      Scanner userIn = new Scanner(System.in);
    
      Creature mainChar = new Creature();
     
      mainChar.setName("CrazyVaj Eena");
      
      System.out.println("Hello " + mainChar.getName());
      
      while(gameRunning) {
         System.out.println("Would you like to enter a battle?  Y/N");
         String enterBattle = userIn.nextLine();
         System.out.println(enterBattle);
         if (enterBattle.toLowerCase().equals("y")) {
            Battle currentBattle = new Battle(mainChar);    
         } else if (enterBattle.toLowerCase().equals("n")) {
            System.out.println("Ok...fuck you buddy");
            gameRunning = false;
         } else {
            System.out.println("Let's try this again...");  
         }
      }
   }
}