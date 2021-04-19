package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Category;

import pl.edu.agh.dronka.shop.model.categories.Books;
import pl.edu.agh.dronka.shop.model.categories.Electronics;
import pl.edu.agh.dronka.shop.model.categories.Food;
import pl.edu.agh.dronka.shop.model.categories.Music;
import pl.edu.agh.dronka.shop.model.categories.Sport;

public class ItemFilter {

	private Category category;

	private Item itemSpec = new Item();

	private Books booksSpec = new Books();
	private Electronics electronicsSpec = new Electronics();
	private Food foodSpec = new Food();
	private Music musicSpec = new Music();
	private Sport sportSpec = new Sport();

	public ItemFilter() {
		
	}

	public Item getItemSpec() {
    return itemSpec;
	}

	public Books getBooksSpec() {
		return booksSpec;
	}

	public Electronics getElectronicsSpec() {
		return electronicsSpec;
	}

	public Food getFoodSpec() {
		return foodSpec;
	}

	public Music getMusicSpec() {
		return musicSpec;
	}

	public Sport sportSpec() {
		return sportSpec;
	}

	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		switch(item.getCategory()) {
  		case BOOKS:

				Books books = (Books) item;
				if (booksSpec.isHardback() && !books.isHardback()) {
					return false;
				}
    		break;

  		case ELECTRONICS:

    		Electronics electronics = (Electronics) item;
				if (electronicsSpec.isMobile() && !electronics.isMobile()) {
					return false;
				}
				if (electronicsSpec.isGuarantee() && !electronics.isGuarantee()) {
					return false;
				}
    		break;

  		case FOOD:
    		
    		break;

  		case MUSIC:

    		Music music = (Music) item;
				if (musicSpec.isVideoIncluded() && !music.isVideoIncluded()) {
					return false;
				}
    		break;

  		case SPORT:
    		
    		break;

			}




		return true;
	}

}