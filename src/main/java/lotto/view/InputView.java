package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.CustomLottoException;
import lotto.exception.ErrorMessage;

public class InputView {
    public static int inputLottoAmount(){
        String inputAmount = Console.readLine();
        return convertInputAmountToInt(inputAmount);
    }

    private static int convertInputAmountToInt(String inputAmount) {
        try {
            int intAmount = Integer.parseInt(inputAmount);
            long longAmount = convertInputAmountToLong(inputAmount);
            validateAmountEquality(intAmount, longAmount);
            return intAmount;
        } catch (NumberFormatException exception) {
            throw new CustomLottoException(ErrorMessage.NOT_NUMBER);
        }
    }

    private static long convertInputAmountToLong(String inputAmount) {
        try {
            return Long.parseLong(inputAmount);
        } catch (NumberFormatException exception) {
            throw new CustomLottoException(ErrorMessage.NOT_NUMBER);
        }
    }

    private static void validateAmountEquality(int intAmount, long longAmount) {
        if (intAmount != longAmount) {
            throw new CustomLottoException(ErrorMessage.NOT_INTEGER_NUMBER);
        }
    }
}