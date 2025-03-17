package com.gildedrose.process.item;

import com.gildedrose.Item;
import com.gildedrose.process.item.updater.*;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdaterFactory {
    private static final Map<String, ItemUpdater> updaterMap = new HashMap<>();

    static {
        updaterMap.put("Aged Brie", new AgedBrieUpdater());
        updaterMap.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        updaterMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaterMap.put("Conjured Mana Cake", new ConjuredUpdater());
    }

    public static ItemUpdater getUpdater(Item item) {

        return updaterMap.getOrDefault(item.name, new DefaultUpdater());
    }

}