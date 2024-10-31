package lotto.view;

import lotto.enums.ViewMessages;

public class OutputView {

    public void printLottoAmount(int lottoAmount) {
        System.out.println(ViewMessages.PRINT_BLANK.getMessage());
        System.out.println(ViewMessages.PRINT_LOTTO_AMOUNT.getMessage(lottoAmount));
    }
}
