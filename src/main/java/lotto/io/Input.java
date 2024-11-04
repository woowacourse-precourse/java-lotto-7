package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class Input {
    private final int LOTTO_PRICE = 1000;
    private final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String TARGET = ",";
    private final String REPLACEMENT = "";


    public int getAmount() {
        String amount;

        while (true) {
            System.out.println(INPUT_AMOUNT_MESSAGE);
            try {
                amount = Console.readLine();
                validateAmount(amount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(amount);
    }

    public String getWinningNumber() {
        String winningNumber;

        while (true) {
            printNewLine();
            System.out.println(INPUT_WINNING_NUMBER_MESSAGE);

            try {
                winningNumber = Console.readLine();
                validateWinningNumber(winningNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumber;
    }

    public int getBonusNumber() {
        String bonusNumber;

        while (true) {
            printNewLine();
            System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

            try {
                bonusNumber = Console.readLine();
                validateBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(bonusNumber);
    }

    private void validateAmount(String amount) {
        validateInputExist(amount);
        validateNumber(amount);
        validateDivisibleNumber(amount);
        validatePositiveNumber(amount);
    }

    private void validateWinningNumber(String winningNumber) {
        validateInputExist(winningNumber);

        winningNumber = winningNumber.replace(TARGET, REPLACEMENT);
        validateNumber(winningNumber);
    }

    private void validateBonusNumber(String bonusNumber) {
        validateInputExist(bonusNumber);
        validateNumber(bonusNumber);
        validatePositiveNumber(bonusNumber);
    }

    private void validateInputExist(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_EXIST);
        }
    }

    private void validateDivisibleNumber(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_NUMBER);
        }
    }

    private void validateNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
            }
        }
    }

    private void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER);
        }
    }

    private void printNewLine() {
        System.out.println();
    }
}
