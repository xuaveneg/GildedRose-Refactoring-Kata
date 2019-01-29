package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(currentItem -> {
            if (!currentItem.name.equals(AGED_BRIE)
                    && !currentItem.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                if (currentItem.mutableQuality > 0) {
                    if (!currentItem.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        currentItem.mutableQuality = currentItem.mutableQuality - 1;
                    }
                }
            } else {
                if (currentItem.mutableQuality < 50) {
                    currentItem.mutableQuality = currentItem.mutableQuality + 1;

                    if (currentItem.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (currentItem.sellIn < 11) {
                            if (currentItem.mutableQuality < 50) {
                                currentItem.mutableQuality = currentItem.mutableQuality + 1;
                            }
                        }

                        if (currentItem.sellIn < 6) {
                            if (currentItem.mutableQuality < 50) {
                                currentItem.mutableQuality = currentItem.mutableQuality + 1;
                            }
                        }
                    }
                }
            }
            if (!currentItem.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                currentItem.sellIn = currentItem.sellIn - 1;
            }
            if (currentItem.sellIn < 0) {
                if (!currentItem.name.equals(AGED_BRIE)) {
                    if (!currentItem.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                        if (currentItem.mutableQuality > 0) {
                            if (!currentItem.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                currentItem.mutableQuality = currentItem.mutableQuality - 1;
                            }
                        }
                    } else {
                        currentItem.mutableQuality = currentItem.mutableQuality - currentItem.mutableQuality;
                    }
                } else {
                    if (currentItem.mutableQuality < 50) {
                        currentItem.mutableQuality = currentItem.mutableQuality + 1;
                    }
                }
            }
        });
    }
}