package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.WinningCondition;
import lotto.dto.MatchingCountResult;

public class Converter {
    private static String SEPARATOR = ",";

    public static int integerConvert(String number) {
        return Integer.parseInt(number);
    }

    public static List<Integer> winningNumbersConvert(String winningNumbers) {
        String[] splitNumbers = winningNumbers.split(SEPARATOR);
        List<Integer> convertNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            convertNumbers.add(Integer.parseInt(number));
        }
        return convertNumbers;
    }

    public static MatchingCountResult matchingCounterResultConvert(int winningCount, int bonusCount) {
        if (winningCount < 3) {
            return new MatchingCountResult(WinningCondition.NO_MATCH, 0);
        }
        if (winningCount == 3) {
            return new MatchingCountResult(WinningCondition.MATCH_3, winningCount);
        }
        if (winningCount == 4) {
            return new MatchingCountResult(WinningCondition.MATCH_4, winningCount);
        }
        if (winningCount == 5) {
            return checkBonusNumber(winningCount, bonusCount);
        }
        return new MatchingCountResult(WinningCondition.MATCH_6, winningCount);
    }

    private static MatchingCountResult checkBonusNumber(int winningCount, int bonusCount) {
        if (bonusCount == 1) {
            return new MatchingCountResult(WinningCondition.MATCH_5_BONUS, winningCount);
        }
        return new MatchingCountResult(WinningCondition.MATCH_5, winningCount);
    }
}
