package lotto.view;

import java.util.List;
import lotto.domain.LottoProfitRate;
import lotto.domain.Rank;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String LINE_BREAK = "\n";
    private static final String WINNING_DETAIL_MESSAGE = "\n당첨 통계";
    private static final String DIVIDING_LINE = "---";

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
        String message = String.format("%s%d%s", LINE_BREAK, lottoQuantity, PURCHASE_QUANTITY_MESSAGE);
        System.out.println(message);
    }

    public static void printLottoDetails(LottoProfitRate lottoProfitRate){
        System.out.println(WINNING_DETAIL_MESSAGE);
        System.out.println(DIVIDING_LINE);
        for (Rank rank : Rank.values()) {
            System.out.printf("%s (%,d원) - %d개\n", rank.getMessage(), rank.getPrize(), rank.getCount());
        }
        System.out.printf("총 수익률은 %.1f%%입니다.",lottoProfitRate.getLottoProfitRate());
    }
}
