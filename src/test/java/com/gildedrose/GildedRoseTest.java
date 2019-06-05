package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

	@Test
	public void sellIn_normalItem_decreasesByOne() {
		Item item = normalItem(1, 2);
		gildedRoseWith(item).updateQuality();
		assertThat(item.sellIn).isEqualTo(0);
	}

	@Test
	public void quality_normalItem_beforeSellDate_decreasesByOne() {
		Item item = normalItem(1, 2);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(1);
	}

	@Test
	public void quality_normalItem_afterSellDate_decreasesByTwo() {
		Item item = normalItem(0, 3);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(1);
	}

	@Test
	public void quality_multipleItems_updated() {
		Item firstItem = normalItem(1, 3);
		Item secondItem = normalItem(1, 2);
		gildedRoseWith(firstItem, secondItem).updateQuality();
		assertThat(firstItem.quality).isEqualTo(2);
		assertThat(secondItem.quality).isEqualTo(1);
	}

	@Test
	public void quality_normalItem_doesNotTurnNegative() {
		Item item = normalItem(0, 0);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(0);
	}
	@Test
	public void quality_agedBrie_beforeSellDate_increasesByOne() {
		Item item = agedBrieItem(1, 1);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(2);
	}

	@Test
	// note: unclear in requirements: only stated that it decreases with age, not twice as fast though!
	public void quality_agedBrie_afterSellDate_increasesByTwo() {
		Item item = agedBrieItem(0, 1);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(3);
	}

	@Test
	public void quality_aged_brie_beforeSellDate_doesNotTurnMoreThan50() {
		Item item = agedBrieItem(1, 50);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(50);
	}


	@Test
	public void quality_aged_brie_afterSellDate_doesNotTurnMoreThan50() {
		Item item = agedBrieItem(0, 50);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(50);
	}

	@Test
	public void sellIn_sulfurasItem_doesNotChange() {
		Item item = sulfurasItem(1, 2);
		gildedRoseWith(item).updateQuality();
		assertThat(item.sellIn).isEqualTo(1);
	}

	@Test
	// note: name for sulfuras item was not completely specified in requirements
	public void quality_sulfurasItem_beforeSellDate_doesNotChange() {
		Item item = sulfurasItem(1, 1);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(1);
	}

	@Test
	public void quality_sulfurasItem_afterSellDate_doesNotChange() {
		Item item = sulfurasItem(0, 2);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(2);
	}

	@Test
	public void quality_backstagePassItem_moreThanTenDaysBeforeSellDate_increasesByOne() {
		Item item = backstagePassItem(11, 0);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(1);
	}

	@Test
	public void quality_backstagePassItem_TenDaysBeforeSellDate_increasesByTwo() {
		Item item = backstagePassItem(10, 1);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(3);
	}

	@Test
	public void quality_backstagePassItem_FiveDaysBeforeSellDate_increasesByThree() {
		Item item = backstagePassItem(5, 2);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(5);
	}

	@Test
	public void quality_backstagePassItem_afterSellDate_dropsToZero() {
		Item item = backstagePassItem(0, 3);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(0);
	}

	@Test
	public void quality_backstagePassItem_moreThan10DaysBeforeSellDate_doesNotTurnMoreThan50() {
		Item item = backstagePassItem(11, 50);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(50);
	}

	@Test
	public void quality_backstagePassItem_lessThan10DaysBeforeSellDate_doesNotTurnMoreThan50() {
		Item item = backstagePassItem(10, 49);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(50);
	}

	@Test
	public void quality_backstagePassItem_lessThan5DaysBeforeSellDate_doesNotTurnMoreThan50() {
		Item item = backstagePassItem(4, 48);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(50);
	}

	@Test
	public void quality_conjuredItem_beforeSellDate_decreasesByTwo() {
		Item item = conjuredItem(1, 3);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(1);
	}

	@Test
	public void quality_conjuredItem_afterSellDate_decreasesByFour() {
		Item item = conjuredItem(0, 5);
		gildedRoseWith(item).updateQuality();
		assertThat(item.quality).isEqualTo(1);
	}

	private GildedRose gildedRoseWith(Item... items) {
		return new GildedRose(items);
	}

	private Item normalItem(int sellIn, int quality) {
		return new Item("Normal Item", sellIn, quality);
	}

	private Item agedBrieItem(int sellIn, int quality) {
		return new Item("Aged Brie", sellIn, quality);
	}

	private Item sulfurasItem(int sellIn, int quality) {
		return new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
	}

	private Item backstagePassItem(int sellIn, int quality) {
		return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
	}

	private Item conjuredItem(int sellIn, int quality) {
		return new Item("Conjured Mana Cake", sellIn, quality);
	}
}
