package org.example;

import java.util.Objects;
import java.util.Scanner;

/**Класс Employee, представляющий учителя, наследуется от Persona
 * помимо полей базового класса, содержит поля должность и ученую степень*/
public class Teacher extends Persona {

    private String position;// должность учителя
    private String academicDegree;// ученая степень учителя

    //    конструктор по умолчанию
    public Teacher() {
    }

    /**Конструктор с параметрами для инициализации сотрудника
     * @param name строковый тип
     * @param age числовой тип
     * @param position строковый тип
     * @param academicDegree строковый тип**/
    public Teacher(String name, int age, String position, String academicDegree) {
        super(name, age);
        this.position = position;
        this.academicDegree = academicDegree;
    }

    // Переопределение метода readData для ввода данных о сотруднике
    @Override
    public void readData() {
        Scanner scanner = new Scanner(System.in);

        super.readData();

        System.out.println("Введите должность: ");
        position = scanner.nextLine();

        System.out.println("Введите ученую степень: ");
        academicDegree = scanner.nextLine();
    }

    /**
     * Переопределение метода toString() для представления объекта в виде строки
     * в строковом представлении включены числовое и текстовое поля из базового класса
     *
     * @return строковое представление объекта Teacher.
     */
    @Override
    public String toString() {
        return super.toString() + ", должность: " + position + ", ученая степень: " + academicDegree;
    }

    /** Переопределение метода equals() для сравнения сотрудников
     * @param obj объект для сравнения
     * @return true, если объекты равны, иначе false */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Teacher other = (Teacher) obj;
        return super.equals(obj) && Objects.equals(position, other.position) && Objects.equals(academicDegree, other.academicDegree);
    }

    /** Переопределение метода hashCode() для генерации уникального хэш-кода объекта
     *  учитывает поля базового класса и тип теста
     *  @return хэш-код объекта*/
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position, academicDegree);
    }

}
