package com.nagare.parts;

/**
 * @author ken.murayama
 *
 */
public class Mill {
    public static GroundCoffeeBeans grind(WholeCoffeeBeans beans) {
        return GroundCoffeeBeans.inGrams(beans.getAmount());
    }
}
