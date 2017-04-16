package com.nagare.parts;

/**
 * @author ken.murayama
 *
 */
public class GroundCoffeeBeans {

    private final double amount;

    private GroundCoffeeBeans(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public static GroundCoffeeBeans inGrams(double amount) {
        return new GroundCoffeeBeans(amount);
    }
}
