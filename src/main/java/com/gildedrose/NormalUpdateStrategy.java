package com.gildedrose;

public class NormalUpdateStrategy extends UpdateStrategy {
	@Override
	public void updateItem(Item item) {
		item.sellIn--;
		if (item.quality > 0) {
			item.quality = Math.max(0, item.quality - (item.sellIn < 0 ? 2 : 1));
		}
	}
}
