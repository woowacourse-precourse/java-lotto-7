package lotto.util;

import lotto.constant.LottoConstants;
import java.util.List;

public class InputValidator {
    public void validatePurchaseAmount(String input) {
        validateNotNullOrEmpty(input, "구입 금액");
        validateNumeric(input, "구입 금액");

        int amount = Integer.parseInt(input);
        validateAmount(amount);
    }

    public void validateWinningNumbers(String input) {
        validateNotNullOrEmpty(input, "당첨 번호");
        if (!input.matches(LottoConstants.WINNING_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException(
                    "당첨 번호는 1부터 45 사이의 숫자여야 하며, 쉼표로 구분되어야 합니다.");
        }

        List<Integer> numbers = NumberParser.parseNumbers(input);
        validateLottoNumbers(numbers);
    }

    public void validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateNotNullOrEmpty(input, "보너스 번호");
        validateNumeric(input, "보너스 번호");

        int bonusNumber = Integer.parseInt(input);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicate(bonusNumber, winningNumbers);
    }

    private void validateAmount(int amount) {
        if (amount < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    String.format("구입 금액은 %d원 이상이어야 합니다.", LottoConstants.LOTTO_PRICE));
        }
        if (amount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(
                    String.format("구입 금액은 %d원 단위여야 합니다.", LottoConstants.LOTTO_PRICE));
        }
    }

    private void validateBonusNumberRange(int number) {
        if (number < LottoConstants.MIN_LOTTO_NUMBER ||
                number > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    "보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumberDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
    }

    private void validateNotNullOrEmpty(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("%s을(를) 입력해 주세요.", fieldName));
        }
    }

    private void validateNumeric(String input, String fieldName) {
        if (!input.trim().matches(LottoConstants.NUMBER_PATTERN)) {
            throw new IllegalArgumentException(
                    String.format("%s는 숫자여야 합니다.", fieldName));
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n ->
                n < LottoConstants.MIN_LOTTO_NUMBER || n > LottoConstants.MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(
                    "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}