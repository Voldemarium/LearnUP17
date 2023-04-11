package ru.learnup;

public class Main {
    public static void main(String[] args) {
        try {
            int first = Integer.parseInt(args[0]);  //преобразуем строковый аргумент args[0] к числу
            String op = args[1];                    //строковый аргумент args[1] - операция (+ или -)
            int second = Integer.parseInt(args[2]); //преобразуем строковый аргумент args[2] к числу
            switch (op) {
                case "+" -> System.out.printf("%d + %d = %d\n", first, second, first + second);
                case "-" -> System.out.printf("%d - %d = %d\n", first, second, first - second);
                default -> System.out.println("Default operation");
            }
        } catch (Exception e) {
            System.out.println("Wrong input.... Good buy");
        }
    }
}
