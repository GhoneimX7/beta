package com.crewper.beta.controller;

import com.crewper.beta.dto.VacationDTO;
import com.crewper.beta.entity.Employee;
import com.crewper.beta.entity.Vacation;
import com.crewper.beta.service.VacationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vacation")
public class VacationRestController {
    Logger logger = LoggerFactory.getLogger(VacationRestController.class);

    @Autowired
    private VacationService vacationService;

    @GetMapping()
    public ResponseEntity<List<Vacation>> getVacations() {
        return new ResponseEntity<>(vacationService.getVacations(), HttpStatus.OK);
    }

    @PostMapping("/request")
    public ResponseEntity<Vacation> requestVacation(@RequestBody Employee employee,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) throws Exception {
        try {
            VacationDTO vacation = VacationDTO.build(employee, startDate, endDate);
            return new ResponseEntity<>(vacationService.requestVacation(vacation), HttpStatus.OK);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
}
