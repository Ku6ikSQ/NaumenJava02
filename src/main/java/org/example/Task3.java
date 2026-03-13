package org.example;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private String fullName;
    private int age;
    private String department;
    private double salary;

    public Employee(String fullName, int age, String department, double salary) {
        this.fullName = fullName;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s, %d лет, отдел: %s, з/п: %.2f руб.",
                fullName, age, department, salary);
    }
}

public final class Task3 {
    private final List<Employee> employees;

    public Task3() {
        employees = new ArrayList<>();

        employees.add(new Employee("Иванов Иван Иванович", 35, "Отдел продаж", 85000));
        employees.add(new Employee("Петров Пётр Петрович", 29, "ИТ-отдел", 120000));
        employees.add(new Employee("Сидорова Анна Сергеевна", 41, "Бухгалтерия", 95000));
        employees.add(new Employee("Кузнецов Алексей Викторович", 50, "Отдел логистики", 78000));
        employees.add(new Employee("Орлова Екатерина Михайловна", 26, "Бухгалтерия", 88000));
    }

    public double getAverageSalaryByDepartment(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
}