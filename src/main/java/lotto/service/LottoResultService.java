package lotto.service;

import lotto.model.LottoResult;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import java.util.List;

public class LottoResultService {
    public void countMatchingNumbers(List<Lotto> purchasedLottos, WinningNumbers winningNumbers, LottoResult result) {
        for(Lotto lotto : purchasedLottos){
            countMatchingNumber(lotto, winningNumbers,result);
        }
    }

    private void countMatchingNumber(Lotto lotto, WinningNumbers winningNumbers, LottoResult lottoResult) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers.getLotteryNumbers()::contains)
                .count();

        lottoResult.addMatchCount((int)matchCount);
    }
}
