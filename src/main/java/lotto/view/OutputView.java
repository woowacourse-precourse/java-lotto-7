package lotto.view;

import static lotto.constants.OutputMessage.DIVIDING_LINE;
import static lotto.constants.OutputMessage.LINE_BREAK;
import static lotto.constants.OutputMessage.LOTTO_DETAIL_FORMAT;
import static lotto.constants.OutputMessage.PROFIT_RATE_MESSAGE;
import static lotto.constants.OutputMessage.PURCHASE_QUANTITY_MESSAGE;
import static lotto.constants.OutputMessage.WINNING_DETAIL_MESSAGE;

import java.util.List;
import lotto.domain.LottoProfitRate;
import lotto.domain.Rank;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    public static void displayPurchasedLottoNumbers(Lottos lottos) {
        printPurchaseQuantity(lottos.getLottoCount());
        printLottoNumbers(lottos.getLottos());
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static void printPurchaseQuantity(int lottoQuantity) {
        String message = String.format("%s%d%s", LINE_BREAK.getMessage(), lottoQuantity, PURCHASE_QUANTITY_MESSAGE.getMessage());
        System.out.println(message);
    }

    public static void printLottoDetails(LottoProfitRate lottoProfitRate){
        System.out.println(WINNING_DETAIL_MESSAGE.getMessage());
        System.out.println(DIVIDING_LINE.getMessage());
        for (Rank rank : Rank.values()) {
            System.out.printf(LOTTO_DETAIL_FORMAT.getMessage(), rank.getMessage(), rank.getPrize(), rank.getCount());
        }
        System.out.printf(PROFIT_RATE_MESSAGE.getMessage(),lottoProfitRate.getLottoProfitRate());
    }
}
