package ru.akvine.prorisefront.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import ru.akvine.prorisefront.views.main.TasksView;
import ru.akvine.prorisefront.views.main.ProfileSettingsView;
import ru.akvine.prorisefront.views.main.ReportsView;
import ru.akvine.prorisefront.views.main.TimeTrackerView;

@CssImport(value = "./styles/header.css", themeFor = "vaadin-app-layout")
public class Header extends AppLayout {
    public Header() {
        setContent(buildHeader());
    }

    public Component buildHeader() {
        Image logo = new Image("https://via.placeholder.com/150x50?text=Logo", "Logo");

        // Список ссылок на страницы
        RouterLink page1Link = new RouterLink("Генерация отчетов", ReportsView.class);
        RouterLink page2Link = new RouterLink("Задачи", TasksView.class);
        RouterLink page3Link = new RouterLink("Учет времени", TimeTrackerView.class);
        RouterLink page4Link = new RouterLink("Настройки профиля", ProfileSettingsView.class);

        // Кнопка "Sign In"
        Button signInButton = new Button("Войти");
        signInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // Расположение элементов в header
        HorizontalLayout headerContent = new HorizontalLayout(logo, page1Link, page2Link, page3Link, page4Link, signInButton);
        headerContent.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        headerContent.setWidthFull();

        // Конфигурация AppLayout
        AppLayout appLayout = new AppLayout();
        appLayout.setPrimarySection(AppLayout.Section.NAVBAR);
        appLayout.addToNavbar(headerContent);

        return appLayout;
    }
}
