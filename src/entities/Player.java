package entities;

public class Player extends Entity {
    private static final int MAX_HEAL_ATTEMPTS = 4;
    private static final float HEAL_PERCENTAGE = 0.3F;
    private final int maxHitPoints;
    private int healAttemptsLeft;

    public Player(int hitPoints, int attack, int defense, int minDamage, int maxDamage) {
        super(hitPoints, attack, defense, minDamage, maxDamage);
        this.healAttemptsLeft = MAX_HEAL_ATTEMPTS;
        this.maxHitPoints = hitPoints;
    }

    public void heal() {
        if (!isAlive() && healAttemptsLeft > 0) {
            int healAmount = (int) (maxHitPoints * HEAL_PERCENTAGE);
            hitPoints += healAmount;
            healAttemptsLeft--;
        }
    }
    public int getMaxHitPoints() {
        return maxHitPoints;
    }
    public int getHealAttemptsLeft() {
        return healAttemptsLeft;
    }
}
