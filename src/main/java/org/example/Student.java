package org.example;

import java.util.Objects;
import java.util.Scanner;

/**Класс Student, представляющий студента, наследуется от Persona
 * помимо полей базового класса, содержит поля номера зачетной книжки и размер стипендии*/
public class Student extends Persona {

    private String recordBookNumber; //номер зачетной книжки
    private double scholarship;// размер стипендии

//    конструктор по умолчанию
    public Student() {
    }

    /**Конструктор с параметрами для инициализации студента
     * @param name строковый тип
     * @param age числовой тип
     * @param recordBookNumber числовой тип
     * @param scholarship числовой тип**/
    public Student(String name, int age, String recordBookNumber, double scholarship) {
        super(name, age);// Вызов конструктора родительского класса
        this.recordBookNumber = recordBookNumber;
        this.scholarship = scholarship;
    }

    // Переопределение метода readData для ввода данных о сотруднике
    @Override
    public void readData() {
        Scanner scanner = new Scanner(System.in);

        super.readData();// Вызов метода readData родительского класса

        System.out.println("Введите номер зачетной книжки: ");
        recordBookNumber = scanner.nextLine();

        System.out.println("Введите стипендию: ");
        scholarship = scanner.nextDouble();
    }

    /**
     * Переопределение метода toString() для представления объекта в виде строки
     * в строковом представлении включены числовое и текстовое поля из базового класса
     *
     * @return строковое представление объекта Student.
     */
    @Override
    public String toString() {
        return super.toString() + ", номер зачетной книжки: " + recordBookNumber + ", стипендия: " + scholarship;
    }

    /** Переопределение метода equals() для сравнения сотрудников
     * @param obj объект для сравнения
     * @return true, если объекты равны, иначе false */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return super.equals(obj) && Objects.equals(recordBookNumber, other.recordBookNumber) && scholarship == other.scholarship;
    }

    /** Переопределение метода hashCode() для генерации уникального хэш-кода объекта
     *  учитывает поля базового класса и тип теста
     *  @return хэш-код объекта*/
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordBookNumber, scholarship);
    }
}
