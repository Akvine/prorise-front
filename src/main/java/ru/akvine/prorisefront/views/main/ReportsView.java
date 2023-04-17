package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Footer;
import ru.akvine.prorisefront.components.Header;

import java.time.LocalDate;

@Route("/reports")
public class ReportsView extends HorizontalLayout {
    public ReportsView() {
        add(new Header());
        // Создаем вертикальный лейаут для страницы отчетности
        VerticalLayout reportLayout = new VerticalLayout();
        reportLayout.setWidthFull();

// Создаем горизонтальный лейаут для фильтров
        HorizontalLayout filterLayout = new HorizontalLayout();
        filterLayout.setWidthFull();
        filterLayout.getStyle().set("padding", "20px");

// Создаем выпадающий список для выбора департамента
        ComboBox<String> departmentComboBox = new ComboBox<>("Департамент");
        departmentComboBox.setItems("Департамент 1", "Департамент 2", "Департамент 3");
        departmentComboBox.setWidth("200px");

// Создаем выпадающий список для выбора должности
        ComboBox<String> positionComboBox = new ComboBox<>("Должность");
        positionComboBox.setItems("Должность 1", "Должность 2", "Должность 3");
        positionComboBox.setWidth("200px");

// Создаем выпадающий список для выбора проекта
        ComboBox<String> projectComboBox = new ComboBox<>("Проект");
        projectComboBox.setItems("Проект 1", "Проект 2", "Проект 3");
        projectComboBox.setWidth("200px");

// Создаем компонент выбора периода времени
        DatePicker fromDate = new DatePicker("Начальная дата");
        DatePicker toDate = new DatePicker("Конечная дата");
        toDate.setValue(LocalDate.now()); // устанавливаем текущую дату по умолчанию
        toDate.setClearButtonVisible(true);

// Создаем кнопку для генерации отчета
        Button generateButton = new Button("Сгенерировать отчет");
        generateButton.addClickListener(e -> {
            // Код для генерации отчета
        });

// Добавляем компоненты фильтров на страницу
        filterLayout.add(departmentComboBox, positionComboBox, projectComboBox, fromDate, toDate, generateButton);

// Создаем таблицу для отображения данных о продуктивности сотрудников
//        Grid<EmployeePerformance> performanceGrid = new Grid<>(EmployeePerformance.class);
//        performanceGrid.setColumns("employeeName", "department", "position", "project", "performance");
//        performanceGrid.getColumnByKey("employeeName").setHeader("Сотрудник");
//        performanceGrid.getColumnByKey("department").setHeader("Департамент");
//        performanceGrid.getColumnByKey("position").setHeader("Должность");
//        performanceGrid.getColumnByKey("project").setHeader("Проект");
//        performanceGrid.getColumnByKey("performance").setHeader("Продуктивность");
//
//// Получаем данные о продуктивности сотрудников и добавляем их в таблицу
//        List<EmployeePerformance> employeePerformanceList = getEmployeePerformanceList();
//        performanceGrid.setItems(employeePerformanceList);

// Добавляем компоненты на страницу отчетности
//        reportLayout.add(filterLayout, performanceGrid);
        reportLayout.add(filterLayout);
        add(reportLayout, new Footer());
    }
}
