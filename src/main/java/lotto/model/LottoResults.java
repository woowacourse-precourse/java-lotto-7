package lotto.model;

import java.util.List;

public class LottoResults {
    private List<LottoResult> lottoResults;
    private Checker checker;

    public LottoResults(WinningNumbers winningNumbers) {
        checker = new Checker(winningNumbers);
    }

    public void initLottoResults(Lottos lottos) {
        this.lottoResults = lottos.getLottos().stream()
                .map(lotto -> checker.check(lotto))
                .toList();
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }
}
