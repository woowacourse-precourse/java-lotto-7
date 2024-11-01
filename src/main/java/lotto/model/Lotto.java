package lotto.model;

import lotto.constant.Constants;
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
        if (numbers.size() != Constants.LOTTO_SIZE.getConstant()) {throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBER.getMessage());}
        if (hasDuplicates(numbers)) {throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());}
        for (Integer num : numbers) {
            if (num < Constants.LOTTO_NUMBER_START_RANGE.getConstant() || num > Constants.LOTTO_NUMBER_END_RANGE.getConstant()) {
                throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_NUMBER.getMessage());
            }
        }
    }

    private static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() < list.size();
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
