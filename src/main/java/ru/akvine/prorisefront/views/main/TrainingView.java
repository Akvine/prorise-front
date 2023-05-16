package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Header;

@Route("/training")
public class TrainingView extends FlexLayout {
    public TrainingView() {
        add(new Header());
        H1 header = new H1("На данный момент в разработке :(");
        header.getStyle().set("color", "gray");
        header.getStyle().set("font-size", "4em");
        header.getStyle().set("text-align", "center");

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        add(header);
    }
}
