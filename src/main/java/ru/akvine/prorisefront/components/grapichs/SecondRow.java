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

        List<Number> revenueData = List.of(49, 74, 44);
        List<Number> profitData = List.of(52, 48, 62);
        List<Number> customerCountData = List.of(19, 4, 2);

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
        Chart chart = new Chart(ChartType.WATERFALL);
        Configuration configuration = chart.getConfiguration();
        chart.setWidth("500px");
        chart.setHeight("500px");

        XAxis xAxis = new XAxis();
        xAxis.setTitle("Время");
        configuration.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Значение");
        configuration.addyAxis(yAxis);

        List<Number> revenueData = List.of(49, 74, 44);
        List<Number> profitData = List.of(52, 48, 62);
        List<Number> customerCountData = List.of(19, 4, 2);

        ListSeries revenueSeries = new ListSeries("Производительность", revenueData);
        chart.getConfiguration().addSeries(revenueSeries);
        chart.getConfiguration().getChart().setColorCount(3);

        ListSeries profitSeries = new ListSeries("Качество работы", profitData);
        chart.getConfiguration().addSeries(profitSeries);
        chart.getConfiguration().getChart().setColorCount(2);

        ListSeries customerCountSeries = new ListSeries("Уровень удовлетворённости клиентов", customerCountData);
        chart.getConfiguration().addSeries(customerCountSeries);
        chart.getConfiguration().getChart().setColorCount(1);

        PlotOptionsWaterfall plotOptions = new PlotOptionsWaterfall();

        revenueSeries.setPlotOptions(plotOptions);
        profitSeries.setPlotOptions(plotOptions);
        customerCountSeries.setPlotOptions(plotOptions);

        return chart;
    }

    private Chart createThirdPlot() {
        Chart chart = new Chart(ChartType.PIE);
        Configuration configuration = chart.getConfiguration();
        DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Производительность", 35));
        series.add(new DataSeriesItem("Качество работы", 20));
        series.add(new DataSeriesItem("Уровень удовлетворенности клиентов", 45));

        XAxis xAxis = new XAxis();
        xAxis.setTitle("Время");
        configuration.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Значение");
        configuration.addyAxis(yAxis);

        chart.setWidth("500px");
        chart.setHeight("500px");

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setInnerSize("50%");
        series.setPlotOptions(plotOptions);

        chart.getConfiguration().addSeries(series);

        return chart;
    }
}
