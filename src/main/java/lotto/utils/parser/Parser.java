package lotto.utils.parser;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

public class Parser {
    private final static String COMMA = ",";

    public static List<Integer> parsingNumbers(String winningNumbers) {
        List<Integer> convertedWinningNumbers = new ArrayList<>();
        List<String> splitWinningNumbers = List.of(winningNumbers.split(COMMA));
        for (String number : splitWinningNumbers) {
            try {
                convertedWinningNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw LottoException.from(ErrorMessage.WINNING_LOTTO_IS_NOT_NUMBER);
            }
        }
        return convertedWinningNumbers;
    }

    public static int parsingPurchaseAmount(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.LOTTO_PURCHASE_IS_NOT_NUMBER);
        }
    }

    public static int parsingBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.BONUS_NUMBER_IS_NOT_NUMBER);
        }
    }

    public static List<String> parsingResult(List<Integer> result, double profit) {
        List<String> convertedResult = new ArrayList<>();
        for (int accordCount : result) {
            convertedResult.add(String.valueOf(accordCount));
        }
        convertedResult.add(String.format("%,.1f", profit));
        return convertedResult;
    }
}
