package ru.akvine.prorisefront.views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/")
public class HelloWorld extends VerticalLayout {
    public HelloWorld() {
        Label label = new Label("Hello World!");
        add(label);
    }
}
