package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Header;
import ru.akvine.prorisefront.views.dto.Department;
import ru.akvine.prorisefront.views.dto.Employee;
import ru.akvine.prorisefront.views.dto.Project;
import ru.akvine.prorisefront.views.dto.Team;

import java.util.Arrays;
import java.util.List;

@Route("comparison")
public class ComparisonView extends Div {

    public ComparisonView() {
        add(new Header());
        // Создание компонентов
        Grid<Department> departmentGrid = createDepartmentGrid();
        Grid<Team> teamGrid = createTeamGrid();
        Grid<Project> projectGrid = createProjectGrid();
        Grid<Employee> employeeGrid = createEmployeeGrid();

        // Создание макета страницы
        VerticalLayout layout = new VerticalLayout();
        layout.add(departmentGrid, teamGrid, projectGrid, employeeGrid);

        // Добавление макета на страницу
        add(layout);
    }

    private Grid<Department> createDepartmentGrid() {
        Grid<Department> grid = new Grid<>(Department.class);
        grid.setItems(getDepartments());
        grid.setColumns("name", "totalEmployees", "averagePerformance");

        return grid;
    }

    private Grid<Team> createTeamGrid() {
        Grid<Team> grid = new Grid<>(Team.class);
        grid.setItems(getTeams());
        grid.setColumns("name", "department", "totalMembers", "averagePerformance");

        return grid;
    }

    private Grid<Project> createProjectGrid() {
        Grid<Project> grid = new Grid<>(Project.class);
        grid.setItems(getProjects());
        grid.setColumns("name", "team", "status", "completionDate");

        return grid;
    }

    private Grid<Employee> createEmployeeGrid() {
        Grid<Employee> grid = new Grid<>(Employee.class);
        grid.setItems(getEmployees());
        grid.setColumns("name", "department", "team", "position", "performance");

        return grid;
    }

    // Заглушки для данных (примеры)
    private List<Department> getDepartments() {
        return Arrays.asList(
                new Department("Найм", 10, 80),
                new Department("IT", 50, 90),
                new Department("Продажи", 20, 75)
        );
    }

    private List<Team> getTeams() {
        return Arrays.asList(
                new Team("Разработка", "IT", 30, 85),
                new Team("Маркетинг", "Продажи", 15, 70),
                new Team("Найм", "Найм", 5, 80)
        );
    }

    private List<Project> getProjects() {
        return Arrays.asList(
                new Project("Дизайн вебсайтов", "Разработка", "In_PROGRESS", "2023-06-30"),
                new Project("Запуск продуктов", "Маркетинг", "COMPLETED", "2023-04-15"),
                new Project("Сопровождение", "Найм", "COMPLETED", "2023-07-15")
        );
    }

    private List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("Семёнов Александр А.", "IT", "Разработка", "Разработчик", 90),
                new Employee("Капитал Антон М.", "Sales", "Marketing", "Маркетолог", 75),
                new Employee("Провеник Андрей С.", "HR", "Recruitment", "HR Manager", 80)
        );
    }
}