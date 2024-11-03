package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class ConsoleInput implements Input {

    @Override
    public BigInteger inputPurchaseAmount() {
        String input = readInput("구입금액을 입력해 주세요.");

        if (isInvalidInput(input) || isInvalidAmount(input)) {
            throw new IllegalArgumentException("금액 입력이 올바르지 않습니다.");
        }
        return new BigInteger(input);
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        String input = readInput("당첨 번호를 입력해 주세요.");
        try {
            validateNumbersInput(input);

            return Arrays.stream(input.split(","))
                    .map(String::strip)
                    .map(this::parseInt)
                    .toList();
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("당첨 번호 입력이 올바르지 않습니다.");
        }
    }

    @Override
    public Integer inputBonusNumber() {
        String input = readInput("보너스 번호를 입력해 주세요.");

        if (isInvalidInput(input) || isInvalidNumber(input)) {
            throw new IllegalArgumentException("보너스 번호 입력이 올바르지 않습니다.");
        }
        return Integer.parseInt(input);
    }

    private void validateNumbersInput(String input) {
        if (isInvalidInput(input)) {
            throw new IllegalArgumentException();
        }
    }

    private Integer parseInt(String input) {
        if (isInvalidNumber(input)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    private String readInput(String guideMessage) {
        System.out.println(guideMessage);
        return Console.readLine();
    }

    private boolean isInvalidInput(String input) {
        return input == null || input.isBlank();
    }

    private boolean isInvalidAmount(String input) {
        try {
            new BigInteger(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isInvalidNumber(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
