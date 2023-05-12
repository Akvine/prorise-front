package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Footer;
import ru.akvine.prorisefront.components.Header;
import ru.akvine.prorisefront.services.KPIService;

import java.math.BigDecimal;
import java.util.List;

@Route("/kpi")
public class KPIView extends VerticalLayout {
    private final KPIService kpiService;
    private final Chart diagramm;
    private final Chart lineChart;

    public KPIView(KPIService kpiService) {
        this.kpiService = kpiService;
        diagramm = createChart();
        lineChart = createLineChart();
        add(diagramm, lineChart, new Header());

        updateChartData();
        add(new Footer());
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

    private Chart createLineChart() {
        Chart chart = new Chart(ChartType.LINE);
        Configuration configuration = chart.getConfiguration();

        configuration.setTitle("Линейный график");
        configuration.setTooltip(new Tooltip());

        DataSeries dataSeries = new DataSeries();
        dataSeries.add(new DataSeriesItem(0, 5));
        dataSeries.add(new DataSeriesItem(1, 10));
        dataSeries.add(new DataSeriesItem(2, 8));
        dataSeries.add(new DataSeriesItem(3, 12));
        dataSeries.add(new DataSeriesItem(4, 6));

        configuration.addSeries(dataSeries);

        PlotOptionsLine plotOptions = new PlotOptionsLine();
        plotOptions.setEnableMouseTracking(true);
        dataSeries.setPlotOptions(plotOptions);

        return chart;
    }

    private void updateChartData() {
        List<Number> revenueData = List.of(new BigDecimal("15"), new BigDecimal("32"));
        List<Number> profitData = List.of(new BigDecimal("65"), new BigDecimal("72"));
        List<Number> customerCountData = List.of(2, 1);

        ListSeries revenueSeries = new ListSeries("Производительность", revenueData);
        diagramm.getConfiguration().addSeries(revenueSeries);

        ListSeries profitSeries = new ListSeries("Качество работы", profitData);
        diagramm.getConfiguration().addSeries(profitSeries);

        ListSeries customerCountSeries = new ListSeries("Сроки выполнения работы", customerCountData);
        diagramm.getConfiguration().addSeries(customerCountSeries);
    }
}
