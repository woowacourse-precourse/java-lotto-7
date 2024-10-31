package lotto.ui.output;

import lotto.domain.entity.Lotto;

import java.util.List;

public interface OutputView {

    void printLottos(List<Lotto> lottos);

    void winningStats(List<Lotto> ranks, int profit);
}
