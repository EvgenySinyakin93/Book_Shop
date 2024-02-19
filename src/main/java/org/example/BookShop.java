package org.example;

import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в магазин книг");

        String[] books = new String[]{"Дженни_Герхардт", "Оплот", "Три_товарища", "1984", "Ведьмак"};
        printMenu();
        Scanner user = new Scanner(System.in);

        System.out.println("Введите номер меню");
        int menuNum = user.nextInt();

        while (true) {
            if (menuNum == 1) {
                printAllBooks(books);
            } else if (menuNum == 2) {
                books = addBook(user, books);
            } else if (menuNum == 3) {
                books = removeBook(user, books);
            } else if (menuNum == 4) {
                bubbleSort(books);
            } else if (menuNum == 0) {
                System.out.println("Спасибо, что посетили наш книжный магазин");
                System.exit(0);
            }
            System.out.println("Введите номер меню");
            menuNum = user.nextInt();
        }
    }

    private static void bubbleSort(String[] books) {
        for (int j = 0; j < books.length; j++) {
            for (int i = 0; i < books.length - j - 1; i++) {
                if (books[i].charAt(0) > books[i + 1].charAt(0)){
                    String temp = books[i];
                    books[i] = books[i + 1];
                    books[i + 1] = temp;
                }
            }
        }
    }

    private static String[] removeBook(Scanner user, String[] books) {
        System.out.println("Введите название книги");
        String userBook = user.next();
        String[] delArray = new String[books.length - 1];

        int delIndex;
        for (delIndex = 0; delIndex < books.length; delIndex++) {
            if (books[delIndex].equals(userBook)) {
                break;
            }
                delArray[delIndex] = books[delIndex];
        }
        for (int i = delIndex; i < delArray.length; i++) {
            delArray[i] = books[i + 1];
        }
        return delArray;
    }

    private static String[] addBook(Scanner user, String[] books) {
        System.out.println("Введите название книги");
        String userBook = user.next();
        String[] resArray = new String[books.length + 1];

        for (int i = 0; i < books.length; i++){
            resArray[i] = books[i];
            System.out.print(books[i] + ", ");
        }
        resArray[books.length] = userBook;
        return resArray;
    }

    private static void printAllBooks(String[] books) {
        System.out.println("Ваши книги");

        for (int i = 0; i < books.length; i++){
            System.out.print(books[i] + ", ");
        }
        System.out.println();
    }

    public static void printMenu() {
        System.out.println("Меню\n" +
                "1.Вывести все книги\n" +
                "2.Добавить книгу\n" +
                "3.Удалить книгу\n" +
                "4.Отсортировать покупки\n" +
                "0.Выход из магазина");
    }
}

// Меню
// 1.Вывести все книги
// 2.Добавить книгу
// 3.Удалить книгу
// 4.Отсортировать покупки
// 0.Выход из магазина