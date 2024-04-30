import java.util.concurrent.ThreadLocalRandom;

public class Controls {

    public void drawCard(Player player) {
        // draws card in interval
        int cardNum = ThreadLocalRandom.current().nextInt(1, 10);
        System.out.println("You drew a: " + cardNum);
        player.location += cardNum;
        if (player.location >= 50) {
            player.location = 50;
        }
        else {
            System.out.println("You are currently at square " + player.location);
            betweenLines();
            if (player.life <= 0) {
                ;
            }
            else if ((player.life != 0) && ((player.location >= 4 && player.location <= 10) || (player.location >= 14 && player.location <= 20) || (player.location >= 24 && player.location <= 30) || (player.location >= 34 && player.location <= 40) || (player.location >= 44 && player.location <= 50))) {
                ;
            }
            else if ((player.life != 0) && (player.location == 12 || player.location == 32 || (player.location % 7 == 0 && player.location >= 10))) {
                ;
            }
            else if (player.life != 0 && player.location >= 50) {
                System.out.println("You have reached the end of the board!");
            }
            else {
                System.out.println("Input 'draw' to draw a card, input 'quit' to end game.");
            }
        }
    }

    public void leaderboard(Player player) {
        // initalize leaderboard

        // print boss statement based on num kills
        if (player.bossesKilled == 0 || player.bossesKilled > 1) {
            System.out.println("You killed: " + player.bossesKilled + " bosses");
        }
        else if (player.bossesKilled == 1) {
            System.out.println("You killed: " + player.bossesKilled + " boss");
        }

        // print life lost
        System.out.println("You lost: " + player.lifeLost + " life");
    }

    public void achievements(Player player) {
        if (player.bossesKilled == 5 || player.lifeLost == 0) {
            System.out.println("\n🏆 Achievements 🏆");
        }
        if (player.bossesKilled == 5) {
            System.out.println("🗡️ Valiant Fighter 🗡️ : You defeated all of the bosses ");
        }
        else if (player.lifeLost == 0) {
            System.out.println("🏥 So Healthy! 🏥 : You did not lose any life in your travels");
        }
        else if (player.bossesKilled == 5 && player.lifeLost == 0) {
            System.out.println("👑 God Amongst Mortals 👑 : You have defeated all the bosses and did not lose any life in the process");
        }
    }
    
    public void betweenLines() {
        System.out.println("");
        System.out.println("ʚ𖦹ɞ");
        System.out.println("");
    }
}