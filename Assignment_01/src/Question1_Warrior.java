class Question1_Warrior extends Question1_Character {
    public Question1_Warrior(String name){
        super(name);
    }

    protected void initializeStats(){
        this.strength = 18;
        this.dexterity = 10;
        this.intelligence = 5;
        this.luck = 5;
        this.defense = 20;
        setMana(90 + intelligence);
        setHealth(250 + strength);
    }

    public String getCharacterType(){
        return "Warrior";
    }

    @Override
    public void basicAttack(Question1_Character target) {
        int damage = 8 + (strength / 2);
        System.out.println(name + " swings their sword at " + target.getName() + "!");
        target.damage(damage);
    }

    @Override
    public void skill1(Question1_Character target) {
        if (!checkCooldown(1)) {
            System.out.println("Shield Bash is on cooldown!");
            return;
        }
        if (useMana(10)) {
            int damage = 10 + (strength / 2);
            System.out.println(name + " uses Shield Bash on " + target.getName() + "!");
            target.damage(damage);
            skill1Cooldown = 2;
        }
    }

    @Override
    public void skill2(Question1_Character target) {
        if (!checkCooldown(2)) {
            System.out.println("Whirlwind is on cooldown!");
            return;
        }
        if (useMana(20)) {
            int damage = 15 + strength + dexterity;
            System.out.println(name + " uses Whirlwind!");
            target.damage(damage);
            skill2Cooldown = 4;
        }
    }

    @Override
    public void skill3(Question1_Character target) {
        if (!checkCooldown(3)) {
            System.out.println("Battle Cry is on cooldown!");
            return;
        }
        if (useMana(15)) {
            System.out.println(name + " uses Battle Cry!");
            strength += 5;
            defense += 15;
            skill3Cooldown = 5;
        }
    }

    @Override
    public void ultimateSkill(Question1_Character target) {
        if (!checkCooldown(4)) {
            System.out.println("Berserk Mode is on cooldown!");
            return;
        }
        if (useMana(40)) {
            System.out.println(name + " enters Berserk Mode!");
            strength *= 2;
            defense /= 4;
            ultimateCooldown = 10;
        }
    }
}
