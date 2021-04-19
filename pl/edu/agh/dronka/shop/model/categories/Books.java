package pl.edu.agh.dronka.shop.model.categories;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Category;

public class Books extends Item{

  private int numberOfPages;

  private boolean hardback;

	public Books(Item item, int numberOfPages, boolean hardback) {
		super(item.getName(), item.getCategory(), item.getPrice(), item.getQuantity());
		setPolish(item.isPolish());
		setSecondhand(item.isSecondhand());
		this.numberOfPages = numberOfPages;
		this.hardback = hardback;
	}

	public Books() {
		
	}

  public void setNumberOfPages(int numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  public void setHardback(boolean hardback) {
    this.hardback = hardback;
  }

  public boolean isHardback() {
    return hardback;
  }
}
