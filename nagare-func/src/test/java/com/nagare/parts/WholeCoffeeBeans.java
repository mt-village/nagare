package com.nagare.parts;

/**
 * @author ken.murayama
 *
 */
public class WholeCoffeeBeans {

    private final double amount;

    private WholeCoffeeBeans(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public static WholeCoffeeBeans inGrams(double amount) {
        return new WholeCoffeeBeans(amount);
    }
}
