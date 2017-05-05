package com.nagare.base;

import com.nagare.base.Do;
import org.junit.Test;

import com.nagare.base.BiFunc;
import com.nagare.parts.Coffee;
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
public class DoExamples {

    private CoffeeAddict saya = new CoffeeAddict();

    @Test
    public void usually_easygoing_style() { // for explain what to do
        WholeCoffeeBeans wholeBeans = WholeCoffeeBeans.inGrams(50);
        GroundCoffeeBeans groundBeans = Mill.grind(wholeBeans);
        Water water = Water.inMilliliters(500);
        HotWater hotWater = Kettle.boil(water);
        Coffee coffee = Dripper.drip(groundBeans, hotWater);
        saya.drink(coffee);
    }

    @Test
    public void usually_impatient_style() { // to confirm nested-code is un-readable
        new CoffeeAddict()
                .drink(Dripper.drip(Mill.grind(WholeCoffeeBeans.inGrams(50)),
                        Kettle.boil(Water.inMilliliters(500))));
    }

    @Test
    public void nagare_done_style() {
        Do.when(WholeCoffeeBeans.inGrams(50), Water.inMilliliters(500))
                .then(Do.first(Mill::grind).and(Kettle::boil))
                .then(Dripper::drip)
                .done(saya::drink);
    }

    @Test
    public void nagare_func_style() {
        Coffee coffee = Do
                .first(Do.first(Mill::grind).and(Kettle::boil))
                .then(Dripper::drip)
                .by(WholeCoffeeBeans.inGrams(50), Water.inMilliliters(500));
        saya.drink(coffee);
    }

    @Test
    public void nagare_logic_and_exec_style() {
        BiFunc<WholeCoffeeBeans, Water, Coffee> brewCoffee = Do
                .first(Do.first(Mill::grind).and(Kettle::boil))
                .then(Dripper::drip);
        saya.drink(brewCoffee.by(WholeCoffeeBeans.inGrams(50), Water.inMilliliters(500)));
    }

    // optional
    @Test
    public void hotWater_prepered_prepositive() {
        Do.when(WholeCoffeeBeans.inGrams(50), HotWater.inMilliliters(500))
                .then(Mill::grind)
                .then(Dripper::drip)
                .done(saya::drink);
    }

    @Test
    public void groundCoffeeBeans_prepered_prepositive() {
        Do.when(GroundCoffeeBeans.inGrams(50), Water.inMilliliters(500))
                .thenR(Kettle::boil)
                .then(Dripper::drip)
                .done(saya::drink);
    }

    @Test
    public void all_prepered_prepositive() {
        Do.when(GroundCoffeeBeans.inGrams(50), HotWater.inMilliliters(500))
                .then(Dripper::drip)
                .done(saya::drink);
    }
}
