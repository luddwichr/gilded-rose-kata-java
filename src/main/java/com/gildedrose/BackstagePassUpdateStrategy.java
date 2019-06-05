package com.gildedrose;

public class BackstagePassUpdateStrategy extends UpdateStrategy {
	@Override
	public void updateItem(Item item) {
		item.sellIn--;

		if (item.quality < 50) {
			if (item.sellIn < 5) {
				item.quality = Math.min(50, item.quality + 3);
			} else
			if (item.sellIn < 10) {
				item.quality = Math.min(50, item.quality + 2);
			} else {
				item.quality += 1;
			}
		}

		if (item.sellIn < 0) {
			item.quality = 0;
		}
	}
}
