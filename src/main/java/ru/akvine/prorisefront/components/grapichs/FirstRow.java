package ru.akvine.prorisefront.components.grapichs;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.math.BigDecimal;
import java.util.List;

public class FirstRow extends HorizontalLayout {
    private final Chart columnChart;
    private final Chart secondChart;
    private final Chart thirdChart;

    public FirstRow() {
        columnChart = createColumnChart();
        secondChart = createAreaChart();
        thirdChart = createThirdChart();
        add(columnChart, secondChart, thirdChart);
    }

    private Chart createColumnChart() {
        Chart chart = new Chart(ChartType.COLUMN);
        Configuration conf = chart.getConfiguration();
        chart.setWidth("500px");
        chart.setHeight("500px");
        conf.setTitle("Производительность");

        XAxis xAxis = new XAxis();
        xAxis.setTitle("Время");
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Значение");
        conf.addyAxis(yAxis);

        List<Number> revenueData = List.of(new BigDecimal("15"));
        List<Number> profitData = List.of(new BigDecimal("65"));
        List<Number> customerCountData = List.of(2);

        ListSeries revenueSeries = new ListSeries("Производительность", revenueData);
        chart.getConfiguration().addSeries(revenueSeries);
        chart.getConfiguration().getChart().setColorCount(3);

        ListSeries profitSeries = new ListSeries("Качество работы", profitData);
        chart.getConfiguration().addSeries(profitSeries);
        chart.getConfiguration().getChart().setColorCount(2);

        ListSeries customerCountSeries = new ListSeries("Уровень удовлетворённости клиентов", customerCountData);
        chart.getConfiguration().addSeries(customerCountSeries);
        chart.getConfiguration().getChart().setColorCount(1);

        return chart;
    }

    private Chart createAreaChart() {
        Chart chart = new Chart(ChartType.AREA);
        Configuration configuration = chart.getConfiguration();
        chart.setWidth("500px");
        chart.setHeight("500px");

        DataSeries dataSeries = new DataSeries();
        dataSeries.add(new DataSeriesItem(1, 10));
        dataSeries.add(new DataSeriesItem(2, 20));
        dataSeries.add(new DataSeriesItem(3, 15));
        dataSeries.add(new DataSeriesItem(4, 25));

        PlotOptionsArea plotOptions = new PlotOptionsArea();
        dataSeries.setPlotOptions(plotOptions);

        configuration.setSeries(dataSeries);

        return chart;
    }

    private Chart createThirdChart() {
        Chart chart = new Chart(ChartType.BOXPLOT);
        Configuration conf = chart.getConfiguration();
        chart.setWidth("500px");
        chart.setHeight("500px");
        conf.setTitle("Уровень удовлетворённости клиентов");

        XAxis xAxis = new XAxis();
        xAxis.setTitle("Время");
        conf.addxAxis(xAxis);

        YAxis yAxis = new YAxis();
        yAxis.setTitle("Значение");
        conf.addyAxis(yAxis);

        return chart;
    }

    public void updateChartData() {
        List<Number> revenueData = List.of(new BigDecimal("15"));
        List<Number> profitData = List.of(new BigDecimal("65"));
        List<Number> customerCountData = List.of(2);

        ListSeries revenueSeries = new ListSeries("Производительность", revenueData);
        columnChart.getConfiguration().addSeries(revenueSeries);
        columnChart.getConfiguration().getChart().setColorCount(3);

        ListSeries profitSeries = new ListSeries("Качество работы", profitData);
        secondChart.getConfiguration().addSeries(profitSeries);
        secondChart.getConfiguration().getChart().setColorCount(2);

        ListSeries customerCountSeries = new ListSeries("Уровень удовлетворённости клиентов", customerCountData);
        thirdChart.getConfiguration().addSeries(customerCountSeries);
        thirdChart.getConfiguration().getChart().setColorCount(1);
    }
}
