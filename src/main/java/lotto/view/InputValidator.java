package lotto.view;

import static lotto.Constants.LOTTO_PRICE;
import static lotto.Constants.MAX_NUMBER;
import static lotto.Constants.MIN_NUMBER;
import static lotto.Constants.WINNING_NUMBERS_SIZE;
import static lotto.ErrorConstants.ERROR_BONUS_NUMBER_DUPLICATE;
import static lotto.ErrorConstants.ERROR_DIVISIBLE_BY_LOTTO_PRICE;
import static lotto.ErrorConstants.ERROR_DUPLICATE_NUMBERS_NOT_ALLOWED;
import static lotto.ErrorConstants.ERROR_MINIMUM_LOTTO_PURCHASE;
import static lotto.ErrorConstants.ERROR_NUMBER_RANGE;
import static lotto.ErrorConstants.ERROR_ONLY_NUMBERS_ALLOWED;
import static lotto.ErrorConstants.ERROR_ONLY_NUMBER_ALLOWED;
import static lotto.ErrorConstants.ERROR_WINNING_NUMBERS_SIZE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final String INPUT_DELIMITER = ",";

    public int getValidPurchasedLottoAmount(String input) {
        try {
            int payment = Integer.parseInt(input);
            checkMinimumPayment(payment);
            checkDivisibilityByLottoPrice(payment);
            return payment;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER_ALLOWED);
        }
    }

    private void checkMinimumPayment(int payment) {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException(ERROR_MINIMUM_LOTTO_PURCHASE);
        }
    }

    private void checkDivisibilityByLottoPrice(int payment) {
        if (payment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_DIVISIBLE_BY_LOTTO_PRICE);
        }
    }

    public List<Integer> getValidWinningNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(INPUT_DELIMITER))
            .map(String::trim)
            .map(this::getValidNumber)
            .collect(Collectors.toList());

        checkLottoNumbersLength(numbers);
        checkDuplication(numbers);
        return numbers;
    }

    public int getValidNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            checkNumberRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBERS_ALLOWED);
        }
    }

    public void checkDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS_NOT_ALLOWED);
        }
    }

    public void checkLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_SIZE);
        }
    }

    public int getValidBonusNumber(String input, List<Integer> winningNumber) {
        try {
            int bonusNumber = Integer.parseInt(input);
            checkNumberRange(bonusNumber);
            checkDuplicationBetween(winningNumber, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBERS_ALLOWED);
        }
    }

    private void checkDuplicationBetween(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }

    private int checkNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_RANGE);
        }
        return number;
    }
}
