package lotto.view;

import lotto.enums.ViewMessages;

public class OutputView {

    public void printLottoAmount(int lottoAmount) {
        System.out.println();
        System.out.println(ViewMessages.PRINT_LOTTO_AMOUNT.getMessage(lottoAmount));
    }

    public void printErrorMessage(String error) {
        System.err.println(error);
    }
}
