package lotto;

import static lotto.Exception.DONT_ENTER_STRING;
import static lotto.Exception.DONT_NOT_ZERO;
import static lotto.Exception.DUPLICATE_BONUS_WINNING;
import static lotto.Exception.DUPLICATE_WINNING_NUMBER;
import static lotto.Exception.IS_NOT_1000_UNIT;
import static lotto.Exception.NUMBER_RANGE;
import static lotto.Exception.SIX_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Consumer {
    public static String input() {
        return Console.readLine();
    }

    public static int enterPurchaseAmount() {
        String input = input();
        try {
            validateInput(input);
            int purchaseAmount = Integer.parseInt(input);
            isNotZero(purchaseAmount);
            validRange(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterPurchaseAmount();
        }
    }

    public static void validRange(int purchaseAmount) {
        if (purchaseAmount / 1000 < 1 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(IS_NOT_1000_UNIT);
        }
    }

    public static void isNotZero(int purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(DONT_NOT_ZERO);
        }
    }

    public static List<Integer> getWinningNumbers() {
        String input = enterWinningNumbers();
        List<Integer> winningNumbers = converToNumber(input);
        validateCount(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicate(winningNumbers);
        return winningNumbers;
    }

    public static String enterWinningNumbers() {
        return input();
    }

    public static List<Integer> converToNumber(String input) {
        String[] splitNumbers = input.split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number: splitNumbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    public static void validateCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(SIX_WINNING_NUMBER);
        }
    }

    public static void validateRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            validateSingleNumber(number);
        }
    }

    public static void validateDuplicate(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER);
        }
    }

    public static int getBonusNumber() {
        int bonusNumber = Integer.parseInt(input());
        validateSingleNumber(bonusNumber);
        return bonusNumber;
    }

    public static void validateSingleNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBER_RANGE);
        }
    }

    public static void duplicateWithWinnging(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_WINNING);
        }
    }

    public static void validateInput(String input) {
        if (!input.matches("\\d+")) { // 입력이 숫자가 아닐 경우
            throw new IllegalArgumentException(DONT_ENTER_STRING);
        }
    }
}
