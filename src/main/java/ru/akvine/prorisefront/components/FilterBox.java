package ru.akvine.prorisefront.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class FilterBox extends HorizontalLayout {
    private final ComboBox<String> comboBox;

    public FilterBox() {
        this.comboBox = new ComboBox<>();
        comboBox.setLabel("Выберите один из вариантов:");
        comboBox.setItems("Сотрудник", "Проект", "Команда", "Департамент");
        comboBox.addValueChangeListener(event -> {
            String selectedOption = event.getValue();
            Notification.show("Выбран вариант: " + selectedOption);
        });
        TextField textField = new TextField();
        textField.setLabel("Имя/Название");

        DatePicker startDatePicker = new DatePicker();
        startDatePicker.setLabel("Начальная дата");

        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setLabel("Конечная дата");

        Button analyzeButton = new Button("Провести анализ");

        Button button = new Button("Применить фильтр");
        button.addClickListener(event -> {
            Notification.show("Фильтр: " + textField.getValue() + " " + startDatePicker.getValue() + " " + endDatePicker.getValue());
        });
        add(comboBox, textField, startDatePicker, endDatePicker, button, analyzeButton);
    }
}
