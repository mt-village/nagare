package com.nagare.parts;

import com.nagare.parts.Coffee.Taste;

/**
 * @author ken.murayama
 *
 */
public class Dripper {

    public static Coffee drip(GroundCoffeeBeans beans, HotWater hotWater) {
        return new Coffee(hotWater.getAmount(), Taste.GOOD);
    }
}
