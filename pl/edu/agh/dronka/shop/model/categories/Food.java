package pl.edu.agh.dronka.shop.model.categories;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Category;
import java.util.Date;

public class Food extends Item{

  private Date expiryDate;

	public Food(Item item, Date expiryDate) {
		super(item.getName(), item.getCategory(), item.getPrice(), item.getQuantity());
		setPolish(item.isPolish());
		setSecondhand(item.isSecondhand());
		this.expiryDate = expiryDate;
	}

	public Food(){
		
	}

  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }
}
