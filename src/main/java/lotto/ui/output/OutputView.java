package lotto.ui.output;

import lotto.domain.entity.Lotto;
import lotto.domain.entity.Lottos;

import java.util.List;

public interface OutputView {

    void printLottos(Lottos lottos);

    void winningStats(Lottos ranks, int profit);
}
