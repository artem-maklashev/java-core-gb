package ru.study.lesson2;

import java.util.Random;
import java.util.Scanner;

/**
 * Класс, реализующий игру в крестики-нолики
 * Человек против компьютера
 */
public class Main {

    private static final int ROW_COUNT = 3;
    private static final int COLUMN_COUNT = 4;
    private static final int WIN_COMBINATION = 3;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] fields;

    private static char DOT_HUMAN = 'X';
    private static char DOT_AI = '0';
    private static char DOT_EMPTY = '#';

    /**
     * Точка входа в программу
     * Вызов основных методов
     *
     * @param args
     */
    public static void main(String[] args) {
        initialize();
        do {
            printFields();
            humanTurn();
            if (checkGameState(DOT_HUMAN, "Победа за кожаным")) {
                printFields();
                break;
            }
            botTurn();
            if (checkGameState(DOT_AI, "Победа за искуственным интелектом")) {
                printFields();
                break;
            }
        } while (true);
    }

    /**
     * Инициализация игрового поля
     */
    private static void initialize() {
        fields = new char[ROW_COUNT][COLUMN_COUNT];
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                fields[i][j] = '#';
            }
        }
    }

    /**
     * Вывод игрового поля вида
     * *_1_2_3_4_
     * 1|#|#|#|#|
     * 2|#|#|#|#|
     * 3|#|#|#|#|
     */
    private static void printFields() {
        System.out.print("*");
        for (int i = 0; i < COLUMN_COUNT * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "_" : i / 2 + 1);
        }
        for (int i = 0; i < ROW_COUNT * 2; i++) {
            if (i % 2 == 0) {
                System.out.print("\n" + (i / 2 + 1));
                for (int j = 0; j < COLUMN_COUNT * 2 + 1; j++) {
                    System.out.print((j % 2 == 0) ? "|" : fields[i / 2][j / 2]);
                }
            }
        }
        System.out.println();
    }

    /**
     * Реализация хода игрока
     */
    private static void humanTurn() {
        int rowIndex, columnIndex;
        do {
            System.out.println("Введите координаты ячейки");
            while (true) {
                System.out.printf("Введите номер столбца (от 1 до %d): ", COLUMN_COUNT);
                if (scanner.hasNextInt()) {
                    columnIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Введено не корректное число. Повторите ввод.");
                    scanner.nextLine();
                }
            }
            while (true) {
                System.out.printf("Введите номер строки (от 1 до %d): ", ROW_COUNT);
                if (scanner.hasNextInt()) {
                    rowIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Введено не корректное число. Повторите ввод.");
                    scanner.nextLine();
                }
            }

        } while (!isDotValid(columnIndex, rowIndex) || !isDotEmpty(columnIndex, rowIndex));
        fields[rowIndex][columnIndex] = DOT_HUMAN;
    }

    /**
     * Реализация хода бота
     */
    private static void botTurn() {
        if (!dotSubstitution(DOT_AI, DOT_AI)) {
            if (!dotSubstitution(DOT_HUMAN, DOT_AI)) {
                int row, column;
                while (true) {
                    row = random.nextInt(ROW_COUNT);
                    column = random.nextInt(COLUMN_COUNT);
                    if (fields[row][column] == DOT_EMPTY) {
                        fields[row][column] = DOT_AI;
                        return;
                    }
                }
            }
        }

    }

    /**
     * Перебор возможных исходов по всему полю. В случае выигрышной комбинации
     * подставляется значение игрока для блокировки выигрыша противника
     *
     * @param opponent символ фишки противника
     * @param player   символ фишки игрока
     * @return возвращает истину если произведена подстановка, ложь если подстановки не было
     */
    private static boolean dotSubstitution(char opponent, char player) {
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                if (fields[i][j] == DOT_EMPTY) {
                    fields[i][j] = opponent;
                    if (checkWin(opponent)) {
                        fields[i][j] = player;
                        return true;
                    } else {
                        fields[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Метод проверки данных по координатам ячейки введенных игроком
     *
     * @param columnIndex индекс колонки
     * @param rowIndex    индекс строки
     * @return Истина если данные корректны
     */
    private static boolean isDotValid(int columnIndex, int rowIndex) {
        return (columnIndex >= 0 && columnIndex < COLUMN_COUNT) && (rowIndex >= 0 && rowIndex < ROW_COUNT);
    }

    /**
     * Проверка я чейки на то что она не занята
     *
     * @param columnIndex индекс колонки
     * @param rowIndex    индекс строки
     * @return Истина в случае пустой ячейки
     */
    private static boolean isDotEmpty(int columnIndex, int rowIndex) {
        return (fields[rowIndex][columnIndex] == DOT_EMPTY);
    }

    /**
     * Проверка статуса игры
     *
     * @param c символ по которому проверяются комбинации на выигрыш
     * @param s выводимая строка в случае победы
     * @return Истина если победа или ничья
     */
    private static boolean checkGameState(char c, String s) {
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    /**
     * Проверка на ничью
     *
     * @return Истина если ничья
     */
    private static boolean checkDraw() {
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                if (fields[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    /**
     * Проверка на победу
     *
     * @param c символ по которому проверяются выигрышные комбинации
     * @return Истина если победа
     */
    private static boolean checkWin(char c) {
        return horisontalWin(c) || verticalWin(c) || diagonalWin(c);
    }

    /**
     * Проверка выигрышных комбинаций по диагоналям
     *
     * @param symbol символ по которому проверяются выигрышные комбинации
     * @return Истина в случае нахождения выигрышной комбинации
     */
    private static boolean diagonalWin(char symbol) {
        for (int i = 0; i <= ROW_COUNT - WIN_COMBINATION; i++) {
            for (int j = 0; j <= COLUMN_COUNT - WIN_COMBINATION; j++) {
                boolean found = true;
                for (int k = 0; k < WIN_COMBINATION; k++) {
                    if (fields[i + k][j + k] != symbol) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }

        for (int i = 0; i <= ROW_COUNT - WIN_COMBINATION; i++) {
            for (int j = WIN_COMBINATION - 1; j < COLUMN_COUNT; j++) {
                boolean found = true;
                for (int k = 0; k < WIN_COMBINATION; k++) {
                    if (fields[i + k][j - k] != symbol) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Проверка на наличие выигрышных комбинаций по вертикали
     *
     * @param c символ для проверки выигрышных комбинаций
     * @return Истина в случае нахождения выигрышной комбинации
     */
    private static boolean verticalWin(char c) {
        int count;
        for (int i = 0; i < COLUMN_COUNT; i++) {
            count = 0;
            for (int j = 0; j < ROW_COUNT; j++) {
                if (fields[j][i] == c) {
                    count++;
                    if (count == WIN_COMBINATION) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    /**
     * Проверка на наличие выигрышных комбинаций по горизонтали
     *
     * @param c символ для проверки выигрышных комбинаций
     * @return Истина в случае нахождения выигрышной комбинации
     */
    private static boolean horisontalWin(char c) {
        int count;
        for (int i = 0; i < ROW_COUNT; i++) {
            count = 0;
            for (int j = 0; j < COLUMN_COUNT; j++) {
                if (fields[i][j] == c) {
                    count++;
                    if (count == WIN_COMBINATION) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }
}