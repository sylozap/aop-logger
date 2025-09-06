package com.example;

import java.util.Objects;

public class Cabinet extends Room {
    private int numberOfWorkplaces;
    private String department;

    public Cabinet() {
        super();
        this.numberOfWorkplaces = 0;
        this.department = "Без отдела";
    }

    public Cabinet(int area, String name, int numberOfWorkplaces, String department) {
        super(area, name);
        setNumberOfWorkplaces(numberOfWorkplaces);
        this.department = department;
    }

    public int getNumberOfWorkplaces() {
        return numberOfWorkplaces;
    }

    public void setNumberOfWorkplaces(int numberOfWorkplaces) {
        if (numberOfWorkplaces <= 0) {
            throw new IllegalArgumentException("Количество рабочих мест должно быть положительным.");
        }
        this.numberOfWorkplaces = numberOfWorkplaces;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cabinet that = (Cabinet) o;
        return numberOfWorkplaces == that.numberOfWorkplaces && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfWorkplaces, department);
    }

    @Override
    public String toString() {
        return "Кабинет{" +
                "площадь=" + area +
                ", название='" + name + '\'' +
                ", количество рабочих мест=" + numberOfWorkplaces +
                ", отдел='" + department + '\'' +
                '}';
    }
}