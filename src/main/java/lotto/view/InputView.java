package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.error.ErrorMessage;
import java.util.List;

public class InputView {

    private static String DELIMITER = ",";

    private InputView(){
    }

    public static Integer inputBuyAmount() {

        String inputBuyAmount = Console.readLine();

        //정수타입인지 확인
        if (validateBuyAmountNotNumber(inputBuyAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NOTNUMBERBUYAMOUNT.getMessage());
        }

        Integer buyAmount = Integer.parseInt(inputBuyAmount);

        //1000원 단위인지 확인
        if (validateBuyAmountNotPer1000(buyAmount)) {
            throw new IllegalArgumentException(ErrorMessage.NOTPER1000BUYAMOUNT.getMessage());
        }

        return buyAmount;
    }

    private static boolean validateBuyAmountNotNumber(String buyAmountStr) {
        try {
            Integer buyAmount = Integer.parseInt(buyAmountStr);

            if (buyAmount <= 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private static boolean validateBuyAmountNotPer1000(Integer buyAmount) {
        if (buyAmount % 1000 == 0) {
            return false;
        }
        return true;
    }

    public static String inputWinNumbers() {
        String inputWinNumbersStr = Console.readLine();

        if (validateWinNumbersNotDelimiter(inputWinNumbersStr)) {
            throw new IllegalArgumentException(ErrorMessage.NOTDELIMITERWINNUMBERS.getMessage());
        }

        return inputWinNumbersStr;
    }

    private static boolean validateWinNumbersNotDelimiter(String winNumbersStr) {
        if (!winNumbersStr.contains(DELIMITER)) {
            return true;
        }
        return false;
    }

}
