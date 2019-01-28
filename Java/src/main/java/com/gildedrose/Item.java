package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int mutableQuality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.mutableQuality = quality;
    }

   @Override
   public String toString() {
       return this.name + ", " + this.sellIn + ", " + this.mutableQuality;
    }
}
