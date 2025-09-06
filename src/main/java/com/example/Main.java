import com.example.Cabinet;
import com.example.ClassRoom;
import com.example.Gym;
import com.example.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Room> rooms = new ArrayList<>(); // Коллекция для хранения помещений
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            // Выводим меню
            System.out.println("\nМеню:");
            System.out.println("1. Добавить новый элемент");
            System.out.println("2. Удалить элемент по индексу");
            System.out.println("3. Вывести все элементы");
            System.out.println("4. Сравнить два элемента");
            System.out.println("5. Завершить работу");
            System.out.print("Выберите пункт: ");

            int choice = getIntInput("Выберите пункт: ", 1, 5); // Безопасный ввод числа

            switch (choice) {
                case 1:
                    addElement();
                    break;
                case 2:
                    removeElement();
                    break;
                case 3:
                    printAllElements();
                    break;
                case 4:
                    compareElements();
                    break;
                case 5:
                    running = false;
                    System.out.println("Программа завершена.");
                    break;
            }
        }
        scanner.close();
    }

    // Метод для безопасного ввода целого числа в заданном диапазоне
    private static int getIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Ошибка: Значение должно быть от " + min + " до " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите целое число.");
            }
        }
    }

    // Добавление нового элемента
    private static void addElement() {
        System.out.println("Выберите тип помещения:");
        System.out.println("1. Обычное помещение (com.example.Room)");
        System.out.println("2. Учебная аудитория (com.example.ClassRoom)");
        System.out.println("3. Спортзал (com.example.Gym)");
        System.out.println("4. Кабинет (com.example.Cabinet)");
        int type = getIntInput("Тип: ", 1, 4);

        // Общие поля для всех классов
        int area = getIntInput("Введите площадь (положительное число): ", 1, Integer.MAX_VALUE);
        System.out.print("Введите название: ");
        String name = scanner.nextLine().trim();

        Room room;
        switch (type) {
            case 1: // com.example.Room
                room = new Room(area, name);
                break;
            case 2: // com.example.ClassRoom
                int capacity = getIntInput("Введите вместимость (положительное число): ", 1, Integer.MAX_VALUE);
                System.out.print("Введите предмет: ");
                String subject = scanner.nextLine().trim();
                room = new ClassRoom(area, name, capacity, subject);
                break;
            case 3: // com.example.Gym
                int equipmentCount = getIntInput("Введите количество оборудования (положительное число): ", 1, Integer.MAX_VALUE);
                System.out.print("Введите вид спорта: ");
                String sportType = scanner.nextLine().trim();
                room = new Gym(area, name, equipmentCount, sportType);
                break;
            case 4: // com.example.Cabinet
                int numberOfWorkplaces = getIntInput("Введите количество рабочих мест (положительное число): ", 1, Integer.MAX_VALUE);
                System.out.print("Введите отдел: ");
                String department = scanner.nextLine().trim();
                room = new Cabinet(area, name, numberOfWorkplaces, department);
                break;
            default:
                System.out.println("Неверный тип.");
                return;
        }
        rooms.add(room);
        System.out.println("Элемент добавлен: " + room);
    }

    // Удаление элемента по индексу
    private static void removeElement() {
        if (rooms.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        int index = getIntInput("Введите индекс для удаления (0 до " + (rooms.size() - 1) + "): ", 0, rooms.size() - 1);
        Room removed = rooms.remove(index);
        System.out.println("Элемент удалён: " + removed);
    }

    // Вывод всех элементов
    private static void printAllElements() {
        if (rooms.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        System.out.println("Список всех помещений:");
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(i + ": " + rooms.get(i));
        }
    }

    // Сравнение двух элементов
    private static void compareElements() {
        if (rooms.size() < 2) {
            System.out.println("Недостаточно элементов для сравнения (нужно минимум 2).");
            return;
        }
        int index1 = getIntInput("Введите первый индекс (0 до " + (rooms.size() - 1) + "): ", 0, rooms.size() - 1);
        int index2 = getIntInput("Введите второй индекс (0 до " + (rooms.size() - 1) + "): ", 0, rooms.size() - 1);
        boolean areEqual = rooms.get(index1).equals(rooms.get(index2));
        System.out.println("Элементы " + index1 + " и " + index2 + " равны: " + areEqual);
    }
}