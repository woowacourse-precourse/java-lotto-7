package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BonuseNumber;
import lotto.domain.Lotto;
import lotto.enums.LottoRank;

public class LottoResultService {

    public List<LottoRank> calculateLottoResults(Lotto winningLotto, BonuseNumber bonuseNumber,
                                                 List<Lotto> purchasedLottos) {
        return purchasedLottos.stream()
                .map(lotto -> calculateRank(lotto.getNumbers(), winningLotto.getNumbers(), bonuseNumber.getNumber()))
                .collect(Collectors.toList());
    }

    private LottoRank calculateRank(List<Integer> lottoNumbers, List<Integer> winningNumbers, Integer bonusNumber) {
        long matchCount = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean matchBonus = lottoNumbers.contains(bonusNumber);

        if (matchCount == 6) {
            return LottoRank.FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return LottoRank.SECOND;
        }
        if (matchCount == 5) {
            return LottoRank.THIRD;
        }
        if (matchCount == 4) {
            return LottoRank.FOURTH;
        }
        if (matchCount == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.NOTHING;
    }

    public double calculateProfitRate(List<LottoRank> results, int totalInvestment) {
        long totalReward = results.stream()
                .filter(rank -> rank != LottoRank.NOTHING)
                .mapToLong(LottoRank::getReward)
                .sum();
        return ((double) totalReward / totalInvestment) * 100;
    }

}
