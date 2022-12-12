package application.downloader;

import application.checker.HttpStatusChecker;

import java.io.*;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws IOException, InterruptedException {
        HttpStatusChecker checker = new HttpStatusChecker();
        URL url = new URL(checker.getStatusImage(code));
        String path = "app/src/main/resources/images/";
        File file = new File(path + code + ".jpg");

        if (file.createNewFile()) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(file); InputStream readBytes = url.openStream()) {
                fileOutputStream.write(readBytes.readAllBytes());
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new FileAlreadyExistsException("File already exists!");
        }
    }
}
