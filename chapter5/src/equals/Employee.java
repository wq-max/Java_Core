package equals;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var other = (Employee) o;
        return Objects.equals(name, other.name)
                && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }
}
