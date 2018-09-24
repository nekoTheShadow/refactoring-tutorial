package ch7;

public class Item {
	private ItemType itemType;
	private String title;
	private int price;
	
	public Item(ItemType itemType, String title, int price) {
		this.itemType = itemType;
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("[ %d, %s, %d ]", itemType.getTypeCode(), title, price);
	}
}
