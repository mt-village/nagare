package com.nagare.parts;

/**
 * @author ken.murayama
 *
 */
public class Coffee {
    public enum Taste {
        GOOD, BAD, TERRIBLE
    }

    private final double amount;
    private final Taste taste;

    /**
     * @param amount
     *            : in milliliter
     * @param taste
     */
    public Coffee(double amount, Taste taste) {
        this.amount = amount;
        this.taste = taste;
    }

    public double getAmount() {
        return amount;
    }

    public Taste getTaste() {
        return taste;
    }
}
