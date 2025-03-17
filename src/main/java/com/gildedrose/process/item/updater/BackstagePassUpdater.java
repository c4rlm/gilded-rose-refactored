package com.gildedrose.process.item.updater;

import com.gildedrose.Item;
import com.gildedrose.process.item.AbstractItemUpdater;

public class BackstagePassUpdater  extends AbstractItemUpdater {
    @Override
    public void update(Item item) {

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }

        increaseQuality(item);
        if (item.sellIn < 11) increaseQuality(item);
        if (item.sellIn < 6) increaseQuality(item);
    }
}
