package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.WinningRank;
import lotto.model.Lotto;

public interface OutPutView {
    void printBoughtLotto(List<Lotto> boughtLotto);

    void printWinningStatistic(Map<WinningRank, Integer> results);

    void printProfitRate(double profitRate);
}
