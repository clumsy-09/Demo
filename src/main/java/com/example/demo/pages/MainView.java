package com.example.demo.pages;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

@Component
@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        // Set up the page with a simple "Hello World" message
        add(new H1("Hello, World!"));
        setAlignItems(Alignment.CENTER);
    }
}
