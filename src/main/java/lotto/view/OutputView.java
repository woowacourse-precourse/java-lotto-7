package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;

public class OutputView {
    public static final String BUY_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";

    public void printOfBuyLotto(LottoGame lottoGame) {
        System.out.printf(BUY_LOTTO_MESSAGE, lottoGame.countOfLotto());
        for (Lotto lotto : lottoGame.getAllLotto()) {
            System.out.println(lotto.sortNumbers());
        }
    }
}
