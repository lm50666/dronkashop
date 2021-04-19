package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

import pl.edu.agh.dronka.shop.model.Category;

import pl.edu.agh.dronka.shop.model.categories.Books;
import pl.edu.agh.dronka.shop.model.categories.Electronics;
import pl.edu.agh.dronka.shop.model.categories.Food;
import pl.edu.agh.dronka.shop.model.categories.Music;
import pl.edu.agh.dronka.shop.model.categories.Sport;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;
	private ItemFilter filter;

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties() {
		removeAll();

		this.filter = new ItemFilter();

		filter.getItemSpec().setCategory(shopController.getCurrentCategory());

		add(createPropertyCheckbox("Polish", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getItemSpec().setPolish(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));

		add(createPropertyCheckbox("Secondhand", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				filter.getItemSpec().setSecondhand(
						((JCheckBox) event.getSource()).isSelected());
				shopController.filterItems(filter);
			}
		}));

		switch(shopController.getCurrentCategory()) {
  		case BOOKS:

				add(createPropertyCheckbox("Hardback", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getBooksSpec().setHardback( ((JCheckBox) event.getSource()).isSelected() );
						shopController.filterItems(filter);
					}
				}));
    		break;

  		case ELECTRONICS:

				add(createPropertyCheckbox("Mobile", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getElectronicsSpec().setMobile( ((JCheckBox) event.getSource()).isSelected() );
						shopController.filterItems(filter);
					}
				}));
				add(createPropertyCheckbox("Guarantee", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getElectronicsSpec().setGuarantee( ((JCheckBox) event.getSource()).isSelected() );
						shopController.filterItems(filter);
					}
				}));
    		break;

  		case FOOD:
    		Food foodSpec = new Food();
    		break;
  		case MUSIC:

				add(createPropertyCheckbox("Video Included", new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						filter.getMusicSpec().setVideoIncluded( ((JCheckBox) event.getSource()).isSelected() );
						shopController.filterItems(filter);
					}
				}));
    		break;

  		case SPORT:

    		break;

			}
	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
