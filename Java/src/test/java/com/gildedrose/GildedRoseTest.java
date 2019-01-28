package com.gildedrose;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class GildedRoseTest {

    @Test
    public void given_foo_object_should_decrease_quality_after_a_day() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].mutableQuality);
    }

    @Test
    public void given_foo_object_should_decrease_sellin_after_a_day() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void given_sell_by_date_passed_quality_should_decrease_twice_as_fast() {
        Item[] items = new Item[]{new Item("foo", 0, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].mutableQuality);
    }


    @Test
    public void given_an_aged_brie_with_sell_by_date_passed_quality_should_decrease_twice_as_fast() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].mutableQuality);
    }

    @Test
    public void quality_should_never_be_negative() {
        Item[] items = new Item[]{new Item("foo", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].mutableQuality);
    }

    @Test
    public void given_item_Aged_Brie_quality_should_increase() {
        Item[] items = new Item[]{new Item("Aged Brie", 4, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].mutableQuality);
    }

    @Test
    public void quality_should_never_be_greater_than_50() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].mutableQuality);
    }

    @Test
    public void sulfuras_item_should_never_has_to_be_sold() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    public void sulfuras_item_should_never_decreases_in_quality() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].mutableQuality);
    }

    @Test
    @Parameters({"0, 2, 0",
            "5, 4, 7",
            "4, 4, 7",
            "10, 4, 6",
            "6, 4, 6",
            "11, 4, 5"})
    public void backstage_passes_item_should_have_increasing_quality_in_function_of_selling(int sellIn, int quality, int expectedQuality) {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(expectedQuality, app.items[0].mutableQuality);
    }
}
