package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static lotto.constants.ViewMessage.LOTTO_PURCHASE_COUNT;
import static lotto.constants.ViewMessage.PROFIT_RATE;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoPurchaseCount(int lottoCount) {
        printMessage(String.format(LOTTO_PURCHASE_COUNT.getText(), lottoCount));
    }

    public static void printLottoProfitRate(String lottoProfitRate) {
        printMessage(String.format(PROFIT_RATE.getText(), lottoProfitRate));
    }

    public static void printLottoListPrompt(List<Lotto> lottos) {
        lottos.forEach(lotto -> printMessage(formatLottoNumbers(lotto)));
    }

    private static String formatLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(joining(", ", "[", "]"));
    }

}