package com.gildedrose;

public class UpdateStrategyFactory {

	private static final String AGED_BRIE_ITEM = "Aged Brie";
	private static final String BACKSTAGE_PASS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
	private static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";
	public static final String CONJURED_ITEM = "Conjured Mana Cake";

	public UpdateStrategy getStrategyFor(Item item) {
		switch (item.name) {
			case AGED_BRIE_ITEM:
				return new AgedBrieUpdateStrategy();
			case BACKSTAGE_PASS_ITEM:
				return new BackstagePassUpdateStrategy();
			case SULFURAS_ITEM:
				return new SulfurasUpdateStrategy();
			case CONJURED_ITEM:
				return new ConjuredUpdateStrategy();
			default:
				return new NormalUpdateStrategy();
		}
	}
}
