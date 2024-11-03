package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.ResultCount;

public interface Output {

    void completePurchase(int num);

    void printLotto(Lotto lotto);

    void printWinningStatistics(ResultCount resultCount, int lottoPrize);

    void printMsg(String msg);
}
