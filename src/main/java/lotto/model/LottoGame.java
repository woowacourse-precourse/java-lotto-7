package lotto.model;

import static lotto.model.LottoRank.SECOND;
import static lotto.model.LottoRank.THIRD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final Map<LottoRank, Integer> lottoResult;
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private final List<Lotto> purchasedLottos;

    public LottoGame(List<Integer> winningNumber, int bonusNumber, List<Lotto> purchasedLottos) {
        this.lottoResult = initializeLottoResult();
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.purchasedLottos = purchasedLottos;
    }

    public Map<LottoRank, Integer> checkLottoResult() {
        initializeLottoResult();
        for (Lotto purchasedLotto : purchasedLottos) {
            List<Integer> purchasedLottoNumbers = purchasedLotto.getNumbers();
            checkIndividualLottoResult(purchasedLottoNumbers);
        }

        return lottoResult;
    }

    public double calculateStatistics(int purchaseAmount) {
        double prizeSum = getPrizeSum();
        return (prizeSum / purchaseAmount) * 100;
    }

    private Map<LottoRank, Integer> initializeLottoResult() {
        Map<LottoRank, Integer> lottoResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }

        return lottoResult;
    }

    private void checkIndividualLottoResult(List<Integer> purchasedLottoNumbers) {
        long matchNumbers = checkWinningNumber(purchasedLottoNumbers);
        LottoRank resultRank = getMatchRank(matchNumbers);

        if (resultRank == SECOND || resultRank == THIRD) {
            checkBonusNumber(purchasedLottoNumbers);
            return;
        }

        if (resultRank != null) {
            lottoResult.put(resultRank, lottoResult.get(resultRank) + 1);
        }
    }

    private long checkWinningNumber(List<Integer> purchasedLottoNumber) {
        return purchasedLottoNumber.stream()
                .filter(winningNumber::contains)
                .count();
    }

    private LottoRank getMatchRank(long matchNumbers) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchNumbers() == matchNumbers) {
                return rank;
            }
        }
        return null;
    }

    private void checkBonusNumber(List<Integer> purchasedLottoNumbers) {
        if (purchasedLottoNumbers.contains(bonusNumber)) {
            lottoResult.put(SECOND, lottoResult.get(SECOND) + 1);
            return;
        }
        lottoResult.put(LottoRank.THIRD, lottoResult.get(LottoRank.THIRD) + 1);
    }

    private double getPrizeSum() {
        return Arrays.stream(LottoRank.values())
                .mapToDouble(rank -> rank.getPrizeAmount() * lottoResult.getOrDefault(rank, 0))
                .sum();
    }
}
