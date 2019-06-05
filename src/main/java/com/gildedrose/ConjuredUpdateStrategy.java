package com.gildedrose;

public class ConjuredUpdateStrategy extends UpdateStrategy {
	@Override
	public void updateItem(Item item) {
		item.sellIn--;
		if (item.quality > 0) {
			item.quality = Math.max(0, item.quality - (item.sellIn < 0 ? 4 : 2));
		}
	}
}
