package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public interface OutputView {

    void printErrorMessage(String message);

    void printPurchasedLottos(List<Lotto> purchasedLotto);

    void printWinningStatistics();

    void printTotalProfitRate();
}
