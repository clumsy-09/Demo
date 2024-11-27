package com.example.demo.pages;

import com.example.demo.service.ProductService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Route("")
public class MainView extends VerticalLayout {

    private Button addProductButton = new Button("Add Product");
    private Button viewBasketButton = new Button("View Basket");

    @Autowired
    private ProductService productService;

    public MainView() {
        // Set up the page with a simple "Hello World" message
        add(new H1("Welcome to my Web!"));

        add(addProductButton);
        addProductButton.addClickListener(event -> {
            UI.getCurrent().navigate("product-form");
                });

        add(viewBasketButton);
        viewBasketButton.addClickListener(event -> {
                    UI.getCurrent().navigate("basket-view");
                });

        setAlignItems(Alignment.CENTER);
    }
}
