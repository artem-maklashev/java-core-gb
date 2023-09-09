package ru.study.lesson4.exeptions;

public class MyArraySizeException extends MyArrayException {
    private final int rowSize;
    private final int columnSize;

    public MyArraySizeException(String message, int rowSize, int columnSize) {
        super(message);
        this.rowSize = rowSize;
        this.columnSize = columnSize;
    }

    @Override
    public String getMessage(String message) {
        return super.getMessage(message) +
                " Неверно указана размерность массива. " +
                String.format("Необходимо 4х4, фактически %dx%d.", rowSize, columnSize);
    }
}
