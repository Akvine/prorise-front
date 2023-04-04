package ru.akvine.prorisefront.services.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GetKPIResponse {
    private Integer completedTasks;
    private LocalDate time;
}
