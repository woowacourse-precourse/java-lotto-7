package lotto.domain;

import lotto.controller.dto.PrizeResultDto;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.exception.ExceptionMessage.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        LottoException.throwIllegalArgumentException(ONLY_LOTTO_SIZE_SIX, !validateLottoSize(numbers));
        LottoException.throwIllegalArgumentException(ONLY_NUMBER_ONE_TO_FORTY_FIVE, !validateLottoNumbers(numbers));
    }

    private boolean validateLottoSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean validateLottoNumbers(List<Integer> numbers) {
        return numbers.stream().allMatch(this::isInRange);
    }

    private boolean isInRange(int number) {
        return number >= 1 && number <= 45;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        try {
            Collections.sort(numbers);
        } catch (UnsupportedOperationException uoe) {
            numbers = new ArrayList<>(numbers);
            Collections.sort(numbers);
        }

        return numbers;
    }
}
