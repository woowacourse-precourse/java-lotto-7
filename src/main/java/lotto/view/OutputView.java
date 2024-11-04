package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoResultMessage;
import lotto.constant.Message;
import lotto.model.Lotto;

public class OutputView {
    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printPurchaseAmountMessage() {
        System.out.println(Message.PURCHASE_AMOUNT.get());
    }

    public void printWinningNumbersMessage() {
        System.out.println(Message.WINNING_NUMBERS.get());
    }

    public void printBonusNumberMessage() {
        System.out.println(Message.BONUS_NUMBER.get());
    }

    public void printLottos(List<Lotto> lottos) {
        String purchase_msg = Message.LOTTO_PURCHASE.get().formatted(lottos.size());

        System.out.println(purchase_msg);
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public void printLottoResult(Map<Integer, Integer> lottoResult) {
        System.out.println(Message.WINNING_STATS.get());

        for (int rank = 5; rank >= 1; rank--) {
            System.out.printf(LottoResultMessage.findByRank(rank).get(), lottoResult.get(rank));
        }
    }

    public void printTotalEarningsRate(float totalEarningsRate) {
        System.out.printf(Message.TOTAL_EARNINGS_RATE.get(), totalEarningsRate);
    }
}
