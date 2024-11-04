package lotto.view;

import static lotto.view.message.OutputViewMessage.*;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    private final StringBuilder sb = new StringBuilder();


    public OutputView() {}

    public void printPurchaseLottoCount(int count) {
        sb.setLength(0);
        sb.append(count).append(PRINT_PURCHASE_LOTTO_COUNT.message);
        System.out.println(sb);
    }

    public void printPurchaseLottos(Lottos lottos) {
        sb.setLength(0);
        for (Lotto lotto : lottos.getLottos()) {
            sb.append(lotto.toString()).append("\n");
        }
        System.out.println(sb);
    }

    public void printWinningLotto(Lottos lottos) {
        sb.setLength(0);
        sb.append(PRINT_WINNING_LOTTO.message);
        int[] counts = lottos.getWinningLottoCounts();
        sb.append(THREE_MATCH_PRICE.message).append(counts[3]).append(SUFFIX.message);
        sb.append(FOUR_MATCH_PRICE.message).append(counts[4]).append(SUFFIX.message);
        sb.append(FIVE_MATCH_PRICE.message).append(counts[5]).append(SUFFIX.message);
        sb.append(FIVE_BONUS_MATCH_PRICE.message).append(counts[7]).append(SUFFIX.message);
        sb.append(SIX_BONUS_MATCH_PRICE.message).append(counts[6]).append(SUFFIX.message);

        System.out.println(sb);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(PRINT_RATE_OF_RETURN.message, rateOfReturn);
    }
}
