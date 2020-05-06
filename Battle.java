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
      breaks(1);

      while(inBattle) {
         //Checks HP of both player and enemy and breaks if either die
         if (player.getCurrentHp() == 0) {
            System.out.println("You died...You suck");
            breaks(2);
            player.setCurrentHp(player.getMaxHp());
            break;
         } else if (enemy.getCurrentHp() == 0) {
            System.out.println("You killed " + enemy.getName() + ". You gained a level");
            breaks(2);
            break;
         }
         
         currentStatus();
         
         //Decision loop for turn
         String choice = userChoice();
         Creature priority = checkPriority(player, enemy);
         if (priority == player) {
            if (choice.toLowerCase().equals("a")) {
                  if (player.getSpd() >= enemy.getSpd()) {
                     System.out.println("You swing your valiant pooperscoop and hit the " + enemy.getName());
                     enemy.setCurrentHp(enemy.getCurrentHp() - (player.getAtk() - enemy.getDef()));
                     System.out.println("You suck and get hit by " + enemy.getName() + "'s peenyweeny");
                     breaks(1);
                     player.setCurrentHp(player.getCurrentHp() - (enemy.getAtk() - enemy.getDef()));
                  }
            } else if (choice.toLowerCase().equals("d")) {
               System.out.println("You defend! No damage taken.");
               breaks(1);
            } else if (choice.toLowerCase().equals("r")) {
               System.out.println("You a bitch.");
               inBattle = false;
            } else {
               System.out.println("Yo bro try again.");
               breaks(2);
               
            }
         }
      } 
   }

   public void breaks(int x) {
      for (int i = 0; i < x; i++) {
         System.out.println();
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
}