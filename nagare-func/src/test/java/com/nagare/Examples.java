package com.nagare;

import org.junit.Test;

import com.nagare.function.Saver;
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
public class Examples {

    @Test
    public void easygoing() {
        WholeCoffeeBeans wholeBeans = WholeCoffeeBeans.inGrams(50);
        GroundCoffeeBeans groundBeans = Mill.grind(wholeBeans);
        Water water = Water.inMilliliters(500);
        HotWater hotWater = Kettle.boil(water);
        Coffee coffee = Dripper.drip(groundBeans, hotWater);
        CoffeeAddict saya = new CoffeeAddict();
        saya.drink(coffee);
    }

    @Test
    public void impatient() {
        new CoffeeAddict()
                .drink(Dripper.drip(Mill.grind(WholeCoffeeBeans.inGrams(50)),
                        Kettle.boil(Water.inMilliliters(500))));
    }

    @Test
    public void nagare_prepositive() {
        CoffeeAddict saya = new CoffeeAddict();
        Do.when(WholeCoffeeBeans.inGrams(50), Water.inMilliliters(500))
                .then(Do.first(Mill::grind).and(Kettle::boil))
                .then(Dripper::drip).done(saya::drink);
    }

    @Test
    public void nagare_logic_and_exec() {
        Saver<Coffee> brewCoffee = Do
                .when(WholeCoffeeBeans.inGrams(50), Water.inMilliliters(500))
                .then(Do.first(Mill::grind).and(Kettle::boil))
                .then(Dripper::drip);
        CoffeeAddict saya = new CoffeeAddict();
        saya.drink(brewCoffee.let());
    }
}
