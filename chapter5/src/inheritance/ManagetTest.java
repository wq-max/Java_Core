package inheritance;

public class ManagetTest {

    public static void main(String[] args) {

        var boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        var  staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[1] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
        staff[2] = boss;

        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}
