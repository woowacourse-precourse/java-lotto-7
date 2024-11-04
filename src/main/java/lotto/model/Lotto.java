package lotto.model;

import lotto.exception.CustomException;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.service.Service.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoCount(numbers);
        validateDuplicatedWinningNumber(numbers);
    }

    // 로또 번호의 개수 확인
    public void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(CustomException.RESTRICTION_WINNING_NUMBER.getMessage());
        }
    }


    public void validateDuplicatedWinningNumber(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(CustomException.DUPLICATED_WINNING_NUMBER.getMessage());
        }
    }

    public void validateNumberRange(int bonusNumber){
        if(bonusNumber < LOTTO_MIN || bonusNumber > LOTTO_MAX){
            throw new IllegalArgumentException(CustomException.NUMBER_RANGE_LIMITATION.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
