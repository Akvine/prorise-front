package ru.akvine.prorisefront.views.component;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;

import java.util.List;

public class AppLayoutBasic extends AppLayout {

    private static final List<String> TAB_NAMES = List.of("Developers", "List");

    public AppLayoutBasic() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Prorise");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)")
                .set("margin", "0");

        Tabs tabs = new Tabs();
        for (String tabName : TAB_NAMES) {
            tabs.add(new RouterLink());
        }

        addToDrawer(tabs);
        addToNavbar(toggle, title);
        setPrimarySection(AppLayout.Section.NAVBAR);
    }
}