package com.nagare.parts;

/**
 * @author ken.murayama
 *
 */
public class Kettle {

    public static HotWater boil(Water water) {
        return HotWater.inMilliliters(water.getAmount());
    }

}
