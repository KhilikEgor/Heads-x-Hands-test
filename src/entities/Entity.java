package entities;

import java.util.Random;

public class Entity {
    Random random;
    int hitPoints;
    int attack;
    int defense;
    int minDamage;
    int maxDamage;

    public Entity(int hitPoints, int attack, int defense, int minDamage, int maxDamage) {
        parameterChecker(hitPoints, attack, defense);
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.defense = defense;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.random = new Random();
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public void takeDamage(int damage) {
        hitPoints -= damage;
        if (hitPoints <= 0) {
            hitPoints = 0;
        }
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return hitPoints;
    }

    public int attack(Entity target) {
        // Рассчитывается модификатор атаки
        int attackModifier = this.attack - target.defense + 1;
        // Всегда бросается хотя бы один кубик
        attackModifier = Math.max(attackModifier, 1);
        int numDiceRolls = attackModifier;
        int successfulRolls = 0;

        for (int i = 0; i < numDiceRolls; i++) {
            int roll = random.nextInt(6) + 1;
            if (roll > 5) {
                successfulRolls++;
            }
        }

        if (successfulRolls > 0) {
            // берется произвольное значение из параметра Урон атакующего и вычитается из Здоровья защищающегося
            int damage = random.nextInt(maxDamage - minDamage + 1) + minDamage;
            int totalDamage = Math.max(0, damage - target.defense);
            target.takeDamage(totalDamage);
            return totalDamage; // Возвращаем урон
        }

        return 0; // Если не было успешных бросков, возвращаем 0 урона
    }


    public void parameterChecker(int hitPoints, int attack, int defense) {
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("Incorrect attack");
        }
        if (defense < 1 || defense > 30) {
            throw new IllegalArgumentException("Incorrect defense");
        }
        if (hitPoints < 0) {
            throw new IllegalArgumentException("Incorrect hitPoints");
        }
    }
}
