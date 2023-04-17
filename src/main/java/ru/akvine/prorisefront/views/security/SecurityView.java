package ru.akvine.prorisefront.views.security;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/security")
public class SecurityView extends VerticalLayout {

    private boolean isRegistration = false;

    private TextField usernameField = new TextField("Username");
    private PasswordField passwordField = new PasswordField("Password");
    private TextField emailField = new TextField("Email");
    private TextField fullNameField = new TextField("Full Name");

    public SecurityView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H1 title = new H1("Welcome to My App");

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        loginButton.addClickListener(e -> {
            if (isRegistration) {
                isRegistration = false;
                registerButton.removeClassName("active");
                loginButton.addClassName("active");
                removeAll();
                add(title, usernameField, passwordField);
            }
        });

        registerButton.addClickListener(e -> {
            if (!isRegistration) {
                isRegistration = true;
                loginButton.removeClassName("active");
                registerButton.addClassName("active");
                removeAll();
                add(title, usernameField, passwordField, emailField, fullNameField);
            }
        });

        HorizontalLayout buttonLayout = new HorizontalLayout(loginButton, registerButton);
        buttonLayout.setSpacing(true);
        loginButton.addClassName("active");

        add(title, usernameField, passwordField, buttonLayout);

    }

}
