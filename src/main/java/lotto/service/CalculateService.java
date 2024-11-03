package lotto.service;

import static lotto.constants.LottoConstants.NUMBER_COUNT;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;

public class CalculateService {

    private final EnumMap<LottoRank, Integer> winningLottos = new EnumMap<>(LottoRank.class);
    private double profitRate;

    public CalculateService() {
        for (LottoRank rank : LottoRank.values()) {
            winningLottos.put(rank, 0);
        }
    }

    public void calculateWinning(PurchasedLotto purchasedLotto, WinningLotto winningLotto) {
        List<Lotto> purchasedLottos = purchasedLotto.getPurchasedLottos();
        List<Integer> winningNumbers = winningLotto.getWinningLotto();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : purchasedLottos) {
            LottoRank rank = getLottoRank(lotto, winningNumbers, bonusNumber);
            if (rank != null) {
                winningLottos.merge(rank, 1, Integer::sum);
            }
        }
    }

    private LottoRank getLottoRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchedCount = getMatchedCount(lotto, winningNumbers);
        boolean bonusMatch = isMatchedBonusNumber(lotto, bonusNumber);
        return LottoRank.getPrizeRank(matchedCount, bonusMatch);
    }

    private boolean isMatchedBonusNumber(Lotto lotto, int bonusNumber) {
        return (lotto.getNumbers().contains(bonusNumber));
    }

    private int getMatchedCount(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public void calculateProfitRate(int purchaseAmount) {
        int purchaseWon = purchaseAmount * 1000;
        double totalPrize = winningLottos.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
        profitRate = (totalPrize / purchaseWon) * 100;
    }

    public EnumMap<LottoRank, Integer> getWinningLottos() {
        return winningLottos;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
