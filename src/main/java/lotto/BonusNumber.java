package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BonusNumber {

    public static int inputBonusNumber(List<Integer> winningNumber) {
        try {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String input = Console.readLine();
            return validateBonusNumber(winningNumber, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumber);
        }
    }

    private static int validateBonusNumber(List<Integer> winningNumber, String input) {
        int bonusNumber = parseBonusNumber(input);
        validateBonusRange(bonusNumber);
        validateBonusNotInWinningNumbers(winningNumber, bonusNumber);
        return bonusNumber;
    }

    private static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    private static void validateBonusRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateBonusNotInWinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_WITH_WINNING_NUMBER.getMessage());
        }
    }
}
