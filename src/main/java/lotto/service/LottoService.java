package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

import java.util.List;

public interface LottoService {
    int getIssueCount(int cost, int lottoPrice);
    List<Lotto> issueLotto(int issueCount);
    List<LottoRank> rankLotto(List<Lotto> issuedLotto, WinningLotto winningLotto);
}
