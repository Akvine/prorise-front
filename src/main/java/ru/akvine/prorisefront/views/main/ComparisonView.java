package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.views.dto.Department;
import ru.akvine.prorisefront.views.dto.Employee;
import ru.akvine.prorisefront.views.dto.Project;
import ru.akvine.prorisefront.views.dto.Team;

import java.util.Arrays;
import java.util.List;

@Route("comparison")
public class ComparisonView extends Div {

    public ComparisonView() {
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
                new Department("HR", 10, 80),
                new Department("IT", 50, 90),
                new Department("Sales", 20, 75)
        );
    }

    private List<Team> getTeams() {
        return Arrays.asList(
                new Team("Development", "IT", 30, 85),
                new Team("Marketing", "Sales", 15, 70),
                new Team("Recruitment", "HR", 5, 80)
        );
    }

    private List<Project> getProjects() {
        return Arrays.asList(
                new Project("Website Redesign", "Development", "In Progress", "2023-06-30"),
                new Project("Product Launch", "Marketing", "Completed", "2023-04-15"),
                new Project("Talent Acquisition Campaign", "Recruitment", "Planned", "2023-07-15")
        );
    }

    private List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee("John Smith", "IT", "Development", "Software Engineer", 90),
                new Employee("Emily Johnson", "Sales", "Marketing", "Marketing Specialist", 75),
                new Employee("Sarah Davis", "HR", "Recruitment", "HR Manager", 80)
        );
    }
}