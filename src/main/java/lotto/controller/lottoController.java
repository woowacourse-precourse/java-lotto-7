package lotto.controller;

import static lotto.view.input.printOutputTotalCount;

import lotto.constants.Error_Messages;

public class lottoController {
    public static int checkTotalAmountIfValid(int totalAmount){
        if (totalAmount <= 0 || totalAmount < 1000)
            throw new IllegalArgumentException(Error_Messages.INPUT_NOT_POSITIVE_INT);
        else if (totalAmount < 1000) {
            throw new IllegalArgumentException(Error_Messages.INPUT_TOTAL_AMOUNT_NOT_LARGER_THAN_1000);
        } else if (totalAmount % 1000 == 0) {
            return totalAmount / 1000;
        }
        else {
            throw new IllegalArgumentException(Error_Messages.INPUT_ERROR);
        }
    }
}
