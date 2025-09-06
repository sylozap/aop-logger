//package com.example.aop_logger;

import java.util.Objects;
import java.util.Scanner;

public class Room {
    protected int area; // Площадь
    protected String name; // Название

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

    // Метод для безопасного ввода числовых параметров
    public static int getIntInput(Scanner scanner, String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Ошибка: Значение должно быть в диапазоне от " + min + " до " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите целое число.");
            }
        }
    }
}