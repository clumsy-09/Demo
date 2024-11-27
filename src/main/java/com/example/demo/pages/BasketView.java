package com.example.demo.pages;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("basket-view")
public class BasketView extends VerticalLayout {

    private List<BasketItem> basketItems = new ArrayList<>(); // Simulates the basket data
    private Grid<BasketItem> basketGrid = new Grid<>(BasketItem.class); // Grid to display items
    private Label totalPriceLabel = new Label("Total Price: $0.00"); // Label for total price
    private Button checkoutButton = new Button("Checkout");

    public BasketView() {
        // Set up dummy basket items (replace with real data later)
        basketItems.add(new BasketItem("ABC123", "Product 1", "Description 1", 2, 50.0));
        basketItems.add(new BasketItem("DEF456", "Product 2", "Description 2", 1, 100.0));

        // Configure the basket grid
        basketGrid.setItems(basketItems);
        basketGrid.setColumns("sku", "name", "quantity", "price", "totalPrice");
        basketGrid.getColumnByKey("totalPrice").setHeader("Total Price");

        // Calculate and display total price
        updateTotalPrice();

        // Checkout button logic
        checkoutButton.addClickListener(event -> {
            // Handle checkout logic (e.g., save order, clear basket)
            basketItems.clear();
            updateTotalPrice();
            basketGrid.setItems(basketItems);
            totalPriceLabel.setText("Checkout Complete !");


        });

        // Add components to the page
        add(new Label("Basket"), basketGrid, totalPriceLabel, checkoutButton);
        setPadding(true);
        setSpacing(true);
    }

    private void updateTotalPrice() {
        double totalPrice = basketItems.stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", totalPrice));
    }

    // Inner class to represent basket items
    public static class BasketItem {
        private String sku;
        private String name;
        private String description;
        private int quantity;
        private double price;

        public BasketItem(String sku, String name, String description, int quantity, double price) {
            this.sku = sku;
            this.name = name;
            this.description = description;
            this.quantity = quantity;
            this.price = price;
        }

        public String getSku() {
            return sku;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public double getTotalPrice() {
            return quantity * price;
        }
    }
}
