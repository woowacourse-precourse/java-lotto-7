package lotto.model;

import java.util.List;
import lotto.constants.Error_Messages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error_Messages.LOTTO_COUNT_ERROR);
        }
        if (!hasDuplicate(numbers)) {
            throw new IllegalArgumentException(Error_Messages.DUPLICATE_ERROR);
        }
        for (int i = 0; i < 6; i++) {
            numberValid(numbers.get(i));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int numberValid(int number) {
        if (number >= 1 && number <= 45){
            return number;
        }
        else throw new IllegalArgumentException(Error_Messages.NUMBER_RANGE_ERROR);
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        List<Integer> numberSet = numbers.stream().distinct().toList();
        return numberSet.size() != numbers.size();
    }
}