package lotto.model.service;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoWinningNumbers;
import lotto.model.domain.ProfitRatio;
import lotto.model.domain.PurchaseAmount;

public class LottoDrawService {

    public List<LottoPrize> drawWinners(List<Lotto> lottos, LottoWinningNumbers lottoWinningNumbers) {
        List<LottoPrize> winners = new ArrayList<>();

        Set<Integer> winningNumberSet = new HashSet<>(lottoWinningNumbers.getNumbers());

        for (Lotto lotto : lottos) {
            LottoPrize prize = getPrizeIfWinner(lotto, winningNumberSet, lottoWinningNumbers.getBonusNumber());
            if (prize != null) {
                winners.add(prize);
            }
        }
        return winners;
    }

    public ProfitRatio calculateProfitRatio(PurchaseAmount purchaseAmount, List<LottoPrize> winners) {
        int totalAmount = winners.stream()
                .mapToInt(LottoPrize::getPrize)
                .sum();
        return new ProfitRatio(totalAmount, purchaseAmount.get());
    }


    private LottoPrize getPrizeIfWinner(Lotto lotto, Set<Integer> winningNumberSet, int bonusNumber) {
        Set<Integer> lottoNumberSet = new HashSet<>(lotto.getNumbers());
        boolean isBonusCorrect = lottoNumberSet.contains(bonusNumber);
        lottoNumberSet.retainAll(winningNumberSet);

        return LottoPrize.findBy(lottoNumberSet.size(), isBonusCorrect);
    }

}
