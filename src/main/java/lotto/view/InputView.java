package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.contants.value.LottoValue;
import lotto.contants.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int purchasePrice() {
        String purchasePrice = Console.readLine();
        int priceValue = Integer.parseInt(purchasePrice);
        validatePurchasePrice(priceValue);

        return priceValue;
    }

    public List<Integer> winningNumbers() {
        String winningNumbers = Console.readLine();
        String[] splitWinningNumbers = winningNumbers.split(",");

        return convertToWinningNumbers(splitWinningNumbers);
    }

    public List<Integer> convertToWinningNumbers(String[] splitWinningNumbers) {
        List<Integer> winningNumberValues = new ArrayList<>();
        for (String str : splitWinningNumbers) {
            validateWinningNumber(str);
            winningNumberValues.add(Integer.parseInt(str));
        }

        return winningNumberValues;
    }

    public void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % LottoValue.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_PRICE);
        }
    }

    public void validateWinningNumber(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.SPILT_EMPTY);
        }
        if (Integer.parseInt(str) < 1 && Integer.parseInt(str) > 45) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE);
        }
    }
}
