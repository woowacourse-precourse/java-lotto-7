package lotto.domain;

import static lotto.util.ErrorMessage.*;

import java.util.List;

public class LottoValidator {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    public static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    public static void validateNumber(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateLottoSize(numbers);
        for (int number : numbers) {
            validateLottoNumber(number);
        }
        validateDuplicateNumbers(numbers);
    }

    private static void validateLottoNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    public static void validateWinningLotto(WinningLotto winningLotto) {
        validateLottoNumbers(winningLotto.getLotto().getNumbers());
        validateBonusNumber(winningLotto.getBonusNumber(), winningLotto.getLotto().getNumbers());
    }

    public static void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(INVALID_MONEY.getMessage());
        } else if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY.getMessage());
        }
    }
}