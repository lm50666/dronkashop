package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Item;

import pl.edu.agh.dronka.shop.model.Category;

import pl.edu.agh.dronka.shop.model.categories.Books;
import pl.edu.agh.dronka.shop.model.categories.Electronics;
import pl.edu.agh.dronka.shop.model.categories.Food;
import pl.edu.agh.dronka.shop.model.categories.Music;
import pl.edu.agh.dronka.shop.model.categories.Sport;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Name", item.getName());
		propertiesMap.put("Price", item.getPrice());
		propertiesMap.put("Category", item.getCategory().getDisplayName()); 
		propertiesMap.put("Quantity", Integer.toString(item.getQuantity()));
		propertiesMap.put("Polish", item.isPolish());
		propertiesMap.put("Secondhand", item.isSecondhand());

		Category category = item.getCategory();

		if (category == Category.BOOKS) {

			Books books = (Books) item;
			propertiesMap.put("NumberOfPages", Integer.toString(books.getNumberOfPages()));
			propertiesMap.put("Hardback", books.isHardback());

		} else if (category == Category.ELECTRONICS) {

			Electronics electronics = (Electronics) item;
			propertiesMap.put("Mobile", electronics.isMobile());
			propertiesMap.put("Guarantee", electronics.isGuarantee());

		} else if (category == Category.FOOD) {
			
			Food food = (Food) item;		
			propertiesMap.put("ExpiryDate", food.getExpiryDate());

		} else if (category == Category.MUSIC) {

			Music music = (Music) item;			
			propertiesMap.put("Genre", music.getGenre());
			propertiesMap.put("VideoIncluded", music.isVideoIncluded());

		} else if (category == Category.SPORT) {

			Sport sport = (Sport) item;		

		}

		return propertiesMap;
	}
}
