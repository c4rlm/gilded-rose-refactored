package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    private GildedRose gildedRose;

    @BeforeEach
    void setUp() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Conjured Mana Cake", 3, 6),
                new Item("Normal Item", 5, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48)
        };
        gildedRose = new GildedRose(items);
    }

    @Test
    void testAgedBrieIncreasesQuality() {
        gildedRose.updateQuality();
        assertEquals(1, gildedRose.items[0].quality);
    }

    @Test
    void testBackstagePassesIncreaseQuality() {
        gildedRose.updateQuality();
        assertEquals(21, gildedRose.items[1].quality);
    }

    @Test
    void testSulfurasQualityRemainsSame() {
        gildedRose.updateQuality();
        assertEquals(80, gildedRose.items[2].quality);
    }

    @Test
    void testConjuredItemDecreasesQualityTwiceAsFast() {
        gildedRose.updateQuality();
        assertEquals(4, gildedRose.items[3].quality);
    }

    @Test
    void testNormalItemDecreasesQuality() {
        gildedRose.updateQuality();
        assertEquals(9, gildedRose.items[4].quality);
    }

    @Test
    void testQualityNeverNegative() {
        for (int i = 0; i < 20; i++) {
            gildedRose.updateQuality();
        }
        assertEquals(0, gildedRose.items[4].quality);
    }

    @Test
    void testQualityNeverAbove50ExceptSulfuras() {
        for (int i = 0; i < 5; i++) {
            gildedRose.updateQuality();
        }
        assertTrue(gildedRose.items[1].quality <= 50);
        assertEquals(80, gildedRose.items[2].quality);
    }

    @Test
    void testBackstagePassesDropToZeroAfterConcert() {
        for (int i = 0; i < 16; i++) {
            gildedRose.updateQuality();
        }
        assertEquals(0, gildedRose.items[1].quality);
    }

    @Test
    void testBackstagePassesIncreaseMoreWhen10DaysOrLess() {
        gildedRose.updateQuality();
        assertEquals(50, gildedRose.items[5].quality);
    }
}