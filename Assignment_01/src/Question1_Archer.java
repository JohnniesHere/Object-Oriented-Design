class Question1_Archer extends Question1_Character {
    public Question1_Archer(String name){
        super(name);
    }

    protected void initializeStats(){
        this.strength = 12;
        this.dexterity = 22;
        this.intelligence = 5;
        this.luck = 5;
        this.defense = 14;
        setMana(90 + intelligence);
        setHealth(130 + (dexterity /2)  + strength );
    }

    public String getCharacterType(){
        return "Archer";
    }

    @Override
    public void basicAttack(Question1_Character target) {
        int damage = 7 + (dexterity / 2);
        System.out.println(name + " shoots an arrow at " + target.getName() + "!");
        target.damage(damage);
    }

    @Override
    public void skill1(Question1_Character target) {
        if (!checkCooldown(1)) {
            System.out.println("Quick Shot is on cooldown!");
            return;
        }
        if (useMana(10)) {
            int damage = 12 + dexterity / 2;
            System.out.println(name + " uses Quick Shot on " + target.getName() + "!");
            target.damage(damage);
            skill1Cooldown = 2;
        }
    }

    @Override
    public void skill2(Question1_Character target) {
        if (!checkCooldown(2)) {
            System.out.println("Poison Arrow is on cooldown!");
            return;
        }
        if (useMana(15)) {
            int damage = 8 + (dexterity) + strength;
            System.out.println(name + " uses Poison Arrow on " + target.getName() + "!");
            target.damage(damage);
            skill2Cooldown = 4;
        }
    }

    @Override
    public void skill3(Question1_Character target) {
        if (!checkCooldown(3)) {
            System.out.println("Rain of Arrows is on cooldown!");
            return;
        }
        if (useMana(25)) {
            int damage = 20 + dexterity * 2;
            System.out.println(name + " uses Rain of Arrows!");
            target.damage(damage);
            skill3Cooldown = 5;
        }
    }

    @Override
    public void ultimateSkill(Question1_Character target) {
        if (!checkCooldown(4)) {
            System.out.println("Dragon Arrow is on cooldown!");
            return;
        }
        if (useMana(45)) {
            int damage = 40 + (dexterity * 2) + strength;
            System.out.println(name + " uses Dragon Arrow on " + target.getName() + "!");
            target.damage(damage);
            ultimateCooldown = 8;
        }
    }
}
