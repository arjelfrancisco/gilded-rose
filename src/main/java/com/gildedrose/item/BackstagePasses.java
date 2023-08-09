package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.quality.QualityManager;

public class BackstagePasses extends Item implements QualityManager {

    public static final int NORMAL_DEGRADE_RATE = -1;
    public static final int LESS_TEN_DAYS_DEGRADE_RATE = -2;
    public static final int LESS_FIVE_DAYS_DEGRADE_RATE = -3;
    public static final int MAX_QUALITY = 50;

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if(this.quality < MAX_QUALITY && this.sellIn >= 0) {
            if(this.sellIn <= 5) {
                this.quality -= LESS_FIVE_DAYS_DEGRADE_RATE;
            } else if(this.sellIn <= 10) {
                this.quality -= LESS_TEN_DAYS_DEGRADE_RATE;
            } else {
                this.quality -= NORMAL_DEGRADE_RATE;
            }

            if(this.quality > MAX_QUALITY) {
                this.quality = MAX_QUALITY;
            }
        } else if(this.sellIn < 0) {
            this.quality = 0;
        }

        this.sellIn--;
    }
}
