package com.cbfacademy.Baby.Classes.Kent;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "baby_class")
public class BabyClassEntity {

    public enum ClassType { music, art, sensory, swimming, playgroup, other }

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;
    private String description;
    private String address;
    private String city;
    private String postcode;
    private int minAgeMonths;
    private int maxAgeMonths;

    @Enumerated(EnumType.STRING)
    private ClassType type;

    private double latitude;
    private double longitude;

    @OneToMany(mappedBy = "babyClass", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<BabyClassSchedule> schedules;

    // Getters and Setters
    public List<BabyClassSchedule> getSchedules() { return schedules; }
    public void setSchedules(List<BabyClassSchedule> schedules) { this.schedules = schedules; }

    // Getters and Setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ClassType getType() {
        return type;
    }
    public void setType(ClassType type) {
        this.type = type;
    }
    public int getMinAgeMonths() {
        return minAgeMonths;
    }
    public void setMinAgeMonths(int minAgeMonths) {
        this.minAgeMonths = minAgeMonths;
    }
    public int getMaxAgeMonths() {
        return maxAgeMonths;
    }
    public void setMaxAgeMonths(int maxAgeMonths) {
        this.maxAgeMonths = maxAgeMonths;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public void addSchedule(BabyClassSchedule schedule) {
        schedules.add(schedule);
        schedule.setBabyClass(this);
    }

    public void removeSchedule(BabyClassSchedule schedule) {
        schedules.remove(schedule);
        schedule.setBabyClass(null);
    }
}




