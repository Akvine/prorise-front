package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.FilterBox;
import ru.akvine.prorisefront.components.Header;
import ru.akvine.prorisefront.components.grapichs.Charts;
import ru.akvine.prorisefront.components.grapichs.LinePlots;
import ru.akvine.prorisefront.services.KPIService;

@Route("/kpi")
public class KPIView extends VerticalLayout {
    private final KPIService kpiService;
    private final ComboBox<String> comboBox;

    public KPIView(KPIService kpiService) {
        add(new Header());
        this.kpiService = kpiService;
        this.comboBox = new ComboBox<>();

        Button analyzeButton = new Button("Провести анализ");

        Charts charts = new Charts();
        charts.updateChartData();
        LinePlots linePlots = new LinePlots();

        FilterBox filterBox = new FilterBox();

        add(charts, linePlots);
        add(filterBox);
        add(analyzeButton);
    }
}
