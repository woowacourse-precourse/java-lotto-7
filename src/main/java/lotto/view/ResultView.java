package lotto.view;

import lotto.message.ResultMessage;

public class ResultView {

    public static void displayLottoResult() {
        System.out.println("\n" + ResultMessage.DISPLAY_LOTTO_RESULT.getMessage());
        System.out.println(ResultMessage.DISPLAY_LOTTO_RESULT_BOUNDARY.getMessage());
    }
}
