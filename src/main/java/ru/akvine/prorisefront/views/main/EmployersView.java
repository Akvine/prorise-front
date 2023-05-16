package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Header;
import ru.akvine.prorisefront.services.dto.Employee;
import ru.akvine.prorisefront.services.dto.Task;

import java.util.ArrayList;
import java.util.List;

@Route("/employers")
public class EmployersView extends VerticalLayout {
    private Grid<Employee> employeeGrid;
    private Grid<Task> taskGrid;
    private TextField filterField;

    private List<Employee> employees;

    public EmployersView() {
        add(new Header());
        employees = createEmployeeData();

        // Создание компонента фильтрации
        filterField = new TextField("Фильтр");
        filterField.addValueChangeListener(e -> filterEmployees(e.getValue()));

        // Создание компонента списка сотрудников
        employeeGrid = new Grid<>(Employee.class);
        employeeGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        employeeGrid.setColumns("id", "name", "project", "team", "department");
        employeeGrid.setItems(employees);
        employeeGrid.asSingleSelect().addValueChangeListener(e -> showTasksForEmployee(e.getValue()));

        // Создание компонента списка задач
        taskGrid = new Grid<>(Task.class);
        taskGrid.setColumns("id", "name", "status");

        // Добавление компонентов на страницу
        add(filterField, employeeGrid, taskGrid);
    }

    private List<Employee> createEmployeeData() {
        // Здесь вы можете добавить вашу логику для получения данных о сотрудниках из базы данных или другого источника
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Иван", "Проект 1", "Команда 1", "Департамент 1"));
        employees.add(new Employee(2, "Петр", "Проект 2", "Команда 2", "Департамент 1"));
        employees.add(new Employee(3, "Мария", "Проект 1", "Команда 1", "Департамент 2"));
        employees.add(new Employee(4, "Анна", "Проект 3", "Команда 3", "Департамент 2"));
        return employees;
    }

    private List<Task> getTasksForEmployee(Employee employee) {
        // Здесь вы можете добавить вашу логику для получения задач, связанных с данным сотрудником
        // Например, обращение к базе данных или другому источнику данных
        List<Task> tasks = new ArrayList<>();
        // В предположении, что в объекте Employee есть идентификатор сотрудника,
        // можно получить задачи, связанные с этим сотрудником или другими параметрами
        // tasks = yourTaskService.getTasksByEmployee(employee.getId());
        if (employee.getId() == 1) {
            tasks = new ArrayList<>();
            tasks.add(new Task(1, "Задача 1", "В процессе"));
            tasks.add(new Task(2, "Задача 2", "Завершена"));
        } else {
            tasks = new ArrayList<>();
            tasks.add(new Task(3, "Задача 3", "В процессе"));
            tasks.add(new Task(4, "Задача 4", "Отложена"));
        }
        return tasks;
    }

    private void filterEmployees(String filterText) {
        ListDataProvider<Employee> dataProvider = new ListDataProvider<>(employees);
        dataProvider.setFilter(employee -> employee.getName().toLowerCase().contains(filterText.toLowerCase()));
        employeeGrid.setDataProvider(dataProvider);
    }

    private void showTasksForEmployee(Employee employee) {
        if (employee != null) {
            List<Task> tasks = getTasksForEmployee(employee);
            taskGrid.setItems(tasks);
        } else {
            taskGrid.setItems();
        }
    }
}
