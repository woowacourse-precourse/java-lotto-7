package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoResult;
import lotto.model.lotto.Lottos;
import lotto.model.winning.WinningNumbersAndBonusNumber;

public class LottoResultChecker {

    private final WinningNumbersAndBonusNumber winningNumbersAndBonusNumber;

    public LottoResultChecker(WinningNumbersAndBonusNumber winningNumbersAndBonusNumber) {
        this.winningNumbersAndBonusNumber = winningNumbersAndBonusNumber;
    }

    public List<LottoResult> check(Lottos lottos) {
        List<LottoResult> results = new ArrayList<>();
        List<Integer> winningNumbers = winningNumbersAndBonusNumber.getWinningNumbers().getNumbers();
        int bonusNumber = winningNumbersAndBonusNumber.getBonusNumber().getNumber();

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
