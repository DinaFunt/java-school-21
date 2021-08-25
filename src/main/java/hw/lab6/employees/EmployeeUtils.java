package hw.lab6.employees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeUtils {

    public static Map<Seniority, Long> groupBySeniority(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(employee -> Seniority.getSeniorityBySalary(employee.getSalary()), Collectors.counting()));
    }

    public static int totalSalary(List<Employee> employees) {
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }

    public static int totalSalaryReduceSolution(List<Employee> employees) {
        return employees.stream().map(Employee::getSalary).reduce(Integer::sum).get();
    }

    public static Map<String, Employee> getMapOfEmployees(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toMap(Employee::getName, employee -> employee, (e1, e2) -> e1));
    }

    public static List<String> getSortedNamesBySalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Vasya", 6));
        list.add(new Employee("Petya", 7));
        list.add(new Employee("Lena", 14));
        list.add(new Employee("Kolya", 15));
        list.add(new Employee("Vasya", 30));
        list.add(new Employee("Kolya", 21));

        List<String> l1 = getSortedNamesBySalary(list);
        System.out.println("list : " + l1);

        Map<String, Employee> l2 = getMapOfEmployees(list);
        System.out.println("map : " + l2);

        Map<Seniority, Long> l3 = groupBySeniority(list);
        System.out.println("seniority : " + l3);
    }
}
