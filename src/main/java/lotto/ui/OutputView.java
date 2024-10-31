package lotto.ui;

import lotto.domain.entity.Lottos;
import lotto.domain.type.LottoRank;

import java.util.List;

public interface OutputView {

    void printLottos(Lottos lottos);

    void winningStats(List<LottoRank> ranks);
}
