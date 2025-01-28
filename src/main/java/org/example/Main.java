package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Основной класс консольного приложения для работы с персонами (студентами, преподавателями, сотрудниками)
 */
public class Main {
    // Список для хранения персон
    private static final List<Persona> personas = new ArrayList<>();

    /** Главный метод приложения для взаимодействия с пользователем*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить новый элемент");
            System.out.println("2. Удалить элемент по индексу");
            System.out.println("3. Вывод всех элементов");
            System.out.println("4. Сравнение двух элементов");
            System.out.println("5. Завершение работы");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addPersona();
                case 2 -> removePersona();
                case 3 -> printPersonas();
                case 4 -> comparePersonas();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    /**Метод для добавления новой персоны*/
    private static void addPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип элемента:");
        System.out.println("1. Студент");
        System.out.println("2. Преподаватель");
        System.out.println("3. Сотрудник");

        int choice = scanner.nextInt();

        Persona persona;

        switch (choice) {
            case 1 -> {
                persona = new Student();
            }
            case 2 -> {
                persona = new Teacher();
            }
            case 3 -> {
                persona = new Employee();
            }
            default -> {
                System.out.println("Неверный выбор!");
                return;
            }
        }

        persona.readData();
        personas.add(persona);
        System.out.println("Элемент добавлен!");
    }

    /**Метод для удаления персоны по индексу*/
    private static void removePersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите индекс элемента для удаления:");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < personas.size()) {
            personas.remove(index);
            System.out.println("Элемент удален!");
        } else {
            System.out.println("Неверный индекс!");
        }
    }

    /**Метод для вывода всех персон*/
    private static void printPersonas() {
        int num = 1;
        for (Persona persona : personas) {
            System.out.println(num + ": " + persona);
            num++;
        }
    }

    /**Метод для сравнения двух персон*/
    private static void comparePersonas() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите индексы двух элементов для сравнения:");
        int firstIndex = scanner.nextInt() - 1;
        int secondIndex = scanner.nextInt() - 1;

        if (firstIndex >= 0 && firstIndex < personas.size() && secondIndex >= 0 && secondIndex < personas.size()) {
            Persona firstPersona = personas.get(firstIndex);
            Persona secondPersona = personas.get(secondIndex);

            if (firstPersona.equals(secondPersona)) {
                System.out.println("Элементы равны");
            } else {
                System.out.println("Элементы не равны");
            }
        } else {
            System.out.println("Неверные индексы!");
        }
    }
}

