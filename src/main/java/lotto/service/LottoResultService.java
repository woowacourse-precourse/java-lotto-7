package lotto.service;

import lotto.model.LottoResult;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;

import java.util.List;

public class LottoResultService {
    // 로또 티켓이랑 로또 넘버 대조해서 몇 개 맞혔는지
    public void countMatchingNumbers(List<Lotto> purchasedLottos, WinningNumbers winningNumbers, LottoResult result) {
        for(Lotto lotto : purchasedLottos){
            countMatchingNumber(lotto, winningNumbers,result);
        }
    }

    private void countMatchingNumber(Lotto lotto, WinningNumbers winningNumbers, LottoResult lottoResult) {
        long matchCount = lotto.getNumbers().stream()
                .filter(winningNumbers.getLotteryNumbers()::contains)
                .count();

        // LotteryResult의 matchCounts에 값 추가
        lottoResult.addMatchCount((int)matchCount);
        // printResultNow(lottoResult);
    }


    public void printResultNow(LottoResult result){
        System.out.println(result.getMatchCounts().toString());
    }

}
