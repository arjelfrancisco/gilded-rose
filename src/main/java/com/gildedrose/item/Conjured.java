package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.quality.QualityManager;

public class Conjured extends Item implements QualityManager {

    public static final int DEGRADE_RATE = Normal.DEGRADE_RATE * 2;
    public static final int MIN_QUALITY = 0;

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if(this.quality > MIN_QUALITY) {
            this.quality -= DEGRADE_RATE;
            if(this.sellIn < 0) {
                this.quality -= DEGRADE_RATE;
            }
        }

        if(this.quality < MIN_QUALITY) {
            this.quality = MIN_QUALITY;
        }

        this.sellIn--;
    }
}
