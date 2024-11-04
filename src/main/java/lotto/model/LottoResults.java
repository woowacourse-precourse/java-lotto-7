package lotto.model;

import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResults;
    private Checker checker;

    public LottoResults(Lotto winningNumbers, int bonusNumber) {
        checker = new Checker(winningNumbers, bonusNumber);
    }

    public List<LottoResult> getLottoResults(Lotties lotties) {
        this.lottoResults = lotties.getLotties().stream()
                .map(lotto -> checker.check(lotto))
                .toList();
        return lottoResults;
    }
}
