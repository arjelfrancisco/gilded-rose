package com.gildedrose;

import com.gildedrose.item.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    Item[] items;

    @BeforeEach
    public void setup() {
        items = new Item[]{
            new Normal("Normal 1", 10, 20),
            new AgedBrie("Aged Brie 1", 10 , 20),
            new Sulfuras("Sulfuras 1", 10, 20),
            new BackstagePasses("Backstage Passes 1", 20, 10),
            new Conjured("Conjured 1", 10, 11),
        };
    }

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void testPrint() {
        GildedRose gildedRose = new GildedRose(items);
        int days = 30;
        for(int i = 0; i < days; i++) {
            System.out.println("-------- Day " + i + " --------");
            System.out.println("NAME | SELL IN | QUALITY ");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            gildedRose.updateQuality();
        }
    }

    @Test
    public void testNormalItem() {
        GildedRose gildedRose = new GildedRose(items);

        int days = 15;
        for(int i = 0; i < days; i++) {
            gildedRose.updateQuality();
        }

        assertEquals(items[0].sellIn, -5);
        assertEquals(items[0].quality, 1);

        gildedRose.updateQuality();
        assertEquals(items[0].sellIn, -6);
        assertEquals(items[0].quality, 0);
    }

    @Test
    public void testAgedBrie() {

        GildedRose gildedRose = new GildedRose(items);
        int days = 29;
        for(int i = 0; i < days; i++) {
            gildedRose.updateQuality();
        }

        assertEquals(items[1].sellIn, -19);
        assertEquals(items[1].quality, 49);

        gildedRose.updateQuality();
        assertEquals(items[1].sellIn, -20);
        assertEquals(items[1].quality, 50);

        gildedRose.updateQuality();
        assertEquals(items[1].sellIn, -21);
        assertEquals(items[1].quality, 50);
    }

    @Test
    public void testSulfuras() {
        GildedRose gildedRose = new GildedRose(items);

        int days = 30;
        for(int i = 0; i < days; i++) {
            gildedRose.updateQuality();
        }

        assertEquals(items[2].sellIn, 10);
        assertEquals(items[2].quality, 80);

        gildedRose.updateQuality();
        assertEquals(items[2].sellIn, 10);
        assertEquals(items[2].quality, 80);
    }

    @Test
    public void testBackstagePasses() {
        GildedRose gildedRose = new GildedRose(items);
        int days = 21;
        for(int i = 0; i < days; i++) {
            gildedRose.updateQuality();
        }

        assertEquals(items[3].sellIn, -1);
        assertEquals(items[3].quality, 48);

        gildedRose.updateQuality();

        assertEquals(items[3].sellIn, -2);
        assertEquals(items[3].quality, 0);
    }

    @Test
    public void testConjured() {
        GildedRose gildedRose = new GildedRose(items);

        int days = 5;
        for(int i = 0; i < days; i++) {
            gildedRose.updateQuality();
        }

        assertEquals(items[4].sellIn, 5);
        assertEquals(items[4].quality, 1);

        gildedRose.updateQuality();
        assertEquals(items[4].sellIn, 4);
        assertEquals(items[4].quality, 0);
    }


}
