package com.gildedrose.process.item.updater;

import com.gildedrose.Item;
import com.gildedrose.process.item.AbstractItemUpdater;

public class AgedBrieUpdater extends AbstractItemUpdater {
    @Override
    public void update(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) increaseQuality(item);
    }
}
