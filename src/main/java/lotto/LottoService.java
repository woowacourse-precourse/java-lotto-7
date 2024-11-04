package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public LottoBuyer getLottoBuyer(PurchaseAmount purchaseAmount) {
        return new LottoBuyer(LottoPublisher.publishLotto(purchaseAmount), purchaseAmount);
    }

    public List<Integer> compareWinningNumber(List<Lotto> lottos, WinningNumber winningNumber) {
        return lottos.stream()
                .map(winningNumber::getSameCount)
                .toList();
    }

    public List<Boolean> compareBonusNumber(List<Lotto> lottos, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.contains(bonusNumber.getBonusNumber()))
                .toList();
    }

    public List<LottoWinningRanks> summarizeLottoRanks(List<Integer> lottoResults, List<Boolean> bonusResults) {
        List<LottoWinningRanks> lottoWinningRanks = new ArrayList<>();
        for (int i = 0; i < lottoResults.size(); i++) {
            int sameCount = lottoResults.get(i);
            boolean isBonusMatched = bonusResults.get(i);
            lottoWinningRanks.add(LottoWinningRanks.getRank(sameCount, isBonusMatched));
        }
        return lottoWinningRanks;
    }

    public Map<LottoWinningRanks, Integer> summarizeRanksToCounts(List<LottoWinningRanks> lottoWinningRanks) {
        Map<LottoWinningRanks, Integer> lottoRankMap = new HashMap<>();
        for (LottoWinningRanks rank : lottoWinningRanks) {
            lottoRankMap.put(rank, lottoRankMap.getOrDefault(rank, 0) + 1);
        }
        return lottoRankMap;
    }

    public double calculateRateOfReturn(List<LottoWinningRanks> prizeResults, LottoBuyer lottoBuyer) {
        double finalValue = 0;
        double investment = lottoBuyer.getPurchaseAmount();
        for(LottoWinningRanks winningRank : prizeResults) {
            finalValue += winningRank.getMoney();
        }
        return (finalValue / investment) * 100;
    }
}
