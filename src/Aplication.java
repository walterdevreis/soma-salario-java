package src;

import src.entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Aplication {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Employee employee = new Employee("Bob", "bob@gmail.com", 3500.00);

        System.out.println(employee);
    }




}
