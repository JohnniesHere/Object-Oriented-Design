class Question1_Thief extends Question1_Character {
    public Question1_Thief(String name){
        super(name);
    }

    protected void initializeStats(){
        this.strength = 5;
        this.dexterity = 15;
        this.intelligence = 5;
        this.luck = 15;
        this.defense = 10;
        setMana(110 + intelligence);
        setHealth(110 + (dexterity /2) + strength );
    }

    public String getCharacterType(){
        return "Thief";
    }

    @Override
    public void basicAttack(Question1_Character target) {
        int damage = 6 + (luck / 2);
        System.out.println(name + " strikes with a dagger at " + target.getName() + "!");
        target.damage(damage);
    }

    @Override
    public void skill1(Question1_Character target) {
        if (!checkCooldown(1)) {
            System.out.println("Backstab is on cooldown!");
            return;
        }
        if (useMana(15)) {
            int damage = 15 + luck;
            System.out.println(name + " uses Backstab on " + target.getName() + "!");
            target.damage(damage);
            skill1Cooldown = 3;
        }
    }

    @Override
    public void skill2(Question1_Character target) {
        if (!checkCooldown(2)) {
            System.out.println("Smoke Bomb is on cooldown!");
            return;
        }
        if (useMana(20)) {
            System.out.println(name + " uses Smoke Bomb!");
            luck += 10;
            dexterity += 5;
            defense += 3;
            skill2Cooldown = 4;
        }
    }

    @Override
    public void skill3(Question1_Character target) {
        if (!checkCooldown(3)) {
            System.out.println("Shadow Step is on cooldown!");
            return;
        }
        if (useMana(25)) {
            int damage = 18 + (luck * 2) + dexterity;
            System.out.println(name + " uses Shadow Step on " + target.getName() + "!");
            target.damage(damage);
            skill3Cooldown = 4;
        }
    }

    @Override
    public void ultimateSkill(Question1_Character target) {
        if (!checkCooldown(4)) {
            System.out.println("Death Mark is on cooldown!");
            return;
        }
        if (useMana(50)) {
            int damage = 35 + (luck * 2);
            skill1Cooldown -= 1;
            skill2Cooldown -= 1;
            skill3Cooldown -= 1;
            System.out.println(name + " uses Death Mark on " + target.getName() + "!");
            target.damage(damage);
            ultimateCooldown = 8;
        }
    }
}
