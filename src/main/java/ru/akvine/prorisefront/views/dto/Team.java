package ru.akvine.prorisefront.views.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private String name;
    private String department;
    private int totalMembers;
    private int averagePerformance;
}
