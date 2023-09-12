package ru.study.lesson5;

import java.io.*;


public class Backup {
    public static void main(String[] args) {
        File sourceDirectoryPath = new File("./src/main/java/ru/study");
        File backupDirectoryPath = new File("./backup");
        try {
            backupDirectoryPath.mkdirs();
            backupFiles(sourceDirectoryPath, backupDirectoryPath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка при создании копии");
        }
    }

    private static void backupFiles(File file, File destinationDir) throws IOException {
        if (file.isDirectory()) {
            if (!destinationDir.exists()){
                destinationDir.mkdir();
            }

            File[] subs = file.listFiles();

                for (File sub : subs) {
                    if (sub.isDirectory()){
                        File backupFile = new File(destinationDir, sub.getName());
                        File sourceFile = sub;
                        backupFiles(sourceFile, backupFile);
                    } else {
                        File backupFile = new File(destinationDir, sub.getName());
                        File sourceFile = new File(file, sub.getName());
                        copyFiles(sourceFile, backupFile);
                    }
                }

        }
    }

    private static void copyFiles(File f, File backupFile) throws IOException {
        try (InputStream in = new FileInputStream(f);
             OutputStream out = new FileOutputStream(backupFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }
}