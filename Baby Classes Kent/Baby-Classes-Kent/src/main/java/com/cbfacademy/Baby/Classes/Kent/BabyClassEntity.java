package com.cbfacademy.Baby.Classes.Kent;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "baby_class")
public class BabyClassEntity {

   @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private ClassType type; // music, swimming, sensory, etc.

    public enum ClassType {
    music,
    swimming,
    sensory,
    art,
    playgroup,
    other
    }

    @Column(name = "min_age_months")
    private int minAgeMonths;

    @Column(name = "max_age_months")
    private int maxAgeMonths;

    private String address;
    private String city;
    private String postcode;
    private Double latitude;
    private Double longitude;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}


