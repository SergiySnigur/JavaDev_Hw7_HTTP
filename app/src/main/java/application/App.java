
package application;

import application.cli.HttpImageStatusCli;

public class App {
    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
