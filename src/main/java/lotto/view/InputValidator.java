package lotto.view;

import static lotto.Constants.LOTTO_PRICE;
import static lotto.Constants.MAX_NUMBER;
import static lotto.Constants.MIN_NUMBER;
import static lotto.Constants.WINNING_NUMBERS_SIZE;

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
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 가능합니다.");
        }
    }

    private void checkMinimumPayment(int payment) {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또는 1개 이상 구매 가능합니다.");
        }
    }

    private void checkDivisibilityByLottoPrice(int payment) {
        if (payment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위만 가능합니다.");
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
            throw new IllegalArgumentException("[ERROR] 번호는 숫자만 가능합니다.");
        }
    }

    public void checkDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호를 입력할 수 없습니다. ");
        }
    }

    public void checkLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 가능합니다.");
        }
    }

    public int getValidBonusNumber(String input, List<Integer> winningNumber) {
        try {
            int bonusNumber = Integer.parseInt(input);
            checkNumberRange(bonusNumber);
            checkDuplicationBetween(winningNumber, bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자만 가능합니다.");
        }
    }

    private void checkDuplicationBetween(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private int checkNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return number;
    }
}
