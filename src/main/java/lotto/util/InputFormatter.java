package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoConstant;

public class InputFormatter {

    private static final String DELIMITER = ",";

    public int formatMoneyInput(String moneyInput) {
        validateMoneyInput(moneyInput);
        return Integer.parseInt(moneyInput);
    }

    public List<Integer> formatWinningNumbersInput(String winningNumbersInput) {
        validateWinningNumbersInput(winningNumbersInput);
        return formatWinningNumbers(winningNumbersInput);
    }

    public int formatBonusNumberInput(String bonusNumberInput) {
        validateBonusNumberInput(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    private void validateMoneyInput(String moneyInput) {
        try {
            Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 정수여야 합니다.");
        }

        if (Integer.parseInt(moneyInput) <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1원 이상이어야 합니다.");
        }

        if ((Integer.parseInt(moneyInput) % LottoConstant.MONEY_UNIT.getNumber()) != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
    }

    private void validateWinningNumbersInput(String winningNumbersInput) {
        try {
            formatWinningNumbers(winningNumbersInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력 양식이 잘못되었습니다.");
        }
    }

    private void validateBonusNumberInput(String bonusNumberInput) {
        try {
            Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자의 형식이 잘못되었습니다.");
        }
    }

    private List<Integer> formatWinningNumbers(String winningNumbersInput) {
        return Arrays.stream(winningNumbersInput.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
