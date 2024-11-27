package com.example.demo.pages;


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("product-form")
public class ProductFormView extends FormLayout {

    private TextField skuField = new TextField("SKU");
    private TextField nameField = new TextField("Name");
    private TextField descriptionField = new TextField("Description");

    private Button saveButton = new Button("Save");
    private Button clearButton = new Button("Clear");

    @Autowired
    private ProductService productService;

    public ProductFormView() {
        // Create a header
        Label header = new Label("Product Input Form");
        header.getStyle().set("font-size", "20px").set("font-weight", "bold");

        // Add fields to the form
        add(header, skuField, nameField, descriptionField, saveButton, clearButton);

        // Save button logic
        saveButton.addClickListener(event -> {
            Product product = new Product();
            product.setSku(skuField.getValue());
            product.setName(nameField.getValue());
            product.setDescription(descriptionField.getValue());

            Product savedProduct = productService.save(product);
            if(savedProduct != null) {
                Notification.show("Product Saved: " + product.getName());
            } else {
                Notification.show("Product not saved");
            }
        });
        // clear Form
        clearButton.addClickListener(event -> {
            skuField.setValue("");
            nameField.setValue("");
            descriptionField.setValue("");
        });

        // Set form layout styles
        setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("500px", 2)
        );
        setColspan(skuField, 2);
        setColspan(nameField, 2);
        setColspan(descriptionField, 2);
    }
}


