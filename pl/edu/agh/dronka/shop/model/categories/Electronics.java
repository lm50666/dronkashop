package pl.edu.agh.dronka.shop.model.categories;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Category;

public class Electronics extends Item{

  private boolean mobile;

  private boolean guarantee;

	public Electronics(Item item, boolean mobile, boolean guarantee) {
		super(item.getName(), item.getCategory(), item.getPrice(), item.getQuantity());
		setPolish(item.isPolish());
		setSecondhand(item.isSecondhand());
		this.mobile = mobile;
		this.guarantee = guarantee;
	}

	public Electronics(){
		
	}

  public void setMobile(boolean mobile) {
    this.mobile = mobile;
  }

  public boolean isMobile() {
    return mobile;
  }

  public void setGuarantee(boolean guarantee) {
    this.guarantee = guarantee;
  }

  public boolean isGuarantee() {
    return guarantee;
  }
}
