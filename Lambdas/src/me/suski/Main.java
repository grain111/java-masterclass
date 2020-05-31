package me.suski;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        new Thread(new CodeToRun()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the Runnable. Anonymous class.");
            }
        }).start();

        new Thread(() -> {
            System.out.println("Printing from the Runnable. Lambda expression.");
            System.out.println("Second line of lambda expression");
        }).start();


        System.out.println("======================");

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());

        });

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//        Collections.sort(employees, (emp1, emp2) ->
//                emp1.getName().compareTo(emp2.getName()));

//        for (Employee emp :
//                employees) {
//            System.out.println(emp.getName());
//            System.out.println(emp.getAge());
//        }

//        System.out.println("================");
//
//        for (int i = 0; i < employees.size(); i++) {
//            Employee employee = employees.get(i);
//            System.out.println(employee);
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

//        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
//        String sillyString = doStringStuff(
//                uc,
//                employees.get(0).getName(),
//                employees.get(1).getName());
//        System.out.println(sillyString);

//        UpperConcat uc = (s1, s2) -> {
//            String res = s1.toUpperCase() + s2.toUpperCase();
//            return res;
//        };
//        String sillyString = doStringStuff(
//                uc,
//                employees.get(0).getName(),
//                employees.get(1).getName());
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperConcat(s1, s2);
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from the Runnable. Classic class.");
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

interface UpperConcat {
    public String upperConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
//        System.out.println("The AnotherClass class's name is: " +
//                getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperConcat(String s1, String s2) {
//                System.out.println("The Anonymous class's name is: " +
//                        getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String 1", "String 2");

//        UpperConcat uc = ((s1, s2) -> {
//            System.out.println("The lambda expression's class is " +
//                    getClass().getSimpleName());
//            String res = s1.toUpperCase() + s2.toUpperCase();
//            return res;
//        });

        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " +
                    getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String res = s1.toUpperCase() + s2.toUpperCase();
            return res;
        };

//        UpperConcat uc = new UpperConcat() {
//            @Override
//            public String upperConcat(String s1, String s2) {
//                System.out.printf("i in anonymous = %d%n", i);
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        };

        System.out.println("The AnotherClass class's name is " +
                getClass().getSimpleName());

        return Main.doStringStuff(uc, "String 1", "String 2");


    }
    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };
        new Thread(r).start();
    }
}
