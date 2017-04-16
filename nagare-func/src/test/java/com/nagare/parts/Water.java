package com.nagare.parts;

/**
 * @author ken.murayama
 *
 */
public class Water {

    private final double amount;

    private Water(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public static Water inMilliliters(double amount) {
        return new Water(amount);
    }
}
