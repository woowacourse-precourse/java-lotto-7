package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public interface OutputView {

    void printErrorMessage(String message);

    void printPurchasedLottos(List<Lotto> purchasedLotto);

    void printWinningStatistics(EnumMap<LottoRank, Integer> winningLottos);

    void printTotalProfitRate(double profitRate);
}
