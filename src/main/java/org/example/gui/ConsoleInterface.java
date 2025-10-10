package org.example.gui;

import org.example.algorithm.Algorithm;

import java.util.Scanner;

public class ConsoleInterface {

    private final Scanner scanner = new Scanner(System.in);

    private void print(String message) {
        System.out.println(message);
    }

    public void menu() {
        Algorithm algorithm = new Algorithm();

        print("Добро пожаловать в программу по тестированию сайтов");
        print("Напишите количество тестированний");
        int count = scanner.nextInt();

        print("Выберети номер задания для тестирования" +
                "\nЗадания:" +
                "\n1. Форма" +
                "\n2. Событие" +
                "\n3. Модельные окна"
        );

        switch (scanner.next()) {
            case "1":
                print(algorithm.form(count, form()));
                break;
            case "2":
                event();
                print(algorithm.event());
                break;
            case "3":
                window();
                print(algorithm.window());
                break;
            default:
                print("Неверное значение");
        }
    }

    private String[] form() {
        print("Задайте необходимые параметры тестирования");
        String[] input = new String[7];

        print("Введите имя пользователя: ");
        input[0] = scanner.next();
        scanner.nextLine();
        print("Введите пароль: ");
        input[1] = scanner.nextLine();
        print("Выберете напиток и впишите его номер. Если напитков несколько, то перечислите номера слитно через запятую" +
                "\n1. Вода" +
                "\n2. Молоко" +
                "\n3. Кофе" +
                "\n4. Вино" +
                "\n5. Чёрл-Альт-Дыль");
        input[2] = scanner.nextLine();
        print("Выберете любимый цвет и запишите его номер из списка и напишите его" +
                "\n1. Красный" +
                "\n2. Синий" +
                "\n3. Желтый" +
                "\n4. Зеленый" +
                "\n5. #FFC0CB");
        input[3] = scanner.nextLine();
        print("Вам наравится атоматизация? Выберете номер вопроса из списка и напишите его" +
                "\n1. Yes" +
                "\n2. No" +
                "\n3. Undecided");
        input[4] = scanner.nextLine();
        print("Впишите свою электронную почту");
        input[5] = scanner.nextLine();
        print("Впишите сообщение");
        input[6] = scanner.nextLine();

        return input;
    }


    private void event() {

    }

    private void window() {

    }
}
