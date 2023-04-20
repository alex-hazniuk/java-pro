package com.company.lesson15;

public class ArrayValueCalculator {
    private static final int MATRIX_SIZE = 4;
    private final String[][] numbers;

    public ArrayValueCalculator(String[][] numbers) {
        this.numbers = numbers;
    }

    public int doCalc() throws ArraySizeException, ArrayDataException {
        int sum = 0;
        if (numbers != null && numbers.length == MATRIX_SIZE) {
            for (int i = 0; i < MATRIX_SIZE; i++) {
                if (numbers[i] != null && numbers[i].length == MATRIX_SIZE) {
                    for (int j = 0; j < MATRIX_SIZE; j++) {
                        try {
                            sum += Integer.parseInt(numbers[i][j]);
                        } catch (NumberFormatException e) {
                            throw new ArrayDataException("Value is not number in row - "
                                    + i + ", column - " + j);
                        }
                    }
                } else {
                    throw new ArraySizeException("Wrong array size. It must be 4x4!");
                }
            }
        } else {
            throw new ArraySizeException("Not initialized matrix or wrong array size." +
                    " It must be 4x4!");
        }
        return sum;
    }
}
