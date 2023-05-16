package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Header;

@Route("profile/settings")
public class ProfileSettingsView extends VerticalLayout {
    public ProfileSettingsView() {
        add(new Header());
    }
}