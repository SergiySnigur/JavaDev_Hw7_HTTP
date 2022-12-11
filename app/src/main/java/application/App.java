
package application;

import application.checker.HttpStatusChecker;
import application.cli.HttpImageStatusCli;
import application.downloader.HttpStatusImageDownloader;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
