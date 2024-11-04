package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class Input {
    private final int LOTTO_PRICE = 1000;
    private final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public int getAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);

        String amount = Console.readLine();
        validateAmount(amount);

        return Integer.parseInt(amount);
    }

    public String getWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);

        String winningNumber = Console.readLine();
        validateWinningNumber(winningNumber);

        return winningNumber;
    }

    public int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);

        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);

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

        winningNumber = winningNumber.replace(",", "");
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
        for (char c : input.toCharArray()){
            if (!Character.isDigit(c)){
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
            }
        }
    }

    private void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER);
        }
    }
}
