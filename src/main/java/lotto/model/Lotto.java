package lotto.model;

import lotto.model.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if ( numbers.size() != 6 ) {
            throw new IllegalArgumentException(ErrorMessage.SIX_NUMBERS_ONLY.getMessage());
        }
        for (int inputNumber : numbers) {
            if ( inputNumber > 45 || inputNumber < 1 ) {
                throw new IllegalArgumentException(ErrorMessage.WITHIN_NUMBERS_RANGE.getMessage());
            }
        }
        for ( int i = 0; i < numbers.size(); i++ ) {
            for ( int j = i + 1; j < numbers.size(); j++ ) {
                if ( numbers.get(i).equals(numbers.get(j)) ) {
                    throw new IllegalArgumentException(ErrorMessage.CANNOT_DUPLICATE.getMessage());
                }
            }
        }
    }

    public static int[] stringArrayToIntArray(String[] arr) {
        int[] result = new int[arr.length];
        for ( int i = 0; i < arr.length; i++ ) {
            result[i] = Integer.parseInt(arr[i]);
        }

        return result;
    }

    public static List<Integer> stringArrayToIntList(String[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] intArray = stringArrayToIntArray(arr);
        for (int j : intArray) {
            list.add(j);
        }

        return list;
    }
}
