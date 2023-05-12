package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Header;
import ru.akvine.prorisefront.views.dto.User;

@Route("profile/settings")
public class ProfileSettingsView extends VerticalLayout {

    private final User user = getCurrentUser();

    private final TextField firstNameField = new TextField("Имя");
    private final TextField lastNameField = new TextField("Фамилия");
    private final TextField emailField = new TextField("Почта");
    private final PasswordField passwordField = new PasswordField("Пароль");
    private final PasswordField confirmPasswordField = new PasswordField("Подтвердите пароль");
    private final Checkbox notificationsCheckbox = new Checkbox("Получить уведомление");

    public ProfileSettingsView() {
        add(new Header());
        FormLayout formLayout = new FormLayout();
        formLayout.addFormItem(firstNameField, "Имя");
        formLayout.addFormItem(lastNameField, "Фамилия");
        formLayout.addFormItem(lastNameField, "Отчество");
        formLayout.addFormItem(emailField, "Почта");
        formLayout.addFormItem(passwordField, "Пароль");
        formLayout.addFormItem(confirmPasswordField, "Подтвердите пароль");
        formLayout.addFormItem(notificationsCheckbox, "Получить уведомление");

        Button saveButton = new Button("Сохранить", e -> saveProfileSettings());

        add(formLayout, saveButton);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setWidth("100%");
        setHeight("100%");
        setPadding(true);
        setSpacing(true);

        // Заполнение полей значениями из базы данных или другого источника
        firstNameField.setValue(user.getFirstName());
        lastNameField.setValue(user.getLastName());
        emailField.setValue(user.getEmail());
        notificationsCheckbox.setValue(user.isReceiveNotifications());
    }

    private User getCurrentUser() {
        // Здесь необходимо получить текущего пользователя из базы данных или другого источника
        return new User("Sergei", "Lymar", "fastbrickmr@gmail.com", "03020057", false);
    }

    private void saveProfileSettings() {
        // Сохранение настроек профиля в базу данных или другой источник
        user.setFirstName(firstNameField.getValue());
        user.setLastName(lastNameField.getValue());
        user.setEmail(emailField.getValue());
        user.setPassword(passwordField.getValue());
        user.setReceiveNotifications(notificationsCheckbox.getValue());
        //...
    }
}