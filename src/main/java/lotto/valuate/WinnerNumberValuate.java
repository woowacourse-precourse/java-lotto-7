package lotto.valuate;

import static lotto.constant.LottoErrorConstant.ERROR_WINNING_NUMBER_NO_WHITESPACE;
import static lotto.constant.LottoErrorConstant.ERROR_WINNING_NUMBER_ONLY_NUMBERS;

public class WinnerNumberValuate{

    public static void isValidNumber(String winningNumber) {
        isEmpty(winningNumber);
        try {
            Integer.parseInt(winningNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_ONLY_NUMBERS);
        }
    }

    public static void isEmpty(String winningNumber){
        if (winningNumber == "") {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBER_NO_WHITESPACE);
        }
    }


}
