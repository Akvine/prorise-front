package ru.akvine.prorisefront.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWithTime {
    private String firstName;
    private String lastName;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
}
