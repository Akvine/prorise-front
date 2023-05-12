package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.FilterBox;
import ru.akvine.prorisefront.components.Header;
import ru.akvine.prorisefront.components.grapichs.FirstRow;
import ru.akvine.prorisefront.components.grapichs.SecondRow;
import ru.akvine.prorisefront.services.KPIService;

@Route("/kpi")
public class KPIView extends VerticalLayout {
    private final KPIService kpiService;
    private final ComboBox<String> comboBox;

    public KPIView(KPIService kpiService) {
        add(new Header());
        this.kpiService = kpiService;
        this.comboBox = new ComboBox<>();

        FirstRow firstRow = new FirstRow();
        SecondRow secondRow = new SecondRow();

        FilterBox filterBox = new FilterBox();

        add(firstRow, secondRow);
        add(filterBox);
    }
}
