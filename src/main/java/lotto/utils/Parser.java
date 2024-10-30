package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.exception.ErrorMessage;
import lotto.validator.exception.LottoException;

public class Parser {

    public static List<Integer> parsingNumbers(String winningNumbers) {
        List<Integer> convertedWinningNumbers = new ArrayList<>();
        List<String> splitWinningNumbers = List.of(winningNumbers.split(","));
        for(String number : splitWinningNumbers) {
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
}
