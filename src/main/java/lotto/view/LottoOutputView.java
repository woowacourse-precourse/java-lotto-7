package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.enums.LottoRank;

public class LottoOutputView {
    private static final String OUTPUT_PURCHASE_AMOUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String OUTPUT_LOTTO_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String OUTPUT_LOTTO_RANK_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String OUTPUT_LOTTO_SECOND_RANK_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String OUTPUT_LOTTO_RATE_OF_RETURN_MESSAGE = "총 수익률은 %f%%입니다.";

    public void printPurchaseAmountMessage(int purchaseAmountInput) {
        System.out.printf(OUTPUT_PURCHASE_AMOUNT_MESSAGE, purchaseAmountInput);
    }

    public void printRandomLottoNumberMessage(List<Lotto> numbers) {
        for (Lotto lotto : numbers) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResultMessage(LottoRank lottoRank, int result) {
        if (lottoRank.getRank() == 5) {
            System.out.println(OUTPUT_LOTTO_RESULT_MESSAGE);
        }
        if (lottoRank.getRank() == 2) {
            System.out.printf(OUTPUT_LOTTO_SECOND_RANK_RESULT_MESSAGE, lottoRank.getCount(), lottoRank.getPrizeInfo(),
                    result);
            return;
        }
        System.out.printf(OUTPUT_LOTTO_RANK_RESULT_MESSAGE, lottoRank.getCount(), lottoRank.getPrizeInfo(), result);
    }

    public void printLottoRateOfReturnMessage(float rate) {
        System.out.printf(OUTPUT_LOTTO_RATE_OF_RETURN_MESSAGE, rate);
    }
}
