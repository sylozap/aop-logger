//package com.example.aop_logger;

import java.util.Objects;

public class ClassRoom extends Room {
    private int capacity; // Вместимость
    private String subject; // Предмет

    public ClassRoom() {
        super();
        this.capacity = 0;
        this.subject = "Общий";
    }

    public ClassRoom(int area, String name, int capacity, String subject) {
        super(area, name);
        setCapacity(capacity);
        this.subject = subject;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость должна быть положительной.");
        }
        this.capacity = capacity;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClassRoom that = (ClassRoom) o;
        return capacity == that.capacity && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity, subject);
    }

    @Override
    public String toString() {
        return "УчебнаяАудитория{" +
                "площадь=" + area +
                ", название='" + name + '\'' +
                ", вместимость=" + capacity +
                ", предмет='" + subject + '\'' +
                '}';
    }
}