package ru.study.lesson4.exeptions;

public class MyArrayDataException extends MyArrayException {
    private String value;
    private int rowIndex;
    private int columnIndex;

    public MyArrayDataException(String message, String value, int rowIndex, int columnIndex) {
        super(message);
        this.value = value;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    @Override
    public String getMessage(String message) {
        return super.getMessage(message) + String.format(" В массиве могут быть только числа. Присутствует %s в строке %d столбец %d", value, rowIndex + 1, columnIndex + 1);
    }
}
