package org.sadovodBase;

import java.util.ArrayList;

public abstract class Animal {
    protected int x, y;
    protected int hunger; // уровень голода
    protected boolean alive = true;
    protected Island island;

    public Animal(int x, int y, Island island) {
        this.island = island;
        this.x = clampX(x);
        this.y = clampY(y);
        this.hunger = 5;
        island.getLocation(this.x, this.y).addAnimal(this);
    }


    protected int clampX(int x) {
        return Math.max(0, Math.min(x, island.getWidth() - 1));
    }

    protected int clampY(int y) {
        return Math.max(0, Math.min(y, island.getHeight() - 1));
    }

    public boolean isAlive() {
        return alive;
    }

    public void step() {
        if (!alive) return;

        eat();
        move();
        reproduce();

        hunger++;
        if (hunger > 10) {
            die();
        }
    }

    protected void move() {
        int newX = x + (int)(Math.random() * 3) - 1; // -1,0,+1
        int newY = y + (int)(Math.random() * 3) - 1;

        newX = clampX(newX);
        newY = clampY(newY);

        if (x != newX || y != newY) {
            island.getLocation(x, y).removeAnimal(this);
            island.getLocation(newX, newY).addAnimal(this);
            x = newX;
            y = newY;
        }
    }

    protected void die() {
        alive = false;
        island.getLocation(x, y).removeAnimal(this);
        System.out.printf("%s вмэр на (%d,%d) от голода%n", this.getClass().getSimpleName(), x, y);
    }

    protected abstract void eat();

    protected abstract void reproduce();
}