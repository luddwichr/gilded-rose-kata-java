package com.gildedrose;

class GildedRose {
	Item[] items;
	private UpdateStrategyFactory updateStrategyFactory = new UpdateStrategyFactory();

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			updateStrategyFactory.getStrategyFor(item).updateItem(item);
		}
	}

}
