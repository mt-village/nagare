package com.nagare;

import org.junit.Test;

import com.nagare.parts.CoffeeAddict;
import com.nagare.parts.Dripper;
import com.nagare.parts.GroundCoffeeBeans;
import com.nagare.parts.HotWater;
import com.nagare.parts.Kettle;
import com.nagare.parts.Mill;
import com.nagare.parts.Water;
import com.nagare.parts.WholeCoffeeBeans;

/**
 * @author ken.murayama
 *
 */
public class Examples2 {

    @Test
    public void hotWater_prepered_prepositive() {
        CoffeeAddict saya = new CoffeeAddict();
        Do.when(WholeCoffeeBeans.inGrams(50), HotWater.inMilliliters(500))
                .then(Mill::grind)
                .then(Dripper::drip)
                .done(saya::drink);
    }

    @Test
    public void hotWater_prepered_postpositive() {
        CoffeeAddict saya = new CoffeeAddict();
        Do.first(Mill::grind)
                .then(Dripper::drip)
                .done(saya::drink)
                .by(WholeCoffeeBeans.inGrams(50), HotWater.inMilliliters(500));
    }

    @Test
    public void groundCoffeeBeans_prepered_prepositive() {
        CoffeeAddict saya = new CoffeeAddict();
        Do.when(GroundCoffeeBeans.inGrams(50), Water.inMilliliters(500))
                .thenR(Kettle::boil)
                .then(Dripper::drip)
                .done(saya::drink);
    }

    @Test
    public void groundCoffeeBeans_prepered_postpositive() {
        CoffeeAddict saya = new CoffeeAddict();
        Do.first(Kettle::boil)
                .thenR(Dripper::drip)
                .done(saya::drink)
                .by(GroundCoffeeBeans.inGrams(50), Water.inMilliliters(500));
    }

    @Test
    public void hotWater_and_groundCoffeeBeans_prepered_prepositive() {
        CoffeeAddict saya = new CoffeeAddict();
        Do.when(GroundCoffeeBeans.inGrams(50), HotWater.inMilliliters(500))
                .then(Dripper::drip)
                .done(saya::drink);
    }

    @Test
    public void hotWater_and_groundCoffeeBeans_prepered_postpositive() {
        CoffeeAddict saya = new CoffeeAddict();
        Do.first(Dripper::drip)
                .done(saya::drink)
                .by(GroundCoffeeBeans.inGrams(50), HotWater.inMilliliters(500));
    }
}
