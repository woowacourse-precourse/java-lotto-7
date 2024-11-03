package lotto.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    public long getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String userInput = Console.readLine().trim();

                validateUserInput(userInput);

                return Long.parseLong(userInput);

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력 값이 너무 큽니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateUserInput(String input) {
        validateNotEmpty(input);
        validateIsNumber(input);

        long value = Long.parseLong(input);
        validatePositive(value);
        validateThousandUnit(value);
    }

    private void validateNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 비어 있습니다.");
        }
    }

    private void validateIsNumber(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }
    }

    private void validatePositive(long value) {
        if (!isPositive(value)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 0보다 커야 합니다.");
        }
    }

    private void validateThousandUnit(long value) {
        if (!isThousandUnit(value)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 숫자여야 합니다.");
        }
    }

    private boolean isNumber(String input) {
        return input.matches("\\d+");
    }

    private boolean isPositive(long value) {
        return value > 0;
    }

    private boolean isThousandUnit(long value) {
        return value % 1000 == 0;
    }
}
