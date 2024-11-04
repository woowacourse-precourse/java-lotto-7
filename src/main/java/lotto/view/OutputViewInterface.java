package lotto.view;

import lotto.model.domain.Lottos;
import lotto.model.domain.Rate;

public interface OutputViewInterface {

    void printTotalLottoCount(int LottoCount);
    void printCreatedLotto(Lottos lottos);
    void printRateStatus(Rate rate);

    void printRateReturn(double returnPrize);
}
