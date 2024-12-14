public class Question1_DemoBattle {
/**
 * Main demo class showing how all OOP concepts work together
 * Demonstrates:
 * 1. Object Creation
 * 2. Polymorphism in action
 * 3. System composition
 */
    public static void main(String[] args) {
        Question1_Character wizard = new Question1_Wizard("Gandalf");
        Question1_Character warrior = new Question1_Warrior("Arthur");
        Question1_Character archer = new Question1_Archer("Legolas");
        Question1_Character thief = new Question1_Thief("Ezio");

        System.out.println("Initializing Players");
        wizard.displayStatus();
        warrior.displayStatus();
        archer.displayStatus();
        thief.displayStatus();

        System.out.println("\n=== Tournament Mode ===");
        Question1_Character[] fighters = {wizard, warrior, archer, thief};
        runTournament(fighters);
    }

    public static void runTournament(Question1_Character[] fighters) {
        System.out.println("\nTournament Starting with " + fighters.length + " players");

        Question1_Character[] tournamentFighters = new Question1_Character[fighters.length];

        for (int i = 0; i < fighters.length; i++) {
            final Question1_Character originalFighter = fighters[i];
            switch (originalFighter.getCharacterType()) {
                case "Wizard":
                    tournamentFighters[i] = new Question1_Wizard(originalFighter.getName());
                    break;
                case "Warrior":
                    tournamentFighters[i] = new Question1_Warrior(originalFighter.getName());
                    break;
                case "Archer":
                    tournamentFighters[i] = new Question1_Archer(originalFighter.getName());
                    break;
                case "Thief":
                    tournamentFighters[i] = new Question1_Thief(originalFighter.getName());
                    break;
            }
        }

        // Run tournament matches
        for (int i = 0; i < tournamentFighters.length; i++) {
            for (int j = i + 1; j < tournamentFighters.length; j++) {
                if (tournamentFighters[i].isAlive() && tournamentFighters[j].isAlive()) {
                    System.out.println("\n=== Tournament Match ===");
                    Question1_BattleSystem.battle(tournamentFighters[i], tournamentFighters[j]);
                }
            }
        }

        // Find tournament winner
        Question1_Character winner = null;
        for (Question1_Character fighter : tournamentFighters) {
            if (fighter.isAlive()) {
                winner = fighter;
                break;
            }
        }

        if (winner != null) {
            System.out.println("\nTournament Champion: " + winner.getName() + " the " + winner.getCharacterType() + "!");
        } else {
            System.out.println("\nNo clear tournament winner!");
        }
    }
}