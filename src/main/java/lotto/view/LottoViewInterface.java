package lotto.view;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;

import java.util.List;

public interface LottoViewInterface {

    void printTotalLottoCount(int LottoCount);
    void printCreatedLotto(Lottos lottos);
    String printWinningStatus();
}
