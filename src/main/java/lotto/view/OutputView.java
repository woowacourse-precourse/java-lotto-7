package lotto.view;

import static lotto.utils.Constant.LOTTO_PURCHASE_COUNT_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;

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
}
