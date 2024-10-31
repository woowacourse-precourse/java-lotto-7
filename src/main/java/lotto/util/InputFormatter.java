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
        validateWinnerNumbersInput(winningNumbersInput);
        return formatWinnerNumbers(winningNumbersInput);
    }

    public int formatBonusNumberInput(String bonusNumberInput) {
        validateBonusNumberInput(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    private void validateMoneyInput(String moneyInput) {
        validateMoneyFormat(moneyInput);
        validateMoneyIsPositive(moneyInput);
        validateMoneyUnit(moneyInput);
    }

    private void validateWinnerNumbersInput(String winnerNumbersInput) {
        try {
            List<String> winnerNumbers = Arrays.asList(winnerNumbersInput.split(DELIMITER));
            for (String winnerNumber : winnerNumbers) {
                Integer.parseInt(winnerNumber);
            }
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

    private void validateMoneyFormat(String moneyInput) {
        try {
            Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 정수여야 합니다.");
        }
    }

    private void validateMoneyIsPositive(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1원 이상이어야 합니다.");
        }
    }

    private void validateMoneyUnit(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        if ((money % LottoConstant.MONEY_UNIT.getNumber()) != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
    }

    private List<Integer> formatWinnerNumbers(String winnerNumbersInput) {
        return Arrays.stream(winnerNumbersInput.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
