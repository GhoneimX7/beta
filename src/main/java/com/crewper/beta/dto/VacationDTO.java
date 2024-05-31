package com.crewper.beta.dto;

import com.crewper.beta.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class VacationDTO {
    private Employee employee;
    private LocalDate startDate;
    private LocalDate endDate;
}
