package com.nagare.parts;

/**
 * @author ken.murayama
 *
 */
public class HotWater {

    private final double amount;

    private HotWater(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public static HotWater inMilliliters(double amount) {
        return new HotWater(amount);
    }
}
