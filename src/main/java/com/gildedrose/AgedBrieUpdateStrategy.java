package com.gildedrose;

public class AgedBrieUpdateStrategy extends UpdateStrategy {
	@Override
	public void updateItem(Item item) {
		item.sellIn--;
		if (item.quality < 50) {
			item.quality = Math.min(50, item.quality + (item.sellIn < 0 ? 2 : 1));
		}
	}
}
