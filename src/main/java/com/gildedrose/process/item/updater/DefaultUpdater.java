package com.gildedrose.process.item.updater;

import com.gildedrose.Item;
import com.gildedrose.process.item.AbstractItemUpdater;

public class DefaultUpdater  extends AbstractItemUpdater {
    @Override
    public void update(Item item) {
        decreaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) decreaseQuality(item);
    }
}
