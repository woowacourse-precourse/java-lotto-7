package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Ranks;

import java.math.BigDecimal;

public interface Output {
    void outputError(Exception exception);
    void showLottos(Lottos lottos);
    void goToNext();
    void showRanks(Ranks ranks);
    void showProfitPercentage(BigDecimal profitPercentage);
}
