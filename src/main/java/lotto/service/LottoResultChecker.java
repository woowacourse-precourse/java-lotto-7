package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoResult;
import lotto.model.lotto.Lottos;
import lotto.model.winning.WinningNumbers;

public class LottoResultChecker {

    private final WinningNumbers winningNumbers;

    public LottoResultChecker(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<LottoResult> check(Lottos lottos) {
        List<LottoResult> results = new ArrayList<>();
        List<Integer> numbers = this.winningNumbers.getNumbers().getNumbers();
        int bonusNumber = this.winningNumbers.getBonusNumber().getNumber();

        for (Lotto lotto : lottos.getLottos()) {
            results.add(evaluateLotto(lotto, numbers, bonusNumber));
        }

        return results;
    }

    private LottoResult evaluateLotto(Lotto lotto, List<Integer> numbers, int bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchCount = countMatchingNumbers(lottoNumbers, numbers);
        boolean hasBonus = lottoNumbers.contains(bonusNumber);

        return new LottoResult(matchCount, hasBonus);
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> numbers) {
        return (int) lottoNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

}
