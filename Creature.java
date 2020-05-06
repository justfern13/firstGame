public class Creature {
   private int atk;
   private int def;
   private int spd;
   private int maxHp;
   private int currentHp;
   private String name;
   
   public Creature() {
      this.atk = 2;
      this.def = 1;
      this.spd = 1;
      this.maxHp = 10;
      this.currentHp = maxHp;
      
      this.name = "Vaj Eina";
   }
   
   public int getAtk() {
      return atk;
   }
   
   public int getDef() {
      return def;
   }
   
   public int getSpd() {
      return spd;
   }
   
   public int getCurrentHp() {
      return currentHp;
   }
   
   public int getMaxHp() {
      return maxHp; 
   }
  
   public String getName() {
      return name;
   }
   
   public void setAtk(int newAtk) {
      atk = newAtk;
   }
   
   public void setDef(int newDef) {
      def = newDef;
   }

   public void setSpd(int newSpd) {
      spd = newSpd;
   }
   
   public void setName(String newNam) {
      name = newNam;
   }
   
   public void setCurrentHp(int newHp) {
      currentHp = newHp;
   }
   
   public void setMaxHp(int newHp) {
      maxHp = newHp;
   }
   
   public void showStatus() {
      System.out.println("Name : " + name);
      System.out.println("HP : " + currentHp + "/" + maxHp);
      System.out.println(); 
   }
   
   public void showAllStats() {
      System.out.println("Name : " + name);
      System.out.println("HP   : " + currentHp + "/" + maxHp);
      System.out.println("Atk  : " + atk);
      System.out.println("Def  : " + def);
      System.out.println("Spd  : " + spd);
      System.out.println();       
   }
   
   public void gainLvl() {
      maxHp = maxHp + 3;
      atk++;
      def++;
      spd++;
      currentHp = maxHp;
   }
   
}