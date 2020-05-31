package me.suski;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);


        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        printEmployeesByAge(employees, "Employees over 30: ",
                employee -> employee.getAge() > 30);
        System.out.println("\n");
        printEmployeesByAge(employees, "Employees 30 and under: ",
                employee -> employee.getAge() <= 30);
        System.out.println("\n");
        printEmployeesByAge(employees, "Employees under 25: ",
                new Predicate<Employee>() {
                    @Override
                    public boolean test(Employee employee) {
                        return employee.getAge() < 25;
                    }
                });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i <100;

        System.out.println(greaterThan15.test(10));
        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(150));

        System.out.println("================");
        System.out.println("================");

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }

        System.out.println("================");
        System.out.println("================");

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().split(" ")[1];
        };

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().split(" ")[0];
        };

        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        Random random2 = new Random();
        for (Employee employee :
                employees) {
            if (random2.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        System.out.println("================");
        System.out.println("================");

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.split(" ")[0];
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (name, employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        System.out.println("================");
        System.out.println("================");

        IntUnaryOperator intBy5 = i -> i + 5;
        System.out.println(intBy5.applyAsInt(10));

        System.out.println("================");
        System.out.println("================");

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello");
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCond) {
        System.out.println(ageText);
        System.out.println("==============");

        for (Employee employee : employees) {
            if (ageCond.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
