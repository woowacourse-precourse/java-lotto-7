package lotto.model;

import static lotto.model.LottoRank.SECOND;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    Map<LottoRank, Integer> lottoResult;
    List<Integer> winningNumber;
    int bonusNumber;
    List<Lotto> purchasedLottoList;

    public LottoGame(List<Integer> winningNumber, int bonusNumber, List<Lotto> purchasedLottoList) {
        this.lottoResult = initializeLottoResult();
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.purchasedLottoList = purchasedLottoList;
    }

    public Map<LottoRank, Integer> checkLottoResult() {
        initializeLottoResult();
        for (Lotto purchasedLotto : purchasedLottoList) {
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
        for (LottoRank lottoRank : LottoRank.values()) {
            checkEachRank(matchNumbers, lottoRank, purchasedLottoNumbers);
        }
    }

    private long checkWinningNumber(List<Integer> purchasedLottoNumber) {
        return purchasedLottoNumber.stream()
                .filter(winningNumber::contains)
                .count();
    }

    private void checkEachRank(long matchNumbers, LottoRank lottoRank, List<Integer> purchasedLottoNumbers) {
        if (matchNumbers == lottoRank.getMatchNumbers()) {
            if (matchNumbers == SECOND.getMatchNumbers()) {
                checkBonusNumber(purchasedLottoNumbers);
            }
            if (matchNumbers != SECOND.getMatchNumbers()) {
                lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
            }
        }
    }

    private void checkBonusNumber(List<Integer> purchasedLottoNumbers) {
        if (purchasedLottoNumbers.contains(bonusNumber)) {
            lottoResult.put(SECOND, lottoResult.get(SECOND) + 1);
        }
        if (!purchasedLottoNumbers.contains(bonusNumber)) {
            lottoResult.put(LottoRank.THIRD, lottoResult.get(LottoRank.THIRD) + 1);
        }
    }

    private double getPrizeSum() {
        return Arrays.stream(LottoRank.values())
                .mapToDouble(rank -> rank.getPrizeAmount() * lottoResult.getOrDefault(rank, 0))
                .sum();
    }
}
