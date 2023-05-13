package ru.akvine.prorisefront.views.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;
    private String department;
    private String team;
    private String position;
    private int performance;
}
