package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.winning.WinningLotto;

public class LottoResultChecker {

    private final WinningLotto winningLotto;

    public LottoResultChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<LottoResult> check(Lottos lottos) {
        List<LottoResult> results = new ArrayList<>();
        List<Integer> winningNumbers = winningLotto.getWinningNumbers().getNumbers();
        int bonusNumber = winningLotto.getBonusNumber().getNumber();

        for (Lotto lotto : lottos.getLottos()) {
            results.add(evaluateLotto(lotto, winningNumbers, bonusNumber));
        }

        return results;
    }

    private LottoResult evaluateLotto(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = countMatchingNumbers(lottoNumbers, winningNumbers);
        boolean hasBonus = lottoNumbers.contains(bonusNumber);

        return new LottoResult(matchCount, hasBonus);
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

}
