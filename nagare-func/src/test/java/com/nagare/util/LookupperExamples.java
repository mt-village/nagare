package com.nagare.util;

import com.nagare.parts.Color;
import org.junit.Test;

/**
 * @author ken.murayama
 *
 */
public class LookupperExamples {
    @Test
    public void test() {
        Color color = Color.lookup("青");
        System.out.println(color);

        color = Lookupper.lookup(Color.values(), "赤");
        System.out.println(color);
    }
}
