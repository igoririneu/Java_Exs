/*
    Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
    N funcionários. Não deve haver repetição de id.
    Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
    Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
    mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
    conforme exemplos.
    Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
    ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
    aumento por porcentagem dada.
*/

import Entity.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int registered = sc.nextInt();

        List<Employees> list = new ArrayList<>() {
        };

        for (int i = 1; i <= registered; i++){

            System.out.println("\nEmployee " + i + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();

            Employees emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

            if(emp != null){

                System.out.println("\nError: Id already exists!");
                break;
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            list.add(new Employees(id, name, salary));
        }

        System.out.print("\nDo you want to increase the salary of an employee (y/n)? ");
        char increase = sc.next().charAt(0);

        if(increase == 'y'){

            System.out.print("\nEnter the employee id that will have salary increase: ");
            int idSalary = sc.nextInt();
            Integer pos = position(list, idSalary);

            if (pos == null){
                System.out.println("This id does not exist!");
            } else {
                System.out.print("Enter the percentage: ");
                double percent = sc.nextDouble();
                list.get(pos).increaseSalary(percent);
            }

            System.out.println("\nList of employees:");
            for (Employees employee : list) {
                System.out.println(employee);
            }

        } else {

            System.out.println("\nFim!");
        }

        sc.close();
    }

    // Function that fetches the position of the id in the list.
    public static Integer position(List<Employees> list, int id){
        for (Integer i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }

}