package src;

import src.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Aplication {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = scanner.next();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            List<Employee> employeeList = new ArrayList<>();

            String line = bufferedReader.readLine();
            while (line != null){
                String[] fields = line.split(",");
                employeeList.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = bufferedReader.readLine();
            }

            double sum = employeeList.stream()
                            .filter(p -> p.getName().charAt(0) == 'M')
                            .mapToDouble(p -> p.getSalary())
                            .sum();

            System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();

            List<String> emails = employeeList.stream()
                            .filter(p -> p.getSalary() > salary)
                            .map(p -> p.getEmail()).sorted()
                            .collect(Collectors.toList());

            System.out.printf("Email of people whose salary is more than %.2f:%n", salary);
            emails.forEach(System.out::println);

            System.out.printf("Sum of salary of people whose name starts with 'M': %.2f%n", sum);
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
