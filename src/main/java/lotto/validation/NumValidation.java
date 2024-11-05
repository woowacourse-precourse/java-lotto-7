package lotto.validation;

import lotto.view.Output;
import lotto.run.Lotto;
import java.util.List;
import java.util.stream.Stream;

public class NumValidation {
    private static final String CHECK_NUMERIC = "숫자만 입력할 수 있습니다.";
    private static final String CHECK_BONUS_NUM = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public static boolean checkWinNum(String winNums) throws IllegalArgumentException {
        try {
            numberIsNumeric(winNums);
            isValidToLotto(winNums);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean checkBonusNum(String bonusNum, List<Integer> winNums) throws IllegalArgumentException {
        try {
            numberIsNumeric(bonusNum);
            isNotWinningNumber(bonusNum, winNums);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void isNotWinningNumber(String inputBonusNum, List<Integer> winNums) throws IllegalArgumentException {
        int bonusNum = Integer.parseInt(inputBonusNum);
        if (winNums.contains(bonusNum)) {
            throw new IllegalArgumentException(CHECK_BONUS_NUM);
        }
    }

    private static void isValidToLotto(String winNums) throws IllegalArgumentException {
        List<Integer> winNumList = Stream.of(winNums.split(","))
                .map(Integer::parseInt)
                .toList();
        new Lotto(winNumList);
    }

    private static void numberIsNumeric(String inputNum) throws IllegalArgumentException {
        String[] splitNum = inputNum.split(",");
        for (String num : splitNum) {
            if (!num.matches("^[0-9]+$")) {
                throw new IllegalArgumentException(CHECK_NUMERIC);
            }
        }
    }
}