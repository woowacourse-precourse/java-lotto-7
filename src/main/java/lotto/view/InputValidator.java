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


    public void checkLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 가능합니다.");
        }
    }
    private int checkNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return number;
    }
}
