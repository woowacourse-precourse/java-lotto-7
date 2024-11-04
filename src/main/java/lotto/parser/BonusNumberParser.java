package lotto.parser;


import lotto.domain.LottoConstants;

import java.util.Set;

public class BonusNumberParser {
    public static int parse(String input, Set<Integer> winningNumbers) {
        validateInput(input);
        return processInput(input, winningNumbers);
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해야 합니다.");
        }
    }

    private static int processInput(String input, Set<Integer> winningNumbers) {
        int bonusNumber = inputToBonusNumber(input);
        validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static int inputToBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. (예: 33)");
        }
    }

    private static void validateBonusNumber(int bonusNumber, Set<Integer> winningNumbers) {
        if (bonusNumber < LottoConstants.MIN_LOTTO_NUMBER || bonusNumber > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력해야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스번호는 당첨번호와 중복될 수 없습니다.");
        }
    }
}
