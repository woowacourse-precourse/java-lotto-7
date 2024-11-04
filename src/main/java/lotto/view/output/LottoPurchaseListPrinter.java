package lotto.view.output;

import java.util.List;
import lotto.model.Lotto;

public class LottoPurchaseListPrinter {

    public void output(List<Lotto> lotteryTickets) {
        OutputMessageEnum.PURCHASE_COUNT.printf(lotteryTickets.size());
        OutputMessageEnum.printLottoNumbers(lotteryTickets);
    }
}
