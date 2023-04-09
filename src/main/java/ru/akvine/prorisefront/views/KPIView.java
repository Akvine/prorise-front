package ru.akvine.prorisefront.views;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.services.KPIService;
import ru.akvine.prorisefront.views.component.Footer;
import ru.akvine.prorisefront.views.component.Header;

import java.math.BigDecimal;
import java.util.List;

@Route("/kpi")
public class KPIView extends VerticalLayout {
    private final KPIService kpiService;
    private final Chart chart;

    public KPIView(KPIService kpiService) {
        this.kpiService = kpiService;
        Header header = new Header();
        add(header);
        chart = createChart();
        add(chart);

        Footer footer = new Footer();
        add(footer);
        updateChartData();
    }

    private Chart createChart() {
        Chart chart = new Chart(ChartType.COLUMN);
        Configuration conf = chart.getConfiguration();
        chart.setWidth("500px");
        chart.setHeight("500px");
        conf.setTitle("KPI Chart");

        XAxis xAxis = new XAxis();
        xAxis.setTitle("Time");
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Value");
        conf.addyAxis(yAxis);

        return chart;
    }

    private void updateChartData() {
        List<Number> revenueData = List.of(new BigDecimal("15"), new BigDecimal("32"));
        List<Number> profitData = List.of(new BigDecimal("65"), new BigDecimal("72"));
        List<Number> customerCountData = List.of(2, 1);

        ListSeries revenueSeries = new ListSeries("Revenue", revenueData);
        chart.getConfiguration().addSeries(revenueSeries);

        ListSeries profitSeries = new ListSeries("Profit", profitData);
        chart.getConfiguration().addSeries(profitSeries);

        ListSeries customerCountSeries = new ListSeries("Customer Count", customerCountData);
        chart.getConfiguration().addSeries(customerCountSeries);
    }
}
