package lotto.view;

import static lotto.constant.message.OutputMessage.*;

public class OutputView {

    public static void printLottoCount(Integer lottoCount) {
        System.out.println(PURCHASE_NUMBER_OUTPUT_MESSAGE.getMessage(lottoCount));
    }
}
