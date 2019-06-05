package com.gildedrose;

public abstract class UpdateStrategy {
	static final String AGED_BRIE_ITEM = "Aged Brie";
	static final String BACKSTAGE_PASS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
	static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";

	public abstract void updateItem(Item item);
}
