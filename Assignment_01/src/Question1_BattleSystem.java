/**
 * Battle System - Demonstrates composition and high-level abstraction
 * Shows how different OOP concepts work together in a complete system
 */
public class Question1_BattleSystem {
    /**
     * Static method demonstrating polymorphism in action
     * Can handle any Character subclasses in combat
     */
    public static void battle(Question1_Character player1, Question1_Character player2) {
        System.out.println("\n=== BATTLE START ===");
        System.out.println(player1.getName() + " VS " + player2.getName());

        int round = 1;
        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("\nRound: " + round);
            player1.displayStatus();
            player2.displayStatus();

            if(player1.isAlive()){
                executeTurn(player1, player2);
            }

            if(player2.isAlive()){
                executeTurn(player2, player1);
            }

            player1.updateCooldown();
            player2.updateCooldown();

            round++;
        }

        System.out.println("\n=== BATTLE END ===");
        Question1_Character winner = player1.isAlive() ? player1 : player2;
        System.out.println(winner.getName() + " is Victorious");
    }

    private static void executeTurn(Question1_Character attacker, Question1_Character defender) {
        // Simulate AI decision making for skills
        int decision = (int)(Math.random() * 5); // 0-4 for different actions

        System.out.println("\n" + attacker.getName() + "'s turn:");

        switch(decision) {
            case 0:
                attacker.basicAttack(defender);
                break;
            case 1:
                attacker.skill1(defender);
                break;
            case 2:
                attacker.skill2(defender);
                break;
            case 3:
                attacker.skill3(defender);
                break;
            case 4:
                attacker.ultimateSkill(defender);
                break;
        }
    }
}
