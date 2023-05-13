package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Header;
import ru.akvine.prorisefront.views.dto.Goal;
import ru.akvine.prorisefront.views.dto.GoalStatus;
import ru.akvine.prorisefront.views.dto.GoalType;

import java.time.LocalDate;
import java.util.List;

@Route("/goals")
public class TasksView extends VerticalLayout {
    private final Grid<Goal> grid = new Grid<>(Goal.class);
    private final TextField titleField = new TextField("Название задачи");
    private final TextField employerField = new TextField("ФИО Сотрудника");
    private final TextField teamField = new TextField("Команда");
    private final TextField projectField = new TextField("Проект");
    private final TextField departmentField = new TextField("Департамент");
    private final ComboBox<GoalType> typeComboBox = new ComboBox<>("Тип цели");
    private final DatePicker startDatePicker = new DatePicker("Дата начала");
    private final DatePicker endDatePicker = new DatePicker("Дата окончания");
    private final Button addButton = new Button("Добавить");
    private final Button updateButton = new Button("Обновить");
    private final Button deleteButton = new Button("Удалить");
    private final HorizontalLayout formLayout = new HorizontalLayout(employerField, teamField, projectField, departmentField, titleField, typeComboBox, startDatePicker, endDatePicker, addButton, updateButton, deleteButton);

    public TasksView() {
        add(new Header());
        typeComboBox.setItems(GoalType.values());

        grid.setColumns("employerName", "teamName", "projectName", "departmentName", "title", "type", "startDate", "endDate", "goalStatus");
        grid.setItems(getGoals());

        addButton.addClickListener(e -> addGoal());
        updateButton.addClickListener(e -> updateGoal());
        deleteButton.addClickListener(e -> deleteGoal());

        formLayout.setAlignItems(Alignment.BASELINE);

        add(grid, formLayout);
    }

    private List<Goal> getGoals() {
        // Здесь необходимо получить список целей из базы данных или другого источника
        return List.of(
                new Goal("Самуров Олег А.", "Сбор Чаевых", "Команда разработки", "Департамент внедрения", "Выполнить задачу по макетам", GoalType.NEW, LocalDate.now(), LocalDate.now().plusDays(3), GoalStatus.NOT_STARTED),
                new Goal("Камойлова Анна В.", "Замеры горных пород", "Команда сопровождения", "Департамент внедрения", "Предоставить конфиги", GoalType.NEW, LocalDate.now(), LocalDate.now().plusDays(7), GoalStatus.STARTER),
                new Goal("Жуков Сергей Л.", "Выдача кредитов", "Команда разбора инцидентов", "Департамент безопасности", "Дежурство", GoalType.NEW, LocalDate.now(), LocalDate.now().plusDays(1), GoalStatus.COMPLETED));
    }

    private void addGoal() {
        Goal goal = new Goal();
        goal.setTitle(titleField.getValue());
        goal.setEmployerName(employerField.getValue());
        goal.setProjectName(projectField.getValue());
        goal.setTeamName(teamField.getValue());
        goal.setDepartmentName(departmentField.getValue());
        goal.setType(typeComboBox.getValue());
        goal.setStartDate(startDatePicker.getValue());
        goal.setEndDate(endDatePicker.getValue());
        goal.setGoalStatus(GoalStatus.NOT_STARTED);

        // Здесь необходимо сохранить цель в базе данных или другом источнике

        grid.setItems(getGoals());
    }

    private void updateGoal() {
        Goal selectedGoal = grid.asSingleSelect().getValue();
        if (selectedGoal != null) {
            selectedGoal.setTitle(titleField.getValue());
            selectedGoal.setEmployerName(employerField.getValue());
            selectedGoal.setTeamName(teamField.getValue());
            selectedGoal.setProjectName(projectField.getValue());
            selectedGoal.setDepartmentName(departmentField.getValue());
            selectedGoal.setType(typeComboBox.getValue());
            selectedGoal.setStartDate(startDatePicker.getValue());
            selectedGoal.setEndDate(endDatePicker.getValue());

            // Здесь необходимо обновить цель в базе данных или другом источнике

            grid.setItems(getGoals());
        }
    }

    private void deleteGoal() {
        Goal selectedGoal = grid.asSingleSelect().getValue();
        if (selectedGoal != null) {
            // Здесь необходимо удалить цель из базы данных или другого источника

            grid.setItems(getGoals());
        }
    }
}
