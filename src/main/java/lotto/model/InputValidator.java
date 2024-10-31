package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int ZERO = 0;
    private static final int PURCHASE_BASE_AMOUNT = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public void validateRawInputPurchaseAmount(String rawInput) {
        if (rawInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력되지 않았어요. 다시 입력해주세요.");
        }

        int purchaseAmount = parsePurchaseAmount(rawInput);
        validatePurchaseAmount(purchaseAmount);
    }

    private int parsePurchaseAmount(String rawInput) {
        try {
            return Integer.parseInt(rawInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액에 숫자가 아닌 문자가 포함되어 있어요. 다시 입력해주세요.");
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < ZERO) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 0보다 작아요. 다시 입력해주세요.");
        }
        if (purchaseAmount == ZERO) {
            throw new IllegalArgumentException("[ERROR] 구입금액이 0이에요. 다시 입력해주세요.");
        }
        if (purchaseAmount % PURCHASE_BASE_AMOUNT != ZERO) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 해요. 다시 입력해주세요.");
        }
    }

    public void validateRawInputWinningNumbers(String rawInput) {
        if (rawInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 입력되지 않았어요. 다시 입력해주세요.");
        }

        String[] separatedInputs = rawInput.split(",");
        Set<Integer> winningNumbers = new HashSet<>();

        if (separatedInputs.length != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 해요. 다시 입력해주세요.");
        }

        for (String input : separatedInputs) {
            int number = parseLottoNumber(input.trim());
            if (!winningNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 포함되어 있어요. 다시 입력해주세요.");
            }
        }
    }

    private int parseLottoNumber(String rawInput) {
        try {
            int number = Integer.parseInt(rawInput);
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 해요. 다시 입력해주세요.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 숫자가 아닌 문자가 포함되어 있어요. 다시 입력해주세요.");
        }
    }

    public void validateRawInputBonusNumber(String rawInput, List<Integer> winningNumbers) {
        if (rawInput.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 입력되지 않았어요. 다시 입력해주세요.");
        }

        for (Integer winningNumber : winningNumbers) {
            int number = parseLottoNumber(rawInput.trim());
            if (number == winningNumber) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복될 수 없어요. 다시 입력해주세요.");
            }
        }
    }
}
