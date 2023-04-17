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
public class GoalsView extends VerticalLayout {
    private final Grid<Goal> grid = new Grid<>(Goal.class);
    private final TextField nameField = new TextField("Название");
    private final ComboBox<GoalType> typeComboBox = new ComboBox<>("Тип цели");
    private final DatePicker startDatePicker = new DatePicker("Дата начала");
    private final DatePicker endDatePicker = new DatePicker("Дата окончания");
    private final Button addButton = new Button("Добавить");
    private final Button updateButton = new Button("Обновить");
    private final Button deleteButton = new Button("Удалить");
    private final HorizontalLayout formLayout = new HorizontalLayout(nameField, typeComboBox, startDatePicker, endDatePicker, addButton, updateButton, deleteButton);

    public GoalsView() {
        add(new Header());
        typeComboBox.setItems(GoalType.values());

        grid.setColumns("name", "type", "startDate", "endDate", "goalStatus");
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
                new Goal("name1", GoalType.DEBIT, LocalDate.now(), LocalDate.now().plusDays(3), GoalStatus.NOT_STARTED),
                new Goal("name2", GoalType.DEBIT, LocalDate.now(), LocalDate.now().plusDays(2), GoalStatus.NOT_STARTED),
                new Goal("name3", GoalType.DEBIT, LocalDate.now(), LocalDate.now().plusDays(1), GoalStatus.NOT_STARTED));
    }

    private void addGoal() {
        Goal goal = new Goal();
        goal.setName(nameField.getValue());
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
            selectedGoal.setName(nameField.getValue());
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
