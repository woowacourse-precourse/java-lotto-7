package lotto;

import java.util.List;

public class Lotto {
    private static final int WINNING_NUMBER_MAX = 45;
    private static final int WINNING_NUMBER_MINIMUM = 1;
    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize();
        validateNumberRepeat();
        validateNumberRange();
    }

    public void validateNumberSize() {
        if (numbers.size() != WINNING_NUMBER_SIZE) {
            ErrorMessageUtil.WINNING_LOTTO_SIZE_ERROR_MESSAGE.errorException();
        }
    }

    public void validateNumberRange() {
        for (int number : numbers) {
            if (number > WINNING_NUMBER_MAX || number < WINNING_NUMBER_MINIMUM) {
                ErrorMessageUtil.WINNING_LOTTO_RANGE_ERROR_MESSAGE.errorException();
            }
        }
    }
    public void validateNumberRepeat(){
        if (numbers.stream().distinct().toList().size() != numbers.size()){
            ErrorMessageUtil.WINNING_LOTTO_REPEAT_ERROR_MESSAGE.errorException();
        }
    }
}
