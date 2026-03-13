package org.example;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

interface Task {
    void start();

    void stop();
}

public final class Task5 implements Task {
    private final String fileUrl;
    private final String outputFile;
    private final AtomicBoolean running = new AtomicBoolean(false);

    private Thread downloadThread;

    public Task5(String fileUrl, String outputFile) {
        this.fileUrl = fileUrl;
        this.outputFile = outputFile;
    }

    @Override
    public void start() {
        if (running.get()) {
            System.out.println("[Task5]: Скачивание уже выполняется.");
            return;
        }

        running.set(true);
        downloadThread = new Thread(this::downloadFile);
        downloadThread.start();
    }

    @Override
    public void stop() {
        if (!running.get()) {
            System.out.println("[Task5]: Скачивание не выполняется.");
            return;
        }
        running.set(false);
    }

    private void downloadFile() {
        System.out.println("[Task5]: Начало скачивания: " + fileUrl);
        try (BufferedInputStream in = openInputStream();
             FileOutputStream out = new FileOutputStream(outputFile)) {

            copyStream(in, out);

            if (running.get()) {
                System.out.println("[Task5]: Скачивание завершено успешно. Файл сохранён: " + outputFile);
            } else {
                deleteIncompleteFile();
            }

        } catch (IOException e) {
            System.out.println("[Task5]: Ошибка при скачивании: " + e.getMessage());
        } finally {
            running.set(false);
        }
    }

    private BufferedInputStream openInputStream() throws IOException {
        URL url = new URL(fileUrl);
        var connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/120.0.0.0 Safari/537.36");

        connection.connect();
        return new BufferedInputStream(connection.getInputStream());
    }

    private void copyStream(BufferedInputStream in, FileOutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = in.read(buffer)) != -1) {
            if (!running.get()) break; // проверка остановки
            out.write(buffer, 0, bytesRead);
        }
    }

    private void deleteIncompleteFile() {
        File file = new File(outputFile);
        if (file.exists() && file.delete()) {
            System.out.println("[Task5]: Неполный файл удалён.");
        }
    }
}