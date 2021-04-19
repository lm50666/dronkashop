package pl.edu.agh.dronka.shop.model.categories;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Category;

public class Music extends Item{

  public enum Genre {
  	ROCK,
		POP,
		TURBO_FOLK
	};

	private Genre genre;
	
	private boolean videoIncluded;

	public Music(Item item, Genre genre, boolean videoIncluded) {
		super(item.getName(), item.getCategory(), item.getPrice(), item.getQuantity());
		setPolish(item.isPolish());
		setSecondhand(item.isSecondhand());
		this.genre = genre;
		this.videoIncluded = videoIncluded;
	}

	public Music(){
		
	}

	public void setGenre(Genre genre) {
        this.genre = genre;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setVideoIncluded(boolean videoIncluded) {
    this.videoIncluded = videoIncluded;
  }

  public boolean isVideoIncluded() {
    return videoIncluded;
  }
}




