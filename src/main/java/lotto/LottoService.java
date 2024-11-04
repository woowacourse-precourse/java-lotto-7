package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public LottoBuyer getLottoBuyer(PurchaseAmount purchaseAmount) {
        return new LottoBuyer(LottoPublisher.publishLotto(purchaseAmount), purchaseAmount);
    }

    public List<LottoWinningRanks> summarizeLottoRanks(List<Lotto> lottos,
                                                       WinningNumber winningNumber,
                                                       BonusNumber bonusNumber) {
        return LottoRankSummary.summarizeLottoRanks(compareWinningNumber(lottos, winningNumber),
                compareBonusNumber(lottos, bonusNumber));
    }

    public Map<LottoWinningRanks, Integer> summarizeRanksToCounts(List<LottoWinningRanks> lottoWinningRanks) {
        return LottoRankSummary.summarizeRanksToCounts(lottoWinningRanks);
    }

    public double calculateRateOfReturn(List<LottoWinningRanks> prizeResults, LottoBuyer lottoBuyer) {
        return LottoRankSummary.calculateRateOfReturn(prizeResults, lottoBuyer);
    }

    private List<Integer> compareWinningNumber(List<Lotto> lottos, WinningNumber winningNumber) {
        return lottos.stream()
                .map(winningNumber::getSameCount)
                .toList();
    }

    private List<Boolean> compareBonusNumber(List<Lotto> lottos, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.contains(bonusNumber.getBonusNumber()))
                .toList();
    }
}
