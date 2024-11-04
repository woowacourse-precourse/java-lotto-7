package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.common.LottoRank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPurchasePrice;
import lotto.model.LottoResult;
import lotto.model.ReturnRate;
import lotto.model.WinningNumbers;

public class LottoResultService {

    public LottoResult getLottoResult(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        LottoResult lottoResult = LottoResult.initialize();

        for (Lotto lotto : lottos) {
            LottoRank rank = calculateLottoRank(lotto, winningNumbers, bonusNumber);
            lottoResult = lottoResult.addResult(rank);
        }

        return lottoResult;
    }

    public ReturnRate calculateReturnRate(LottoResult lottoResult, LottoPurchasePrice lottoPurchasePrice) {
        long totalPrizeMoney = calculateTotalPrizeMoney(lottoResult);
        return new ReturnRate((double) totalPrizeMoney / lottoPurchasePrice.price() * 100);
    }

    private LottoRank calculateLottoRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = countMatchingNumbers(lotto, winningNumbers);
        boolean matchBonus = isMatchBonusNumber(lotto, bonusNumber);

        return LottoRank.of(matchCount, matchBonus);
    }

    private int countMatchingNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        return (int) lotto.numbers().stream()
                .filter(winningNumbers.numbers()::contains)
                .count();
    }

    private boolean isMatchBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.numbers().contains(bonusNumber.number());
    }

    private long calculateTotalPrizeMoney(LottoResult lottoResult) {
        return Arrays.stream(LottoRank.values())
                .mapToInt(rank -> lottoResult.getWinningCount(rank) * rank.getPrizeMoney())
                .sum();
    }
}