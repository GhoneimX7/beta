package com.crewper.beta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private int totalVacationBalance;
    private int remainingVacationBalance;
}
