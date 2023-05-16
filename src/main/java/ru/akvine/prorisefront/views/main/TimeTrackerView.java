package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Header;
import ru.akvine.prorisefront.services.dto.EmployeeWithTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Route("time-tracker")
public class TimeTrackerView extends VerticalLayout {
    private Grid<EmployeeWithTime> employeeGrid;
    private List<EmployeeWithTime> employees;
    private DatePicker datePicker;

    public TimeTrackerView() {
        add(new Header());
        employees = createEmployeeData();

        // Создание компонента выбора даты
        datePicker = new DatePicker("Выберите дату");
        datePicker.addValueChangeListener(e -> showEmployeesByDate(e.getValue()));

        // Создание компонента списка сотрудников
        employeeGrid = new Grid<>(EmployeeWithTime.class);
        employeeGrid.setColumns("firstName", "lastName", "arrivalTime", "departureTime");
        employeeGrid.setItems(employees);

        // Добавление компонентов на страницу
        add(datePicker, employeeGrid);
    }

    private List<EmployeeWithTime> createEmployeeData() {
        // Здесь вы можете добавить вашу логику для получения данных о сотрудниках из базы данных или другого источника
        List<EmployeeWithTime> employees = new ArrayList<>();
        employees.add(new EmployeeWithTime("Иван", "Петров", LocalDateTime.of(2023, 5, 17, 9, 0), LocalDateTime.of(2023, 5, 17, 18, 0)));
        employees.add(new EmployeeWithTime("Анна", "Иванова", LocalDateTime.of(2023, 5, 17, 8, 30), LocalDateTime.of(2023, 5, 17, 17, 30)));
        employees.add(new EmployeeWithTime("Петр", "Сидоров", LocalDateTime.of(2023, 5, 17, 9, 15), LocalDateTime.of(2023, 5, 17, 18, 15)));
        return employees;
    }

    private void showEmployeesByDate(LocalDate date) {
        List<EmployeeWithTime> filteredEmployees = employees.stream()
                .filter(employee -> employee.getArrivalTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
        employeeGrid.setItems(filteredEmployees);
    }

}