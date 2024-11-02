package lotto.io.lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoConstant;

public class LottoOutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printPurchaseResult(List<Lotto> lottoes) {
        System.out.println();
        System.out.println(lottoes.size() + LottoConstant.PURCHASE_COUNT_MESSAGE);
        lottoes.stream().forEach(l -> {
            System.out.println(l.getNumbers());
        });
    }
}
