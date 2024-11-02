package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.contants.value.LottoValue;
import lotto.contants.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public int payAmount() {
        String purchasePrice = Console.readLine();
        validatePurchasePrice(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

    public List<Integer> prizeNumbers() {
        String prizeNumbers = Console.readLine();
        String[] splitPrizeNumbers = prizeNumbers.split(",");

        return convertToPrizeNumbers(splitPrizeNumbers);
    }

    public int bonusNumber() {
        String bonusNumber = Console.readLine();
        validateLottoNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    public List<Integer> convertToPrizeNumbers(String[] splitPrizeNumbers) {
        List<Integer> winningNumberValues = new ArrayList<>();
        for (String str : splitPrizeNumbers) {
            validateLottoNumber(str);
            winningNumberValues.add(Integer.parseInt(str));
        }

        return winningNumberValues;
    }

    public void validatePurchasePrice(String purchasePrice) {
        try {
            Integer.parseInt(purchasePrice);
            int price = Integer.parseInt(purchasePrice);
            if (price % LottoValue.AMOUNT_UNIT != 0) {
                throw new IllegalArgumentException();
            }
        }catch (NumberFormatException e){
            System.out.println(ErrorMessage.PURCHASE_PRICE);
        }
    }

    public void validateLottoNumber(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.SPILT_EMPTY);
        }
        if (Integer.parseInt(str) < LottoValue.MIN_LOTTO_NUM && Integer.parseInt(str) > LottoValue.MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE);
        }
    }
}
