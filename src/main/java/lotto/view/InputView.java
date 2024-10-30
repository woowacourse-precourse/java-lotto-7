package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private final static int MONEY_UNIT = 1000;
    private final static int LOTTO_NUMBER_UPPER_BOUND = 45;
    private final static int LOTTO_NUMBER_LOWER_BOUND = 1;

    public int getMoneyInput() {
        String moneyInput = Console.readLine();
        validateMoneyInput(moneyInput);
        return Integer.parseInt(moneyInput);
    }

    public List<Integer> getWinnerNumbersInput() {
        String winnerNumbersInput = Console.readLine();
        validateWinnerNumbersInput(winnerNumbersInput);
        return formatWinnerNumbers(winnerNumbersInput);
    }

    public int getBonusNumberInput() {
        String bonusNumberInput = Console.readLine();
        validateBonusNumberInput(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    private void validateMoneyInput(String moneyInput) {
        validateMoneyFormat(moneyInput);
        validateMoneyPositive(moneyInput);
        validateMoneyUnit(moneyInput);
    }

    private void validateWinnerNumbersInput(String winnerNumbersInput) {
        validateWinnerNumbersFormat(winnerNumbersInput);
    }

    private void validateBonusNumberInput(String bonusNumberInput) {
        validateBonusNumberFormat(bonusNumberInput);
        validateBonusNumberRange(bonusNumberInput);
    }

    private void validateMoneyFormat(String moneyInput) {
        try {
            Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 정수여야 합니다.");
        }
    }

    private void validateMoneyPositive(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1원 이상이어야 합니다.");
        }
    }

    private void validateMoneyUnit(String moneyInput) {
        int money = Integer.parseInt(moneyInput);
        if ((money % MONEY_UNIT) != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위여야 합니다.");
        }
    }

    private void validateWinnerNumbersFormat(String winnerNumbersInput) {
        try {
            List<String> winnerNumbers = Arrays.asList(winnerNumbersInput.split(","));
            for (String winnerNumber : winnerNumbers) {
                Integer.parseInt(winnerNumber);
            }
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력 양식이 잘못되었습니다.");
        }
    }

    private List<Integer> formatWinnerNumbers(String winnerNumbersInput) {
        return Arrays.stream(winnerNumbersInput.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateBonusNumberFormat(String bonusNumberInput) {
        try {
            Integer.parseInt(bonusNumberInput);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자의 형식이 잘못되었습니다.");
        }
    }

    private void validateBonusNumberRange(String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        if (bonusNumber < LOTTO_NUMBER_LOWER_BOUND || bonusNumber > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자의 범위가 1~45를 벗어납니다.");
        }
    }
}
