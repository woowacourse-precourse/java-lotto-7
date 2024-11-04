package lotto.view;

import lotto.model.domain.Lottos;
import lotto.model.domain.LottoResult;

public interface OutputViewInterface {

    void printTotalLottoCount(int LottoCount);
    void printCreatedLotto(Lottos lottos);
    void printRateStatus(LottoResult lottoResult);

    void printRateReturn(double returnPrize);
}
