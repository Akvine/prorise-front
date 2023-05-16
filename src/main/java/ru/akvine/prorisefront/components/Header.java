package ru.akvine.prorisefront.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;
import ru.akvine.prorisefront.views.main.*;
import ru.akvine.prorisefront.views.security.SecurityView;

@CssImport(value = "./styles/header.css", themeFor = "vaadin-app-layout")
public class Header extends AppLayout {
    public Header() {
        setContent(buildHeader());
    }

    public Component buildHeader() {
        Image logo = new Image("https://via.placeholder.com/150x50?text=Prorise", "Prorise");

        RouterLink kpiViewLink = new RouterLink("Показатели", KPIView.class);
        RouterLink employersViewLink = new RouterLink("Сотрудники", EmployersView.class);
        RouterLink hrPageViewLink = new RouterLink("Служба обратной связи", HRPage.class);
        RouterLink timeTrackerViewLink = new RouterLink("Учет времени", TimeTrackerView.class);
        RouterLink reportsViewLink = new RouterLink("Генерация отчетов", ReportsView.class);
        RouterLink trainingViewLink = new RouterLink("Обучение и достижения", TrainingView.class);
        RouterLink profileSettingsView = new RouterLink("Настройки профиля", ProfileSettingsView.class);

        Button signInButton = new Button("Выйти");
        signInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        signInButton.addClickListener(buttonClickEvent -> {
            RouterLink link = new RouterLink("", SecurityView.class);
            UI.getCurrent().getPage().executeJs("window.open($0)", link.getHref());
        });

        HorizontalLayout headerContent = new HorizontalLayout(logo,
                kpiViewLink,
                employersViewLink,
                reportsViewLink,
                hrPageViewLink,
                trainingViewLink,
                timeTrackerViewLink,
                profileSettingsView,
                signInButton
        );
        headerContent.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        headerContent.setWidthFull();

        AppLayout appLayout = new AppLayout();
        appLayout.setPrimarySection(AppLayout.Section.NAVBAR);
        appLayout.addToNavbar(headerContent);

        return appLayout;
    }
}
