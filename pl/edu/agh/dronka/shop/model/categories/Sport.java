package pl.edu.agh.dronka.shop.model.categories;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Category;

public class Sport extends Item{

	public Sport(Item item) {
		super(item.getName(), item.getCategory(), item.getPrice(), item.getQuantity());
		setPolish(item.isPolish());
		setSecondhand(item.isSecondhand());
	}

	public Sport(){
		
	}
	
}




