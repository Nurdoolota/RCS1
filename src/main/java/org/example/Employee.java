package org.example;

import java.util.Objects;
import java.util.Scanner;

/**Класс Employee, представляющий сотрудника, наследуется от Persona
 * помимо полей базового класса, содержит поля должность и зарплата*/
public class Employee extends Persona {

    private String position;//должность сотрудника
    private double salary;//зарплата сотрудника

//    конструктор по умолчанию
    public Employee() {
    }
    /**Конструктор с параметрами для инициализации сотрудника
     * @param name строковый тип
     * @param age числовой тип
     * @param position строковый тип
     * @param salary числовой тип**/
    public Employee(String name, int age, String position, double salary) {
        super(name, age);// Вызов конструктора родительского класса
        this.position = position;
        this.salary = salary;
    }

    // Переопределение метода readData для ввода данных о сотруднике
    @Override
    public void readData() {
        Scanner scanner = new Scanner(System.in);

        super.readData();// Вызов метода readData родительского класса

        System.out.println("Введите должность: ");
        position = scanner.nextLine();

        System.out.println("Введите зарплату: ");
        salary = scanner.nextDouble();
    }

    /**
     * Переопределение метода toString() для представления объекта в виде строки
     * в строковом представлении включены числовое и текстовое поля из базового класса
     *
     * @return строковое представление объекта Employee.
     */
    @Override
    public String toString() {
        return super.toString() + ", должность: " + position + ", зарплата: " + salary;
    }

    /** Переопределение метода equals() для сравнения сотрудников
     * @param obj объект для сравнения
     * @return true, если объекты равны, иначе false */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return super.equals(obj) && Objects.equals(position, other.position) && salary == other.salary;
    }

    /** Переопределение метода hashCode() для генерации уникального хэш-кода объекта
     *  учитывает поля базового класса и тип теста
     *  @return хэш-код объекта*/
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position, salary);
    }

}
