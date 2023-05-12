package ru.akvine.prorisefront.components.grapichs;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

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
