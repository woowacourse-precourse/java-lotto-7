package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LottoStatistics {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public LottoStatistics(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 겹치면 안 됩니다.");
        }
    }

    public List<LottoResult> updateResult(List<Lotto> issuedLottos) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : issuedLottos) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            List<Integer> numbersOverlapped = lottoNumbers.stream().filter(lottoNumber -> winningNumbers.stream().anyMatch(
                    Predicate.isEqual(lottoNumber))).toList();
            boolean hasBonus = lottoNumbers.contains(bonusNumber);
            lottoResults.add(lotto.getLottoResult(numbersOverlapped.size(), hasBonus));
        }
        return lottoResults;
    }
}
