package pl.edu.agh.dronka.shop.model.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Index;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Shop;
import pl.edu.agh.dronka.shop.model.User;

import pl.edu.agh.dronka.shop.model.categories.Books;
import pl.edu.agh.dronka.shop.model.categories.Electronics;
import pl.edu.agh.dronka.shop.model.categories.Food;
import pl.edu.agh.dronka.shop.model.categories.Music;
import pl.edu.agh.dronka.shop.model.categories.Sport;

import pl.edu.agh.dronka.shop.model.categories.Music.Genre;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ShopProvider {

	public static Shop getExampleShop() {
		Shop shop = new Shop();

		shop.addUser(getExampleUser());

		Index itemsIndex = new Index();

		for (Item item : getExampleItems()) {
			itemsIndex.addItem(item);
		}

		registerExampleCategories(itemsIndex);
		shop.setItemsIndex(itemsIndex);

		return shop;
	}

	public static User getExampleUser() {
		return new User("Jan", "Rejnor");
	}

	public static List<Item> getExampleItems() {
		List<Item> items = new ArrayList<>();

		CSVReader booksReader = new CSVReader("resources/books.csv");
		items.addAll(readItems(booksReader, Category.BOOKS));
		
		CSVReader electronicsReader = new CSVReader("resources/electronics.csv");
		items.addAll(readItems(electronicsReader, Category.ELECTRONICS));
		
		CSVReader foodReader = new CSVReader("resources/food.csv");
		items.addAll(readItems(foodReader, Category.FOOD));
		
		CSVReader musicReader = new CSVReader("resources/music.csv");
		items.addAll(readItems(musicReader, Category.MUSIC));
		
		CSVReader sportReader = new CSVReader("resources/sport.csv");
		items.addAll(readItems(sportReader, Category.SPORT));

		return items;
	}

	public static void registerExampleCategories(Index index) {
		for (Category category : Category.values()) {
			index.registerCategory(category);
		}
	}

	private static List<Item> readItems(CSVReader reader, Category category) {
		List<Item> items = new ArrayList<>();

		try {
			reader.parse();
			List<String[]> data = reader.getData();

			for (String[] dataLine : data) {
	
				String name = reader.getValue(dataLine,"Name");
				int price = Integer.parseInt(reader.getValue(dataLine, "Price"));
				int quantity = Integer.parseInt(reader.getValue(dataLine,
						"Quantity"));
        
        Item item = new Item(name, category, price, quantity);

				boolean isPolish = Boolean.parseBoolean(reader.getValue(dataLine, "Polish"));
				boolean isSecondhand = Boolean.parseBoolean(reader.getValue(dataLine, "Secondhand"));

        item.setPolish(isPolish);
				item.setSecondhand(isSecondhand);

        if (category == Category.BOOKS) {

				  int numberOfPages = Integer.parseInt(reader.getValue(dataLine, "Number of pages"));
				  boolean hardback = Boolean.parseBoolean(reader.getValue(dataLine, "Hardback"));

					Books books = new Books(item, numberOfPages, hardback);
					items.add(books);

        } else if (category == Category.ELECTRONICS) {

				  boolean mobile = Boolean.parseBoolean(reader.getValue(dataLine, "Mobile"));
				  boolean guarantee = Boolean.parseBoolean(reader.getValue(dataLine, "Guarantee"));

					Electronics electronics = new Electronics(item, mobile, guarantee);
					items.add(electronics);

        } else if (category == Category.FOOD) {
					
          String input = reader.getValue(dataLine, "ExpiryDate");
          SimpleDateFormat parser = new SimpleDateFormat("dd.mm.yyyy.");

          try {
            Date expiryDate = parser.parse(input);
						Food food = new Food(item, expiryDate);
						items.add(food);
          }
          catch (Exception e) {
            // do nothing
          }

        } else if (category == Category.MUSIC) {
					
					Genre genre;
					try {
						genre = Genre.valueOf((String) reader.getValue(dataLine, "Genre"));
		
					} catch (Exception e) {
            genre = Genre.TURBO_FOLK;
					}

					boolean videoIncluded = Boolean.parseBoolean(reader.getValue(dataLine, "VideoIncluded"));

					Music music = new Music(item, genre, videoIncluded);
					items.add(music);

        } else if (category == Category.SPORT) {

          Sport sport = new Sport(item);
					items.add(sport);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

}
