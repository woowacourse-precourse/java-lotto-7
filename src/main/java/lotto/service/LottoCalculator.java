package lotto.service;

import lotto.domain.model.*;
import lotto.domain.result.LottoStat;
import lotto.domain.result.WinningLotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoCalculator {

    private static final int LOTTO_PRICE = 1000;

    public LottoStat calculateStats(Lottos lottos, WinningLotto winningLotto) {
        LottoStat lottoStat = createLottoStat();
        lottos.getLottos()
                .forEach(lotto -> updateLottoStat(lottoStat, lotto, winningLotto));
        return lottoStat;
    }

    public double calculatePrizeRate(LottoStat lottoStat, int totalLottoCount) {
        long totalPrize = Arrays.stream(LottoRank.values())
                .mapToLong(lottoRank -> (long) lottoRank.getPrize() * lottoStat.getStats().get(lottoRank))
                .sum();

        double prizeRate = (totalPrize * 100.0) / (totalLottoCount * LOTTO_PRICE);
        return Math.round(prizeRate * 10.0) / 10.0;
    }

    private LottoStat createLottoStat() {
        Map<LottoRank, Integer> lottoStat = new HashMap<>();
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> lottoStat.put(lottoRank, 0));
        return new LottoStat(lottoStat);
    }

    private void updateLottoStat(LottoStat lottoStat, Lotto lotto, WinningLotto winningLotto) {
        LottoRank lottoRank = createLottoRank(lotto, winningLotto);
        lottoStat.updateStat(lottoRank, 1);
    }

    private LottoRank createLottoRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = findMatchCount(lotto, winningLotto);
        boolean matchBonus = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    private int findMatchCount(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getLotto().getNumbers()::contains)
                .count();
    }
}
