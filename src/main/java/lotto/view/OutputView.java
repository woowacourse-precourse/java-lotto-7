package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;

public interface OutputView {
    void printTotalIssuedLotto(List<Lotto> issuedLotto);
    void printWinningStatus(List<LottoRank> lottoRanks, int lottoPrice);
}
