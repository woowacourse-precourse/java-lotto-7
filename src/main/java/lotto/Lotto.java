package lotto;

import static lotto.view.input.InputError.LOTTO_NUMBER_LENGTH_INVALID;

import java.util.List;
import lotto.view.input.InputError;
import lotto.view.input.InvalidInputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoRange(numbers);
        validateDuplicate(numbers);
    }


    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InvalidInputException(InputError.LOTTO_NUMBER_LENGTH_INVALID);
        }
    }
    private void validateLottoRange(List<Integer> numbers) {
        if (isLottoRange(numbers)) {
            throw new InvalidInputException(InputError.LOTTO_NUMBER_RANGE_INVALID);
        }
    }

    private boolean isLottoRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

    private void validateDuplicate(List<Integer> numbers){
        if(containsDuplicates(numbers)){
            throw new InvalidInputException(InputError.LOTTO_NUMBER_CANNOT_DUPLICATE);
        }
    }
    private boolean containsDuplicates(List<Integer> numbers){
        return numbers.stream().distinct().count() == numbers.size();
    }

}
