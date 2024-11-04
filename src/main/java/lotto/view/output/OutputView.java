package lotto.view.output;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Statistics;

public interface OutputView {

    void printPurchaseResults(final List<Lotto> lottos);

    void printStatisticsResults(final Statistics statistics);

    void printErrorMessage(final String message);
}
