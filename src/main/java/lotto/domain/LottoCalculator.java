package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {
    private Lottos lottos;
    private BonusNumber bonusNumber;

    public LottoCalculator(Lottos lottos, BonusNumber bonusNumber, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.bonusNumber = bonusNumber;
    }

    public double calculateProfitRate(int[] lottoResult, LottoRound lottoRound) {
        double[] prizeAmounts = {5000, 50000, 1500000, 30000000, 2000000000};
        double totalPrize = 0;

        for (int i = 0; i < lottoResult.length; i++) {
            totalPrize += lottoResult[i] * prizeAmounts[i];
        }

        double totalCost = lottoRound.getLottoRound() * 1000;
        double profitRate = (totalPrize / totalCost) * 100;

        return Math.round(profitRate * 100.0) / 100.0;
    }


    public int[] getLottoResult(List<LottoNumberCounter> counters) {
        int[] lottoResult = new int[5];

        for (LottoNumberCounter counter : counters) {
            updateLottoResult(counter, lottoResult);
        }

        return lottoResult;
    }

    private void updateLottoResult(LottoNumberCounter counter, int[] lottoResult) {
        if (counter.getMatchingNumberCount() == 3) {
            lottoResult[0]++;
        }
        if (counter.getMatchingNumberCount() == 4) {
            lottoResult[1]++;
        }
        if (counter.getMatchingNumberCount() == 5 && counter.getBonusNumberCount() == 0) {
            lottoResult[2]++;
        }
        if (counter.getMatchingNumberCount() == 5 && counter.getBonusNumberCount() == 1) {
            lottoResult[3]++;
        }
        if (counter.getMatchingNumberCount() == 6) {
            lottoResult[4]++;
        }
    }

    public List<LottoNumberCounter> calculateMatching() {
        List<LottoNumberCounter> counters = new ArrayList<>();

        for (Lotto lotto : lottos.getLottoNumbers()) {
            LottoNumberCounter counter = calculateSingleLottoMatching(lotto);
            counters.add(counter);
        }

        return counters;
    }

    private LottoNumberCounter calculateSingleLottoMatching(Lotto lotto) {
        int matchingCount = 0;
        int bonusCount = 0;

        for (var lottoNumber : lotto.getNumbers()) {
            matchingCount += checkMatchingNumber(lottoNumber);
            bonusCount += checkBonusNumber(lottoNumber);
        }

        return new LottoNumberCounter(matchingCount, bonusCount);
    }

    private int checkMatchingNumber(int lottoNumber) {
        if (isWinningNumber(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    private int checkBonusNumber(int lottoNumber) {
        if (isBonusNumber(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    private boolean isWinningNumber(int lottoNumber) {
        return WinningNumber.getWinningNumbers().contains(lottoNumber);
    }

    private boolean isBonusNumber(int lottoNumber) {
        return bonusNumber.getBonusNumber() == lottoNumber;
    }
}
