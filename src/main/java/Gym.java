//package com.example.aop_logger;

import java.util.Objects;

public class Gym extends Room {
    private int equipmentCount; // Количество спортивного оборудования
    private String sportType; // Вид спорта

    public Gym() {
        super();
        this.equipmentCount = 0;
        this.sportType = "Универсальный";
    }

    public Gym(int area, String name, int equipmentCount, String sportType) {
        super(area, name);
        setEquipmentCount(equipmentCount);
        this.sportType = sportType;
    }

    public int getEquipmentCount() {
        return equipmentCount;
    }

    public void setEquipmentCount(int equipmentCount) {
        if (equipmentCount <= 0) {
            throw new IllegalArgumentException("Количество оборудования должно быть положительным.");
        }
        this.equipmentCount = equipmentCount;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gym sportZal = (Gym) o;
        return equipmentCount == sportZal.equipmentCount && Objects.equals(sportType, sportZal.sportType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipmentCount, sportType);
    }

    @Override
    public String toString() {
        return "СпортЗал{" +
                "площадь=" + area +
                ", название='" + name + '\'' +
                ", количество оборудования=" + equipmentCount +
                ", вид спорта='" + sportType + '\'' +
                '}';
    }
}