package com.nagare.parts;

/**
 * @author ken.murayama
 *
 */
public class CoffeeAddict {

    public void drink(Coffee coffee) {
        switch (coffee.getTaste()) {
        case GOOD:
            System.out.println("Excellent!");
            break;
        case TERRIBLE:
            System.out.println("I don't care!");
            break;
        default:
            System.out.println("Not bad!");
            break;
        }
    }
}
