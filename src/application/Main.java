package application;

import entities.Contributor;
import entities.IndividualTaxPayer;
import entities.LegalPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Contributor> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the numbers of tax payers: ");
        int taxPayers = sc.nextInt();
        for (int i = 1; i <= taxPayers; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.next();
            System.out.print("Anual Income: ");
            double anualIncome = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenses = sc.nextDouble();
                list.add(new IndividualTaxPayer(name, anualIncome, healthExpenses));
            } else if (ch == 'c') {
                System.out.print("Number of employees: ");
                int numberEmployee = sc.nextInt();
                list.add(new LegalPerson(name, anualIncome, numberEmployee));
            }
        }

        System.out.println("TAXES PAID: ");
        for(Contributor contributor : list)
        {
            System.out.println(contributor.getName() + ": $" + String.format("%.2f", contributor.showTaxes()));
        }
        double sum = 0;
        for(Contributor contributor : list)
        {
            sum += contributor.showTaxes();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));
    }
}