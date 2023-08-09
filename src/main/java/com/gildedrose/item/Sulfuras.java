package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.quality.QualityManager;

public class Sulfuras extends Item implements QualityManager {

    public static final int QUALITY_VALUE = 80;

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, QUALITY_VALUE);
    }

    @Override
    public void updateQuality() {
        // Values for this is never altered
    }
}
