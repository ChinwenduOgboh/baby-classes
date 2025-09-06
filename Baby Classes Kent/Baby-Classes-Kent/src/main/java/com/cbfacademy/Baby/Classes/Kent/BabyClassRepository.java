package com.cbfacademy.Baby.Classes.Kent;

import com.cbfacademy.Baby.Classes.Kent.BabyClassEntity.ClassType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface BabyClassRepository extends JpaRepository<BabyClassEntity, UUID> {

    // Find all classes of a specific type
    List<BabyClassEntity> findByType(ClassType type);

    // --- JPQL Query: same as above but explicit ---
    @Query("SELECT DISTINCT b FROM BabyClassEntity b LEFT JOIN FETCH b.schedules s WHERE s.startTime > :now OR s.id IS NULL")
    List<BabyClassEntity> findAllUpcomingWithSchedules(@Param("now") LocalDateTime now);

    // Find classes suitable for a specific age range
    List<BabyClassEntity> findByMinAgeMonthsLessThanEqualAndMaxAgeMonthsGreaterThanEqual(int ageMin, int ageMax);

    //Search by city
    List<BabyClassEntity> findByCityContainingIgnoreCase(String city);

}
