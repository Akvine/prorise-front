package ru.akvine.prorisefront.views.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
    private String employerName;
    private String teamName;
    private String projectName;
    private String departmentName;
    private String title;
    private GoalType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private GoalStatus goalStatus;
}
