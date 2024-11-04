package lotto.model.domain;

import static lotto.constant.ErrorMessages.DUPLICATE_LOTTO_NUMBER_ERROR;
import static lotto.constant.ErrorMessages.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.LottoGameConfig.LOTTO_NUMBERS_COUNT;
import static lotto.constant.LottoGameConfig.SPLIT_DELIMITER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import lotto.util.InputValidator;

public class WinningNumbers {

    private final List<LottoNumber> numbers;

    public WinningNumbers(String numbers) {
        InputValidator.validateInput(numbers);
        validateLottoSize(numbers);
        validateUniqueNumbers(numbers);
        this.numbers = Arrays.stream(numbers.split(SPLIT_DELIMITER))
                .map(LottoNumber::new)
                .toList();
    }

    private void validateLottoSize(String numbers) {
        if (numbers.split(SPLIT_DELIMITER).length != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private void validateUniqueNumbers(String numbers) {
        String[] split = numbers.split(SPLIT_DELIMITER);
        if (new HashSet<>(List.of(split)).size() != split.length) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR);
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
