package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String WINNING_NUMBERS_REGEX = "^([1-9]|[1-3][0-9]|4[0-5])(,([1-9]|[1-3][0-9]|4[0-5]))*$";
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int REQUIRED_NUMBER_COUNT = 6;

    public void validatePurchaseAmount(String input) {
        validateNotNullOrEmpty(input, "구입 금액");
        validateNumeric(input, "구입 금액");

        int amount = Integer.parseInt(input);
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 " + LOTTO_PRICE + "원 단위여야 합니다.");
        }
        if (amount > Integer.MAX_VALUE - LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액이 너무 큽니다.");
        }
    }

    public void validateWinningNumbers(String input) {
        validateNotNullOrEmpty(input, "당첨 번호");
        if (!input.matches(WINNING_NUMBERS_REGEX)) {
            throw new IllegalArgumentException("당첨 번호는 1부터 45 사이의 숫자여야 하며, 쉼표로 구분되어야 합니다.");
        }

        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateNumberCount(numbers);
        validateNoDuplicates(numbers);
    }

    public void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateNotNullOrEmpty(input, "보너스 번호");
        validateNumeric(input, "보너스 번호");

        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateNotNullOrEmpty(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + "을(를) 입력해 주세요.");
        }
    }

    private void validateNumeric(String input, String fieldName) {
        if (!input.trim().matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(fieldName + "는 숫자여야 합니다.");
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
