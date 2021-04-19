package pl.edu.agh.dronka.shop.model;

public enum Category {

	BOOKS("Books"), ELECTRONICS("Electronics"), FOOD("Food"), MUSIC("Music"), SPORT("Sport");

	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	private Category(String displayName) {
		this.displayName = displayName;
	}
}
