package lotto.view;

import java.util.HashSet;
import java.util.List;

public class ValidatorOfView {

    static int MINIMUM_BUDGET_UNIT = 1000;
    private final static String ERROR_BUDGET_IS_NOT_GREATER_THAN_ZERO_DESC = "[ERROR] 구매 금액은 자연수여야 합니다.";
    private final static String ERROR_BUDGET_IS_NOT_MULTIPLE_OF_1000= "[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private final static String ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_DESC = "[ERROR] 당첨 번호는 총 6개 입력되어야 합니다.";
    private final static String ERROR_OUT_OF_RANGE_WINNING_NUMBER_DESC =
            "[ERROR] 당첨 번호는 1에서 45 사이의 숫자로 이루어져 있어야 합니다.";
    private final static String ERROR_DUPLICATE_WINNING_NUMBER_DESC =
            "[ERROR] 당첨 번호는 중복되지 않은 서로 다른 6개의 숫자가 입력 되어야 합니다.";
    private final static String ERROR_DUPLICATE_BONUS_NUMBER_DESC = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    private final static int WINNING_NUMBER_SIZE = 6;
    private final static int MINIMUM_WINNING_NUMBER = 1;
    private final static int MAXIMUM_WINNING_NUMBER = 45;

    public static void isValidBudget(int budget) {
        if (!isGreaterThanZero(budget)) {
            throw new IllegalArgumentException(ERROR_BUDGET_IS_NOT_GREATER_THAN_ZERO_DESC);
        }
        if (!isMultipleOfUnitPrice(budget)) {
            throw new IllegalArgumentException(ERROR_BUDGET_IS_NOT_MULTIPLE_OF_1000);
        }
    }

    public static void isValidateWinningNumber(List<Integer> winningNumbers) {
        if (!isCountSix(winningNumbers.size()))
            throw new IllegalArgumentException(ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_DESC);

        if(!isInRange(winningNumbers))
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_WINNING_NUMBER_DESC);

        if(!isDuplicate(winningNumbers))
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBER_DESC);
    }

    public static void isValidateBonusNumber(List<Integer> winningNumbers, int bonusNumber){
        if(isDuplicateOfBonus(winningNumbers,bonusNumber))
            throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS_NUMBER_DESC);
    }

    public static boolean isGreaterThanZero(int budget) {
        return budget > 0;
    }

    public static boolean isMultipleOfUnitPrice(int money) {
        return money % MINIMUM_BUDGET_UNIT == 0;
    }

    public static boolean isCountSix(int count){
        return count == 6;
    }

    public static boolean isInRange(List<Integer> winningNumbers){
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MINIMUM_WINNING_NUMBER || winningNumber > MAXIMUM_WINNING_NUMBER) {
               return false;
            }
        }
        return true;
    }

    public static boolean isDuplicate(List<Integer> winningNumbers){
        return  new HashSet<>(winningNumbers).size() == WINNING_NUMBER_SIZE;
    }

    public static boolean isDuplicateOfBonus(List<Integer> winningNumbers, int bonusNumber){
        return winningNumbers.contains(bonusNumber);
    }

}
