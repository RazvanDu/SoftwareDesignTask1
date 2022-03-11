package com.assigment1.Razvan.bussiness;

import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.bussiness.UserService;
import com.assigment1.Razvan.persistence.VacationpackageEntity;
import com.assigment1.Razvan.persistence.VacationpackageRepository;

import javax.persistence.EntityManager;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class VacationsService {

    VacationpackageRepository vacationpackageRepository;

    public VacationsService(EntityManager entityManager) {
        this.vacationpackageRepository = new VacationpackageRepository(entityManager);
    }

    public List<VacationpackageEntity> getAll() {
        return vacationpackageRepository.getAll();
    }

    public List<VacationpackageEntity> byDestination(String dest) {
        return getAll().stream().filter(vacationpackageEntity -> vacationpackageEntity.getDestination().toLowerCase().contains(dest.toLowerCase())).collect(Collectors.toList());
    }

    public List<VacationpackageEntity> byPrice(int price) {
        return getAll().stream().filter(vacationpackageEntity -> vacationpackageEntity.getPrice() <= price).collect(Collectors.toList());
    }

    public List<VacationpackageEntity> byPeriod(int numberOfDays) {
        return getAll().stream().filter(vacationpackageEntity ->
                ChronoUnit.DAYS.between(vacationpackageEntity.getStartDate().toLocalDate(), vacationpackageEntity.getEndDate().toLocalDate()) <= numberOfDays).collect(Collectors.toList());
    }

}
