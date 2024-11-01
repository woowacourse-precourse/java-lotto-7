package lotto.io;

import lotto.domain.Lotto;

public interface Output {

    void completePurchase(int num);

    void printLotto(Lotto lotto);

    void printWinningStatistics();

    void printMsg(String msg);
}
