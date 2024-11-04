package lotto.view;

import static lotto.view.ViewMessages.ENTER_NUMBER_OR_PURCHASES;

import lotto.dto.LottoDraw;

public class OutputView {
    public static void printLottoResult(LottoDraw lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format(
                ENTER_NUMBER_OR_PURCHASES,
                lottoResult.getPurchaseAmount()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(lottoResult.getLottoNumbers());
        System.out.println(stringBuilder);
    }
}
