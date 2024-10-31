package lotto.view;

import static lotto.utils.Constant.HORIZONTAL_DIVIDER_MESSAGE;
import static lotto.utils.Constant.LOTTO_PRIZE_MESSAGE;
import static lotto.utils.Constant.LOTTO_PURCHASE_COUNT_MESSAGE;
import static lotto.utils.Constant.LOTTO_RESULT_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {

    public void printLottoNumbers(int lottoCount, List<Lotto> lottos) {
        printEmptyLine();

        System.out.printf(LOTTO_PURCHASE_COUNT_MESSAGE, lottoCount);
        printEmptyLine();

        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }

        printEmptyLine();
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printLottoResult(LottoResult lottoResult, int purchaseAmount) {
        printEmptyLine();
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(HORIZONTAL_DIVIDER_MESSAGE);
        System.out.println(lottoResult.toString());
        System.out.printf(LOTTO_PRIZE_MESSAGE, lottoResult.calculatePrize(purchaseAmount));
    }
}
