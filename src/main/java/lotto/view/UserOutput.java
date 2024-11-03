package lotto.view;

import lotto.model.Lotto;

public interface UserOutput {
    public void outputLottoCount(int lottoCount);

    public void outputStatistics(Lotto lotto);
}
