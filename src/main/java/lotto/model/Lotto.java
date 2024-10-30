package lotto.model;

import lotto.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBER.getMessage());}
        if (hasDuplicates(numbers)) {throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());}
        for (Integer num : numbers) {
            if (num < 1 || num > 45) {throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_NUMBER.getMessage());}
        }
    }

    private static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() < list.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("당첨 번호: ");
        for (int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i));
            if (i < numbers.size() - 1) {result.append(", ");}
        }
        return result.toString();
    }
}
