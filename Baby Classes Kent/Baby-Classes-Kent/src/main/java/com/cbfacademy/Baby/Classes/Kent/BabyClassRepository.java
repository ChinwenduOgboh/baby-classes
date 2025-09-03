package com.cbfacademy.Baby.Classes.Kent;

import com.cbfacademy.Baby.Classes.Kent.BabyClassEntity.ClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface BabyClassRepository extends JpaRepository<BabyClassEntity, UUID> {

    // Find all classes of a specific type
    List<BabyClassEntity> findByType(ClassType type);

    // Find classes suitable for a given age in months
    List<BabyClassEntity> findByMinAgeMonthsLessThanEqualAndMaxAgeMonthsGreaterThanEqual(int ageMin, int ageMax);

    //Search by city
    List<BabyClassEntity> findByCityContainingIgnoreCase(String city);

}
