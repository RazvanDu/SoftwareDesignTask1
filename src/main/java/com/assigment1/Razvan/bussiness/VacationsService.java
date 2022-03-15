package com.assigment1.Razvan.bussiness;

import com.assigment1.Razvan.persistence.DestinationsEntity;
import com.assigment1.Razvan.persistence.UserEntity;
import com.assigment1.Razvan.bussiness.UserService;
import com.assigment1.Razvan.persistence.VacationpackageEntity;
import com.assigment1.Razvan.persistence.VacationpackageRepository;

import javax.persistence.EntityManagerFactory;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VacationsService {

    VacationpackageRepository vacationpackageRepository;

    public VacationsService(EntityManagerFactory entityManagerFactory) {
        this.vacationpackageRepository = new VacationpackageRepository(entityManagerFactory);
    }

    public VacationpackageEntity byID(int id) {
        return vacationpackageRepository.findById(id);
    }

    public List<VacationpackageEntity> getAll() {
        return vacationpackageRepository.getAll();
    }

    public List<VacationpackageEntity> byDestination(String dest) {
        return getAll().stream().sorted(Comparator.comparing(a -> a.getDestination().getName())).filter(vacationpackageEntity -> vacationpackageEntity.getDestination().getName().toLowerCase().contains(dest.toLowerCase())).collect(Collectors.toList());
    }

    public List<VacationpackageEntity> byPrice(int price) {
        return getAll().stream().sorted(Comparator.comparing(a -> a.getDestination().getName())).filter(vacationpackageEntity -> vacationpackageEntity.getPrice() <= price).collect(Collectors.toList());
    }

    public List<VacationpackageEntity> byPeriod(int numberOfDays) {
        return getAll().stream().sorted(Comparator.comparing(a -> a.getDestination().getName())).filter(vacationpackageEntity ->
                ChronoUnit.DAYS.between(vacationpackageEntity.getStartDate().toLocalDate(), vacationpackageEntity.getEndDate().toLocalDate()) <= numberOfDays).collect(Collectors.toList());
    }

    public void save(VacationpackageEntity vacationpackageEntity) {
        vacationpackageRepository.save(vacationpackageEntity);
    }

    public void delete(VacationpackageEntity vacationpackageEntity) {
        vacationpackageRepository.delete(vacationpackageEntity);
    }

}
