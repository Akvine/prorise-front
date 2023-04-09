package ru.akvine.prorisefront.views.component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Top;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

@CssImport(value= "./styles/footer.css", themeFor="vaadin-app-layout")
public class Footer extends HorizontalLayout {
    public Footer() {
        setPadding(true);
        setSpacing(true);
        setWidthFull();
        setHeight("100px");
//        setMargin(Top.BOTTOM, "0");
        setAlignItems(Alignment.CENTER);

        // Создаем компоненты, которые будут отображаться в footer'е
        Span text = new Span("All rights reserved © 2023");
        Button contactUsButton = new Button("Contact Us");

        // Стилизуем компоненты
        text.getStyle().set("font-size", "14px")
                .set("font-weight", "bold")
                .set("color", "white");

        contactUsButton.getStyle().set("background-color", "#5B5B5B")
                .set("color", "white")
                .set("font-size", "14px")
                .set("font-weight", "bold")
                .set("padding", "12px 20px")
                .set("border-radius", "30px")
                .set("cursor", "pointer");

        // Добавляем компоненты в footer
        add(text, contactUsButton);

        // Устанавливаем выравнивание компонентов в footer
        setJustifyContentMode(JustifyContentMode.CENTER);
        setVerticalComponentAlignment(Alignment.CENTER, text, contactUsButton);
    }
}
