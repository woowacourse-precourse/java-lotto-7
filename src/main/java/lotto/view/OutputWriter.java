package lotto.view;

import java.util.List;
import lotto.model.LottoPurchase;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;

public class OutputWriter {

    public void purchasedLottos(final LottoPurchase lottoPurchase, final Lottos lottos) {
        System.out.println("\n" + lottoPurchase.getLottoCount() + "개를 구매했습니다.");
        for (List<Integer> purchasedLotto : lottos.getPurchasedLottos()) {
            System.out.println(purchasedLotto);
        }
    }

    public void winningNumbers(final WinningNumbers winningNumbers) {
        System.out.println(winningNumbers.getNumbers());
    }
}
