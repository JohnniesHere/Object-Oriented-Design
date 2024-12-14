/**
 * Concrete Class - Implements the abstract Character class
 * Demonstrates inheritance and polymorphism by providing specific
 * implementations of abstract methods and overriding base behavior
 */

class Question1_Wizard extends Question1_Character {
    public Question1_Wizard(String name){
        super(name);
    }

    /**
     * Implementation of abstract method - required by inheritance
     * Sets unique stats for the Wizard class
     */
    protected void initializeStats(){
        this.strength = 5;
        this.dexterity = 5;
        this.intelligence = 20;
        this.luck = 8;
        this.defense = 12;
        setMana(150 + intelligence);
        setHealth(100 + strength);
    }

    public String getCharacterType(){
        return "Wizard";
    }

    /**
     * Skill implementations - Example of polymorphism
     * Each character class implements these methods differently
     */
    @Override
    public void basicAttack(Question1_Character target) {
        int damage = 5 + (intelligence / 4);
        System.out.println(name + " Use magic shot at " + target.getName() + "!");
        target.damage(damage);
    }

    @Override
    public void skill1(Question1_Character target) {
        if (!checkCooldown(1)) {
            System.out.println("Fireball is on cooldown!");
            return;
        }
        if (useMana(20)) {
            int damage = 15 + intelligence + (luck / 2);
            System.out.println(name + " Casts a Fireball at " + target.getName() + "!");
            target.damage(damage);
            skill1Cooldown = 2;
        }
    }

    @Override
    public void skill2(Question1_Character target) {
        if (!checkCooldown(2)) {
            System.out.println("Ice Shield is on cooldown!");
            return;
        }
        if (useMana(15)) {
            System.out.println(name + " Casts Ice Shield");
            defense += 30;
            heal(10);
            skill2Cooldown = 4;
        }
    }

    @Override
    public void skill3(Question1_Character target) {
        if (!checkCooldown(3)) {
            System.out.println("Lightning Bolt is on cooldown!");
            return;
        }
        if (useMana(25)) {
            int damage = 20 + (intelligence * 2) + (luck / 4);
            System.out.println(name + " Casts Lightning Bolt at " + target.getName() + "!");
            target.damage(damage);
            skill1Cooldown = 4;
        }
    }

    @Override
    public void ultimateSkill(Question1_Character target) {
        if (!checkCooldown(4)) {
            System.out.println("Armageddon is on cooldown!");
            return;
        }
        if (useMana(70)) {
            int damage = 50 + (intelligence * 2) + (luck * 2);
            System.out.println(name + " Casts Armageddon at " + target.getName() + "!");
            target.damage(damage);
            skill1Cooldown = 8;
        }
    }
}
