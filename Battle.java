import java.util.Scanner;

public class Battle {

   private boolean inBattle;
   private Creature enemy;
   private Creature player;
   
   public Battle(Creature mainChar) {
      inBattle = true;
      enemy = new Creature();
      player = mainChar;
      enemy.setName("BootyLicker");
      enemy.setAtk(2);
      enemy.setMaxHp(5);
      enemy.setCurrentHp(enemy.getMaxHp());
      
      System.out.println("You have run into a " + enemy.getName());
      System.out.println("Get ready for battle!!!");
      System.out.println();

      while(inBattle) {
         currentStatus();
         String choice = userChoice();
         //Creature attacker = checkPriority(player, enemy);

         if (choice.toLowerCase().equals("a")) {
            
            if (player.getSpd() >= enemy.getSpd()) {
               System.out.println("You swing your valiant pooperscoop and hit the " + enemy.getName());
               enemy.setCurrentHp(enemy.getCurrentHp() - (player.getAtk() - enemy.getDef()));
               System.out.println("You suck and get hit by " + enemy.getName() + "'s peenyweeny");
               System.out.println();
               player.setCurrentHp(player.getCurrentHp() - (enemy.getAtk() - enemy.getDef()));
            }
         } else if (choice.toLowerCase().equals("d")) {
            System.out.println("You defend! No damage taken.");
            System.out.println();
         } else if (choice.toLowerCase().equals("r")) {
            System.out.println("You a bitch.");
            inBattle = false;
         } else {
            System.out.println("Yo bro try again.");
         }
      }    
   }

   public void currentStatus() {
      player.showStatus();
      System.out.println();
      enemy.showStatus();
      System.out.println();      
   }


   public String userChoice () {
      System.out.println("What would you like to do?");
      System.out.println("A for Attack");
      System.out.println("D for Defend");
      System.out.println("R for Run");
      Scanner userInput = new Scanner(System.in);
      String battleChoice = userInput.nextLine();
      System.out.println();
      return battleChoice;

   }
   // method for attacking
   public void attack(Creature attacker, Creature defender) {
      int damage;
      int attack = attacker.getAtk();
      int defense = defender.getDef();
      if (attack <= defense) {
         damage = 0;
      } else {
         damage = attack - defense;
      }
      System.out.println(attacker + " goes in for a hit... Success!!");
      System.out.println(defender + " gets hit for " + damage + " damage.");
      System.out.println();
      defender.setCurrentHp(defender.getCurrentHp() - damage);
   }
   
   // checks priority based on each Creature's speed
   public Creature checkPriority(Creature player, Creature enemy) {
      if (enemy.getSpd() < player.getSpd()) {
         return enemy;
      } else {
         return player;
      }     
   }  
      
     /** while(inBattle) {
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
         */
}