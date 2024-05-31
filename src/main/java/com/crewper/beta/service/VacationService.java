package com.crewper.beta.service;

import com.crewper.beta.dto.VacationDTO;
import com.crewper.beta.entity.Vacation;
import com.crewper.beta.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    public List<Vacation> getVacations() {
        return vacationRepository.findAll();
    }

    public Vacation requestVacation(VacationDTO vacation) throws Exception {
        try {
            return vacationRepository.save(Vacation.build(0, vacation.getEmployee(), vacation.getStartDate(), vacation.getEndDate()));
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }

    }
}
