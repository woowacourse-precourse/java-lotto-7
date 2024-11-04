package lotto.presentation.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String purchaseAmountInput = readInputLine();
        validatePurchaseAmountPattern(purchaseAmountInput);
        return purchaseAmountInput;
    }

    public String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String winningNumbersInput = readInputLine();
        validateWinningNumbersPattern(winningNumbersInput);
        return winningNumbersInput;
    }

    public String readBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        String bonusNumberInput = readInputLine();
        validateBonusNumberPattern(bonusNumberInput);
        return bonusNumberInput;
    }

    public void closeConsole() {
        Console.close();
    }

    private String readInputLine() {
        try {
            String inputLine = Console.readLine();
            validateNull(inputLine);
            validateBlank(inputLine);
            return inputLine;
        } catch (IllegalStateException e) {
            throw new IllegalStateException("콘솔에 문제가 생겨 프로그램을 종료합니다. 다시 실행해 주세요.");
        }
    }

    private void validateNull(final String input) {
        if (input == null) {
            throw new IllegalStateException("콘솔에 문제가 생겨 프로그램을 종료합니다. 다시 실행해 주세요.");
        }
    }

    private void validateBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("값을 입력해 주세요.");
        }
    }

    private void validatePurchaseAmountPattern(final String input) {
        if (InputPattern.isInvalidPurchaseAmount(input)) {
            throw new IllegalArgumentException("구입금액 형식에 맞게 다시 입력해 주세요.(ex. \"1000\", \"1,000\", \"1,000원\")");
        }
    }

    private void validateWinningNumbersPattern(final String input) {
        if (InputPattern.isInvalidWinningNumbers(input)) {
            throw new IllegalArgumentException(
                    "당첨 번호는 숫자를 쉼표(,)로 구분해 입력해 주세요. 쉼표 후 공백을 한 번 넣을수도 있습니다. (ex. 1, 2, 3, 4, 5, 6)"
            );
        }
    }

    private void validateBonusNumberPattern(final String input) {
        if (InputPattern.isInvalidBonusNumber(input)) {
            throw new IllegalArgumentException("보너스 번호가 너무 큽니다. 다시 입력해 주세요. (ex. 45)");
        }
    }

}
