package com.nagare.parts;

import com.nagare.util.Labeled;
import com.nagare.util.Lookupper;

/**
 * @author ken.murayama
 *
 */
public enum Color implements Labeled {
    RED("赤"), // デフォルト
    BLUE("青");

    private String label;

    Color(String label) {
        this.label = label;
    }

    @Override
    public String label() {
        return label;
    }

    public static Color lookup(String label) {
        return Lookupper.lookupNullable(values(), label)
                .orElse(RED);
    }
}
