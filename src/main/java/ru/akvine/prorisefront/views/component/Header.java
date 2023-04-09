package ru.akvine.prorisefront.views.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

@CssImport(value= "./styles/header.css", themeFor="vaadin-app-layout")
public class Header extends AppLayout {
    private AppLayout appLayout;
//    public Header() {
//        setWidthFull();
//        setHeight("100px");
//        setPadding(true);
//        setSpacing(true);
//        setAlignItems(Alignment.CENTER);
//
//        Image logo = new Image("https://via.placeholder.com/150", "Logo");
//        logo.setHeight("50px");
//        add(logo);
//
//        Tabs tabs = new Tabs();
//        tabs.add(new Tab("Главная"));
//        tabs.add(new Tab("О нас"));
//        tabs.add(new Tab("Контакты"));
//        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
//        tabs.addSelectedChangeListener(event -> {
//            Tab selectedTab = tabs.getSelectedTab();
//            String tabName = selectedTab.getLabel();
//            Notification.show("Переход на страницу: " + tabName);
//        });
//        add(tabs);
//
//        Button loginButton = new Button("Выйти");
//        add(loginButton);
//    }

//    public Header() {
//        Image logo = new Image("logo.png", "MyApp logo");
//        logo.setHeight("50px");
//        appLayout = new AppLayout();
//
//        // кнопка меню для адаптивного дизайна
////        Button menuButton = new Button(VaadinIcon.MENU.create(), e -> UI.getCurrent().setCon);
//        Button menuButton = new Button(VaadinIcon.MENU.create());
//        menuButton.addClassName("menu-button");
//
//        // ссылки меню
//        Tabs menu = new Tabs();
//        menu.setOrientation(Tabs.Orientation.HORIZONTAL);
//        menu.add(getMenuLink("Главная", "home"), getMenuLink("О нас", "about"), getMenuLink("Контакты", "contacts"));
//
//        // размещение компонентов в хедере
//        HorizontalLayout header = new HorizontalLayout();
//        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
//        header.setWidth("100%");
//        header.add(logo, menuButton, menu);
//        header.expand(menu);
//        addToNavbar(header);
//    }
//
//    private Tab getMenuLink(String text, String route) {
//        RouterLink link = new RouterLink("View", View.class);
//        RouterLink link2 = new RouterLink("View2", View2.class);
//        Tab tab = new Tab(link, link2);
//        tab.addClassName("menu-link");
//        return tab;
//    }

        public Header() {
            setContent(buildHeader());
        }

        public Component buildHeader() {
            Image logo = new Image("https://via.placeholder.com/150x50?text=Logo", "Logo");

            // Список ссылок на страницы
            RouterLink page1Link = new RouterLink("Page 1", View.class);
            RouterLink page2Link = new RouterLink("Page 2", View2.class);

            // Кнопка "Sign In"
            Button signInButton = new Button("Sign In");
            signInButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

            // Расположение элементов в header
            HorizontalLayout headerContent = new HorizontalLayout(logo, page1Link, page2Link, signInButton);
            headerContent.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
            headerContent.setWidthFull();

            // Конфигурация AppLayout
            AppLayout appLayout = new AppLayout();
            appLayout.setPrimarySection(AppLayout.Section.NAVBAR);
            appLayout.addToNavbar(headerContent);

            return appLayout;
        }

    // для адаптивного дизайна
//    private void toggleDrawer() {
//        AppLayout appLayout = (AppLayout) UI.getCurrent().get();
//        appLayout.setDrawerOpened(!appLayout.isDrawerOpened());
//    }
}
