package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.quality.QualityManager;

public class AgedBrie extends Item implements QualityManager {

    public static final int DEGRADE_RATE = -1;
    public static final int MAX_QUALITY = 50;

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if(this.quality < MAX_QUALITY) {
            this.quality -= DEGRADE_RATE;
        }

        this.sellIn--;
    }
}
