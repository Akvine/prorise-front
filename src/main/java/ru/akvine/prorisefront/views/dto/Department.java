package ru.akvine.prorisefront.views.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private String name;
    private int totalEmployees;
    private int averagePerformance;
}