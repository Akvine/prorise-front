package ru.akvine.prorisefront.components.grapichs;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.List;

public class SecondRow extends HorizontalLayout {
    public SecondRow() {
        Chart firstPlot = createFirstPlot();
        Chart secondPlot = createSecondPlot();
        Chart thirdPlot = createThirdPlot();
        add(firstPlot, secondPlot, thirdPlot);
    }

    private Chart createFirstPlot() {
        Chart chart = new Chart(ChartType.LINE);
        Configuration configuration = chart.getConfiguration();
        chart.setWidth("500px");
        chart.setHeight("500px");

        XAxis xAxis = new XAxis();
        xAxis.setTitle("Время");
        configuration.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Значение");
        configuration.addyAxis(yAxis);

        configuration.setTooltip(new Tooltip());

        List<Number> revenueData = List.of(1, 2, 4);
        List<Number> profitData = List.of(9, 1, 18);
        List<Number> customerCountData = List.of(4, 1, 4);

        ListSeries revenueSeries = new ListSeries("Производительность", revenueData);
        chart.getConfiguration().addSeries(revenueSeries);
        chart.getConfiguration().getChart().setColorCount(3);

        ListSeries profitSeries = new ListSeries("Качество работы", profitData);
        chart.getConfiguration().addSeries(profitSeries);
        chart.getConfiguration().getChart().setColorCount(2);

        ListSeries customerCountSeries = new ListSeries("Уровень удовлетворённости клиентов", customerCountData);
        chart.getConfiguration().addSeries(customerCountSeries);
        chart.getConfiguration().getChart().setColorCount(1);


        PlotOptionsLine plotOptions = new PlotOptionsLine();
        plotOptions.setEnableMouseTracking(true);

        revenueSeries.setPlotOptions(plotOptions);
        profitSeries.setPlotOptions(plotOptions);
        customerCountSeries.setPlotOptions(plotOptions);

        return chart;
    }

    private Chart createSecondPlot() {
        Chart chart = new Chart(ChartType.BUBBLE);
        Configuration configuration = chart.getConfiguration();
        chart.setWidth("500px");
        chart.setHeight("500px");

        DataSeries dataSeries = new DataSeries();
        dataSeries.add(new DataSeriesItem(1, 1, 10));
        dataSeries.add(new DataSeriesItem(2, 2, 20));
        dataSeries.add(new DataSeriesItem(3, 3, 30));

        PlotOptionsBubble plotOptions = new PlotOptionsBubble();
        plotOptions.setMinSize("10");
        plotOptions.setMaxSize("30");

        dataSeries.setPlotOptions(plotOptions);

        configuration.setSeries(dataSeries);

        return chart;
    }

    private Chart createThirdPlot() {
        Chart chart = new Chart(ChartType.HEATMAP);
        Configuration configuration = chart.getConfiguration();
        chart.setWidth("500px");
        chart.setHeight("500px");

        DataSeries dataSeries = new DataSeries();
        dataSeries.add(new DataSeriesItem(0, 0, 10));
        dataSeries.add(new DataSeriesItem(0, 1, 20));
        dataSeries.add(new DataSeriesItem(1, 0, 30));
        dataSeries.add(new DataSeriesItem(1, 1, 40));

        PlotOptionsHeatmap plotOptions = new PlotOptionsHeatmap();
        plotOptions.setColsize(0.5);
        plotOptions.setRowsize(0.5);

        dataSeries.setPlotOptions(plotOptions);

        configuration.setSeries(dataSeries);

        return chart;
    }
}
