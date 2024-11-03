package lotto.validation;

import java.util.HashSet;
import lotto.exception.WinBonusException;
import java.util.List;

public class WinBonusValidation {

    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 45;
    private static final int WINNING_SIZE = 6;
    private static final int COUNT_ZERO = 0;

    public static void winningValidation(List<String> winningNumbers) {
        for (String number : winningNumbers) {
            int num = isNumber(number);
            isInRange(num);
        }
        isSize(winningNumbers);
        isDuplicate(winningNumbers);
    }

    private static int isNumber(String number) {
        int num = COUNT_ZERO;
        try {
            num = Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            WinBonusException.exceptionWinningNumber();
        }
        return num;
    }

    private static void isInRange(int num) {
        if (num < NUM_MIN || num > NUM_MAX) {
            WinBonusException.exceptionWinningRange();
        }
    }

    private static void isSize(List<String> winningNumbers) {
        if (winningNumbers.size() != WINNING_SIZE) {
            WinBonusException.exceptionWinningSize();
        }
    }

    private static void isDuplicate(List<String> winningNumbers) {
        HashSet<String> numberSet = new HashSet<>();
        for (String num : winningNumbers) {
            numberSet.add(num);
        }
        if (numberSet.size() != WINNING_SIZE) {
            WinBonusException.exceptionWinningDuplicate();
        }
    }

    public static void bonusValidation(String bonus, List<Integer> winNumbers) {
        int numBonus = isNumberBonus(bonus);
        isInRangeBonus(numBonus);
        for (int num : winNumbers) {
            isDuplicateBonus(num, numBonus);
        }
    }

    private static int isNumberBonus(String bonus) {
        int num = COUNT_ZERO;
        try {
            num = Integer.parseInt(bonus);
        } catch (IllegalArgumentException e) {
            WinBonusException.exceptionBonusNumber();
        }
        return num;
    }

    private static void isInRangeBonus(int numBonus) {
        if (numBonus < NUM_MIN || numBonus > NUM_MAX) {
            WinBonusException.exceptionBonusRange();
        }
    }

    private static void isDuplicateBonus(int num, int numBonus) {
        if (num == numBonus) {
            WinBonusException.exceptionBonusDuplicate();
        }
    }

}
