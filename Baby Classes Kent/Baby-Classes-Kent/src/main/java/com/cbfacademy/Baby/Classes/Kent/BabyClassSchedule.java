package com.cbfacademy.Baby.Classes.Kent;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "class_schedule")
public class BabyClassSchedule {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    @JsonIgnore
    private UUID id;

    @Id
    @GeneratedValue
    @Column(name = "class_id", columnDefinition = "BINARY(16)")
    @JsonIgnore
    private UUID classId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonBackReference
    private BabyClassEntity babyClass;

    // Getters and Setters
    public BabyClassEntity getBabyClass() { return babyClass; }
    public void setBabyClass(BabyClassEntity babyClass) { this.babyClass = babyClass; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    // --- Getters & Setters ---

    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClassId() {
        return classId;
    }
    public void setClassId(UUID classId) {
        this.classId = classId;
    }
}