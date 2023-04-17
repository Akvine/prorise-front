package ru.akvine.prorisefront.components;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Page;

@CssImport(value= "./styles/footer.css", themeFor="vaadin-app-layout")
public class Footer extends HorizontalLayout {
    public Footer() {
        // ... добавляем содержимое страницы ...

        // создаем футер
        HorizontalLayout footer = new HorizontalLayout();
        footer.getStyle().set("background-color", "#333333"); // установка темного фона
        footer.setPadding(true);
        footer.setSpacing(true);
        footer.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        // добавляем ссылки на социальные сети
        Icon facebookIcon = new Icon(VaadinIcon.FACEBOOK);
        Icon twitterIcon = new Icon(VaadinIcon.TWITTER);
        facebookIcon.getStyle().set("cursor", "pointer");
        facebookIcon.getStyle().set("color", "#333333");
        twitterIcon.getStyle().set("cursor", "pointer");
        twitterIcon.getStyle().set("color", "#333333");

        Div facebookContainer = new Div(facebookIcon);
        Div twitterContainer = new Div(twitterIcon);
        facebookContainer.getStyle().set("background-color", "#ffffff");
        facebookContainer.getStyle().set("border-radius", "50%");
        facebookContainer.setWidth("42px");
        facebookContainer.setHeight("42px");
        twitterContainer.getStyle().set("background-color", "#ffffff");
        twitterContainer.getStyle().set("border-radius", "50%");
        twitterContainer.setWidth("42px");
        twitterContainer.setHeight("42px");


        footer.add(facebookContainer, twitterContainer);

        // добавляем контакты
        Label emailLabel = new Label("support@example.com");
        emailLabel.getStyle().set("cursor", "pointer");
        emailLabel.getStyle().set("color", "#ffffff");
        emailLabel.addAttachListener(event -> {
            // открываем почтовый клиент по умолчанию для отправки письма на указанный адрес электронной почты
            Page page = new Page(getUI().get());
            page.executeJs("window.location.href = 'mailto:support@example.com'");
        });
        Label phoneLabel = new Label("+1 (123) 456-7890");
        phoneLabel.getStyle().set("cursor", "pointer");
        phoneLabel.getStyle().set("color", "#ffffff");
        phoneLabel.addAttachListener(event -> {
            // открываем приложение телефона по умолчанию для набора указанного номера телефона
            Page page = new Page(getUI().get());
            page.executeJs("window.location.href = 'tel:+11234567890'");
        });
        footer.add(emailLabel, phoneLabel);

        // добавляем ссылку на пользовательское соглашение
        Anchor termsAnchor = new Anchor("/terms", "Условия использования");
        termsAnchor.getStyle().set("cursor", "pointer");
        termsAnchor.getStyle().set("color", "#ffffff");
        termsAnchor.setTarget("_blank");
        footer.add(termsAnchor);

        add(footer);
    }
}
