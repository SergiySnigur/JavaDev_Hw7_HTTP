package application.cli;

import application.checker.HttpStatusChecker;
import application.downloader.HttpStatusImageDownloader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter HTTP status code: ");
            String statusCode = scanner.nextLine();
            if (isDigit(statusCode)) {
                try {
                    downloader.downloadStatusImage(Integer.parseInt(statusCode));
                } catch (IOException | InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Please enter valid number!");
            }
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    /*
запитати у юзера код статусу (наприклад, Enter HTTP status code)
юзер вводить в консоль код статусу (наприклад, 200)
програма перевіряє, чи є картинка для цього статусу на сайті https://http.cat,
і якщо є - то скачує цю картинку. Якщо ж картинки немає
- виводить в консоль фразу There is not image for HTTP status <CODE> (замість <CODE> підставляється код статусу, що ввів користувач)
якщо користувач вводить некоректне число (наприклад, test) - програма має вивести фразу Please enter valid number
 */
}
