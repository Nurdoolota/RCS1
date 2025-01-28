package org.example;

import java.util.Objects;
import java.util.Scanner;

/**
 * Абстрактный класс, представляющий базовую сущность с двумя полями:
 * числовым (age) и текстовым (name). Предоставляет
 * методы для управления этими полями, а также переопределяет методы
 * equals, hashCode и toString.
 */
public abstract class Persona {
    protected String name; // имя персоны
    protected int age; // возраст персоны

    //    конструктор по умолчанию
    public Persona() {
    }

    /**Конструктор с параметрами для инициализации персоны
     * @param name строковый тип
     * @param age числовой тип**/
    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**Метод для ввода данных о персоне*/
    public void readData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя: ");
        name = scanner.nextLine();

        System.out.println("Введите возраст: ");
        age = scanner.nextInt();
    }
    /**Переопределение метода equals для сравнения персон*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona other = (Persona) obj;
        return Objects.equals(name, other.name) && age == other.age;
    }

    /**Переопределение метода hashCode для корректной работы с коллекциями*/
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /**Переопределение метода toString для вывода информации о персоне*/
    @Override
    public String toString() {
        return "Имя: " + name + ", возраст: " + age;
    }
}
