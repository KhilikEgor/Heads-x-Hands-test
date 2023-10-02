import entities.Monster;
import entities.Player;

public class Game {
    public void Start() {
        Player player = new Player(100, 20, 10, 5, 20);
        Monster monster = new Monster(20, 15, 5, 100, 200);

        // Цикл битвы
        while (player.isAlive() && monster.isAlive()) {
            int playerDamage = player.attack(monster);
            System.out.println("Игрок атакует монстра и наносит " + playerDamage + " урона.");
            System.out.println("У монстра осталось " + monster.getHealth() + " здоровья." + "\n");

            if (!monster.isAlive()) {
                System.out.println("Монстр уничтожен!");
                break;
            }

            int monsterDamage = monster.attack(player);
            System.out.println("Монстр атакует игрока и наносит " + monsterDamage + " урона.");
            System.out.println("У игрока осталось " + player.getHealth() + " здоровья." + "\n");

            if (!player.isAlive()) {
                if (player.getHealAttemptsLeft() > 0) {
                    player.heal();
                    System.out.println("Игрок возродился с " + player.getHealth() + " HP!" + "\n");
                } else {
                    System.out.println("Игрок уничтожен!");
                    break;
                }
            }
        }

        if (player.isAlive()) {
            System.out.println("Поздравляем! Вы выиграли!");
        } else {
            System.out.println("Игра окончена. Вы проиграли.");
        }
    }
}
