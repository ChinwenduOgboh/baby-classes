package com.cbfacademy.Baby.Classes.Kent;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Validated @Service
public class BabyClassService {

    @Autowired
    private BabyClassRepository repository; // use repository to fetch data

    public List<BabyClassEntity> getAllClasses() {
        return repository.findAll();
    }

    public  Optional<BabyClassEntity> getClassById(UUID id) {
        return repository.findById(id);
    }

    public BabyClassEntity createClass(BabyClassEntity babyClass) {
        return repository.save(babyClass);
    }

    public BabyClassEntity updateClass(UUID id, Babyclasseskent updatedClass) {
        return repository.findById(id).map(existing -> {
            existing.setName(updatedClass.getName());
            existing.setDescription(updatedClass.getDescription());
            existing.setAddress(updatedClass.getAddress());
            existing.setMinAgeMonths(updatedClass.getMinAgeMonths());
            existing.setMaxAgeMonths(updatedClass.getMaxAgeMonths());
            existing.setType(updatedClass.getType());
            existing.setCity(updatedClass.getCity());
            existing.setPostcode(updatedClass.getPostcode());
            existing.setLatitude(updatedClass.getLatitude());
            existing.setLongitude(updatedClass.getLongitude());
            existing.setSchedules(updatedClass.getSchedules());
            return repository.save(existing);
        }).orElseThrow(null);
    }

    public void deleteClass(UUID id) {
        repository.deleteById(id);
    }
    public List<BabyClassEntity> getByLocation(String location) {
        return repository.findByCityContainingIgnoreCase(location);
    }
    public List<BabyClassEntity> getClassesByType(BabyClassEntity.ClassType type) {
        return repository.findByType(type);
    }
    public List<BabyClassEntity> getClassesByAge(int months) {
        return repository.findByMinAgeMonthsLessThanEqualAndMaxAgeMonthsGreaterThanEqual(months, months);
    }
    public List<BabyClassEntity> getClassesByCity(String city) {
        return repository.findByCityContainingIgnoreCase(city);
    }
}
   
