package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.GlobalConstant;
import lotto.constant.WinningCondition;

public class Converter {

    public static int integerConvert(String number) {
        return Integer.parseInt(number);
    }

    public static List<Integer> winningNumbersConvert(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(GlobalConstant.SEPARATOR.value());
        List<Integer> convertNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            convertNumbers.add(Integer.parseInt(number));
        }
        return convertNumbers;
    }

    public static WinningCondition matchingCounterResultConvert(int winningCount, int bonusCount) {
        if (winningCount == 3) {
            return WinningCondition.MATCH_3;
        }
        if (winningCount == 4) {
            return WinningCondition.MATCH_4;
        }
        if (winningCount == 5) {
            return checkBonusNumber(bonusCount);
        }
        if (winningCount == 6) {
            return WinningCondition.MATCH_6;
        }
        return WinningCondition.NO_MATCH;
    }

    private static WinningCondition checkBonusNumber(int bonusCount) {
        if (bonusCount == 1) {
            return WinningCondition.MATCH_5_BONUS;
        }
        return WinningCondition.MATCH_5;
    }
}
