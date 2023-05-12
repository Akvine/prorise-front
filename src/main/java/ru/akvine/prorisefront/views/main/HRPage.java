package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Header;

import java.time.LocalDate;

@Route("/hr")
public class HRPage extends VerticalLayout {

    public HRPage() {
        add(new Header());
        TextField nameField = new TextField("Ваше имя");
        TextArea messageArea = new TextArea("Какая у вас проблема?");
        Button submitButton = new Button("Отправить");

        submitButton.addClickListener(event -> {
            String name = nameField.getValue();
            String message = messageArea.getValue();

            // отправка запроса в кадровую службу
            // ...

            Notification.show("Запрос отправлен");
        });

        add(nameField, messageArea, submitButton);

        // добавляем форму для запрашивания отпуска
        add(new VacationRequestForm());
    }

    private static class VacationRequestForm extends FormLayout {
        private final ComboBox<String> vacationTypeSelect = new ComboBox<>("Тип отпуска");
        private final DatePicker startDateField = new DatePicker ("Дата начала");
        private final DatePicker  endDateField = new DatePicker ("Дата окончания");
        private final TextArea messageArea = new TextArea("Пояснения");
        private final Button submitButton = new Button("Отправить запрос");

        public VacationRequestForm() {
            vacationTypeSelect.setItems("Ежегодный отпуск", "Больничный");
            add(vacationTypeSelect, startDateField, endDateField, messageArea, submitButton);

            submitButton.addClickListener(event -> {
                String vacationType = vacationTypeSelect.getValue();
                LocalDate startDate = startDateField.getValue();
                LocalDate endDate = endDateField.getValue();
                String message = messageArea.getValue();

                // отправка запроса на отпуск
                // ...

                Notification.show("Запрос на отпуск отправлен");
            });
        }
    }
}
