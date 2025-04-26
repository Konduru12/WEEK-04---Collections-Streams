import java.util.*;
import java.util.stream.Collectors;
class Employee {
    String name;
    String department;
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    @Override
    public String toString() {
        return name;
    }
}

public class GroupObjectByPatients{
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Abhinaya", "HR"),
            new Employee("Sasanka", "IT"),
            new Employee("Shasank", "IT")
        );

        Map<String, List<Employee>> grouped = employees.stream()
            .collect(Collectors.groupingBy(emp -> emp.department));
        grouped.forEach((dept, list) -> 
            System.out.println(dept + ": " + list)
        );
    }
}
