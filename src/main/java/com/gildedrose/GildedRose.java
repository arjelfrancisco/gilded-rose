package com.gildedrose;

import com.gildedrose.item.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {
            if(item instanceof Normal) {
                ((Normal) item).updateQuality();
            } else if(item instanceof AgedBrie) {
                ((AgedBrie) item).updateQuality();
            } else if(item instanceof BackstagePasses) {
                ((BackstagePasses) item).updateQuality();
            } else if(item instanceof Sulfuras) {
                ((Sulfuras) item).updateQuality();
            } else if(item instanceof Conjured) {
                ((Conjured) item).updateQuality();
            }
        }
    }

}
