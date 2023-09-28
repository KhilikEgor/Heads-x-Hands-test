package model;

public class Entity {
    int hitPoints;
    int attack;
    int defense;

    public Entity() {
    }

    public Entity(int hitPoints, int attack, int defense) {
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.defense = defense;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }
}
