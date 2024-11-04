package lotto.view;

import static lotto.view.ViewMessages.ENTER_NUMBER_OR_PURCHASES;
import static lotto.view.ViewMessages.ENTER_PROFIT_MESSAGES;
import static lotto.view.ViewMessages.ENTER_STATISTICS;
import static lotto.view.ViewMessages.SEPARATOR;

import lotto.dto.LottoDraw;
import lotto.dto.LottoResult;

public class OutputView {
    public static void printLottoDraw(LottoDraw lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format(
                ENTER_NUMBER_OR_PURCHASES,
                lottoResult.getPurchaseAmount()));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(lottoResult.getLottoNumbers());
        System.out.println(stringBuilder);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(ENTER_STATISTICS);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(lottoResult.getWinningResult());
        stringBuilder.append(String.format(ENTER_PROFIT_MESSAGES, lottoResult.getReturnOnInvestment()));
        System.out.println(stringBuilder);
    }
}
