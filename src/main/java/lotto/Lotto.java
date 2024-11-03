package lotto;

import java.util.List;

public class Lotto {
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
        if (numbers.size() != 6) {
            ErrorMessageUtil.WINNING_LOTTO_SIZE_ERROR_MESSAGE.errorException();
        }
    }

    public void validateNumberRange() {
        for (int number : numbers) {
            if (number > 45 || number < 0) {
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
