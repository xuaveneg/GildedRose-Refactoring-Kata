package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].mutableQuality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].mutableQuality = items[i].mutableQuality - 1;
                    }
                }
            } else {
                if (items[i].mutableQuality < 50) {
                    items[i].mutableQuality = items[i].mutableQuality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].mutableQuality < 50) {
                                items[i].mutableQuality = items[i].mutableQuality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].mutableQuality < 50) {
                                items[i].mutableQuality = items[i].mutableQuality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].mutableQuality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].mutableQuality = items[i].mutableQuality - 1;
                            }
                        }
                    } else {
                        items[i].mutableQuality = items[i].mutableQuality - items[i].mutableQuality;
                    }
                } else {
                    if (items[i].mutableQuality < 50) {
                        items[i].mutableQuality = items[i].mutableQuality + 1;
                    }
                }
            }
        }
    }
}