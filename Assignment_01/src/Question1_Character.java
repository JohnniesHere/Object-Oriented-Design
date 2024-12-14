/**
 * Interface - A contract that defines methods that all implementing classes must provide.
 * This demonstrates the Interface concept of OOP - defining a common behavior contract
 * that different classes can implement in their own ways.
 */

abstract class Question1_Character implements Question1_Skills {
    protected String name;
    protected int level;
    protected int health;
    protected int maxHealth;
    protected int mana;
    protected int maxMana;

    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int luck;
    protected int defense;
    protected boolean isAlive;

    protected int skill1Cooldown = 0;
    protected int skill2Cooldown = 0;
    protected int skill3Cooldown = 0;
    protected int ultimateCooldown = 0;

    public Question1_Character(String name) {
        this.name = name;
        this.level = 1;
        this.isAlive = true;
        initializeStats();
    }

    protected abstract void initializeStats();

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getHealth() {
        return health;
    }
    public int getMana() {
        return mana;
    }

    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Combat method demonstrating encapsulation and abstraction
     * Handles internal damage calculation and state updates
     */
    public void damage(int damage) {
        int actualDamage = Math.max(1, damage -  (defense / 2));
        health = Math.max(0, health - actualDamage);
        System.out.println(name + " takes " + actualDamage + " damage");
        if (health <= 0){
            isAlive = false;
            System.out.println(name + " is dead");
        }
    }

    public void heal(int amount){
        health = Math.min(maxHealth, health + amount);
        System.out.println(name + " heals " + amount + " HP");
    }

    public boolean useMana(int cost){
        if(mana >= cost){
            mana -= cost;
            return true;
        }
        System.out.println(name + " Doesn't have enough mana");
        return false;
    }

    protected void updateCooldown(){
        skill1Cooldown = Math.max(0, skill1Cooldown - 1);
        skill2Cooldown = Math.max(0, skill2Cooldown - 1);
        skill3Cooldown = Math.max(0, skill3Cooldown - 1);
        ultimateCooldown = Math.max(0, ultimateCooldown - 1);
    }

    protected boolean checkCooldown(int skillNumber){
        switch (skillNumber){
            case 1: return skill1Cooldown == 0;
            case 2: return skill2Cooldown == 0;
            case 3: return skill3Cooldown == 0;
            case 4: return ultimateCooldown == 0;
            default: return true;
        }
    }


    protected void setHealth(int health) {
        this.maxHealth = health;
        this.health = maxHealth;
    }
    protected void setMana(int mana) {
        this.maxMana = mana;
        this.mana = maxMana;
    }

    public abstract String getCharacterType();

    public void displayStatus(){
        System.out.println("\n=== " + name + " (" + getCharacterType() + ") ===");
        System.out.println("HP: " + health + "/" + maxHealth);
        System.out.println("MP: " + mana + "/" + maxMana);
        System.out.println("Level: " + level);
        System.out.println("Strength: " + strength);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Luck: " + luck);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Defense: " + defense);
    }
}

