package com.gildedrose.process.item;

import com.gildedrose.Item;

public abstract class AbstractItemUpdater implements ItemUpdater {
    protected void increaseQuality(Item item) {
        if (item.quality < 50) item.quality++;
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) item.quality--;
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}
