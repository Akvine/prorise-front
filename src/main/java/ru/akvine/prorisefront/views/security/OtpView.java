package ru.akvine.prorisefront.views.security;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("otp")
public class OtpView extends VerticalLayout {

    private TextField[] otpFields = new TextField[4];
    private int currentFieldIndex = 0;

    public OtpView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H1 title = new H1("Enter your OTP");

        for (int i = 0; i < 4; i++) {
            otpFields[i] = new TextField();
            otpFields[i].setMaxLength(1);
            otpFields[i].setWidth("50px");
            otpFields[i].setHeight("50px");
            otpFields[i].setPattern("[0-9]");
            otpFields[i].setPreventInvalidInput(true);
            otpFields[i].addValueChangeListener(e -> {
                if (e.getValue().length() > 0) {
                    currentFieldIndex++;
                    if (currentFieldIndex < 4) {
                        otpFields[currentFieldIndex].focus();
                    } else {
                        String otp = "";
                        for (int j = 0; j < 4; j++) {
                            otp += otpFields[j].getValue();
                        }
                        Notification.show("Your OTP is: " + otp);
                    }
                }
            });
        }

        HorizontalLayout otpLayout = new HorizontalLayout(otpFields);
        otpLayout.setSpacing(true);
        otpLayout.setAlignItems(Alignment.CENTER);

        add(title, otpLayout);
    }

}