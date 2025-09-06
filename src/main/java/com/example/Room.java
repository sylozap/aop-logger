package com.example;

import java.util.Objects;

public class Room {
    protected int area;
    protected String name;

    public Room() {
        this.area = 0;
        this.name = "Неизвестное помещение";
    }

    public Room(int area, String name) {
        setArea(area);
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Площадь должна быть положительной.");
        }
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room that = (Room) o;
        return area == that.area && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, name);
    }

    @Override
    public String toString() {
        return "Помещение{" +
                "площадь=" + area +
                ", название='" + name + '\'' +
                '}';
    }
}