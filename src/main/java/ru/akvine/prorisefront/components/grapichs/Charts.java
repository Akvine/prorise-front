package ru.akvine.prorisefront.components.grapichs;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.charts.model.style.Color;
import com.vaadin.flow.component.charts.model.style.GradientColor;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.math.BigDecimal;
import java.util.List;

public class Charts extends HorizontalLayout {
    private final Chart firstChart;
    private final Chart secondChart;
    private final Chart thirdChart;

    public Charts() {
        firstChart = createFirstChart();
        secondChart = createSecondChart();
        thirdChart = createThirdChart();
        add(firstChart, secondChart, thirdChart);
    }

    private Chart createFirstChart() {
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

        return chart;
    }

    private Chart createSecondChart() {
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
        firstChart.getConfiguration().addSeries(revenueSeries);
        firstChart.getConfiguration().getChart().setColorCount(3);

        ListSeries profitSeries = new ListSeries("Качество работы", profitData);
        secondChart.getConfiguration().addSeries(profitSeries);
        secondChart.getConfiguration().getChart().setColorCount(2);

        ListSeries customerCountSeries = new ListSeries("Уровень удовлетворённости клиентов", customerCountData);
        thirdChart.getConfiguration().addSeries(customerCountSeries);
        thirdChart.getConfiguration().getChart().setColorCount(1);
    }
}
