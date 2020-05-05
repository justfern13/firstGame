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
            battle(true, mainChar);    
         } else if (enterBattle.toLowerCase().equals("n")) {
            System.out.println("Ok...fuck you buddy");
            gameRunning = false;
         } else {
            System.out.println("Let's try this again...");  
         }
         
      }
   }
   
   public static void battle(boolean inBattle, Creature mainChar) {
      
      Creature enemy = new Creature();
      
      enemy.setName("BootyLicker");
      enemy.setAtk(2);
      enemy.setMaxHp(5);
      enemy.setCurrentHp(enemy.getMaxHp());
      
      while(inBattle) {
         System.out.println();
         System.out.println("You have run into a " + enemy.getName());
         System.out.println();
         mainChar.showStatus();
         System.out.println();
         enemy.showStatus();
         System.out.println();
         boolean turnChoice = true;
         while(turnChoice) {
            System.out.println("What would you like to do?");
            System.out.println("A for Attack");
            System.out.println("D for Defend");
            System.out.println("R for Run");
            Scanner userInput = new Scanner(System.in);
            String battleChoice = userInput.nextLine();
            System.out.println();
            if (battleChoice.toLowerCase().equals("a")) {
               if (mainChar.getSpd() >= enemy.getSpd()) {
                  System.out.println("You swing your valiant pooperscoop and hit the " + enemy.getName());
                  enemy.setCurrentHp(enemy.getCurrentHp() - (mainChar.getAtk() - enemy.getDef()));
                  System.out.println("You suck and get hit by " + enemy.getName() + "'s peenyweeny");
                  System.out.println();
                  mainChar.setCurrentHp(mainChar.getCurrentHp() - (enemy.getAtk() - enemy.getDef()));
                  mainChar.showStatus();
                  enemy.showStatus();
               }
            } else if (battleChoice.toLowerCase().equals("d")) {
               System.out.println("You defend! No damage taken.");
               System.out.println();
               mainChar.showStatus();
               enemy.showStatus();
            } else if (battleChoice.toLowerCase().equals("r")) {
               System.out.println("You a bitch.");
               turnChoice = false;
               inBattle = false;
            } else {
               System.out.println("Yo bro try again.");
            }
               
            if(mainChar.getCurrentHp() == 0) {
               System.out.println("Damn bro. You suck. And you died. LOL");
               mainChar.setCurrentHp(mainChar.getMaxHp());
               turnChoice = false;
               inBattle = false;
            } else if(enemy.getCurrentHp() == 0) {
               System.out.println("Cool story bro. You win. Have a level.");
               mainChar.gainLvl();
               mainChar.showAllStats();
               turnChoice = false;
               inBattle = false;
            }  
         }
      }     
   }  
}