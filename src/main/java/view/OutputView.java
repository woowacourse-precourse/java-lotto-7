package view;

import model.LottoAmount;

public class OutputView {

    private static final String PRINT_LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public OutputView() {

    }

    public void printLottoAmount(LottoAmount lottoAmount) {
        System.out.println(lottoAmount.getCount() + PRINT_LOTTO_AMOUNT_MESSAGE);
    }
}
