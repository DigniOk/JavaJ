import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        List<Department> departments = fillDepartments();
        List<Person> persons = fillPersonList(departments);
        System.out.println(" 1 ");
        Homework.printNamesOrdered(persons);
        System.out.println(" 2 ");
        System.out.println(Homework.printDepartmentOldestPerson(persons));
        System.out.println(" 3 ");
        Homework.findFirstPersons(persons).forEach(System.out::println);
        System.out.println(" 4 ");
        System.out.println(Homework.findTopDepartment(persons));
    }
    public static List<Department> fillDepartments() {
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            departments.add(new Department("Department #" + i));
        }
        return departments;
    }
    public static List<Person> fillPersonList(List<Department> departments) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            persons.add(new Person(
                    "Person #" + i,
                    ThreadLocalRandom.current().nextInt(20, 61),
                    ThreadLocalRandom.current().nextInt(20_000, 100_000) * 1.0,
                    departments.get(ThreadLocalRandom.current().nextInt(departments.size()))
            ));
        }
        return persons;
    }
}
