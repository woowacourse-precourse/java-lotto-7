package lotto.service;

import static lotto.constant.LottoGameRule.LOTTO_COST;
import static lotto.constant.WinningPrize.FIFTH_PRIZE;
import static lotto.constant.WinningPrize.FIRST_PRIZE;
import static lotto.constant.WinningPrize.FOURTH_PRIZE;
import static lotto.constant.WinningPrize.NONE;
import static lotto.constant.WinningPrize.SECOND_PRIZE;
import static lotto.constant.WinningPrize.THIRD_PRIZE;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.WinningPrize;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.domain.Revenue;
import lotto.dto.WinningStat;

public class StatService {
    public List<WinningStat> getWinningStats(LottoGame lottoGame) {
        Map<WinningPrize, Integer> prizeCountMap = getPrizeCountMap(lottoGame);

        return createWinningStats(prizeCountMap);
    }

    public Revenue createRevenue(Lottos lottos, List<WinningStat> winningStats) {
        int purchaseAmount = lottos.getLottoQuantity() * LOTTO_COST.getValue();
        int totalAmount = getTotalAmount(winningStats);

        return new Revenue(purchaseAmount, totalAmount);
    }

    private int getTotalAmount(List<WinningStat> winningStats) {
        return winningStats.stream()
                .mapToInt(winningStat -> winningStat.prizeAmount() * winningStat.prizeCount())
                .sum();
    }

    private Map<WinningPrize, Integer> getPrizeCountMap(LottoGame lottoGame) {
        Map<WinningPrize, Integer> prizeCountMap = initializeMap();

        Lottos lottos = lottoGame.getLottos();

        for (Lotto lotto : lottos.getLottoGroup()) {
            WinningPrize prize = getWinningPrize(lotto, lottoGame.getWinningLotto(), lottoGame.getBonusNumber());
            prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
        }

        return prizeCountMap;
    }

    private Map<WinningPrize, Integer> initializeMap() {
        Map<WinningPrize, Integer> prizeCountMap = new EnumMap<>(WinningPrize.class);

        for (WinningPrize prize : WinningPrize.values()) {
            prizeCountMap.put(prize, 0);
        }

        return prizeCountMap;
    }

    private WinningPrize getWinningPrize(Lotto pickedLotto, Lotto winningLotto, BonusNumber bonusNumber) {
        int matchingCount = getMatchingCount(pickedLotto.getNumbers(), winningLotto.getNumbers());
        boolean bonusMatch = isBonusMatch(pickedLotto.getNumbers(), bonusNumber.getNumber());

        return findRank(matchingCount, bonusMatch);
    }

    private WinningPrize findRank(int matchingCount, boolean bonusMatch) {
        if (matchingCount == FIRST_PRIZE.getMatchingCount()) return FIRST_PRIZE;
        if (matchingCount == SECOND_PRIZE.getMatchingCount() && bonusMatch) return SECOND_PRIZE;
        if (matchingCount == THIRD_PRIZE.getMatchingCount()) return THIRD_PRIZE;
        if (matchingCount == FOURTH_PRIZE.getMatchingCount()) return FOURTH_PRIZE;
        if (matchingCount == FIFTH_PRIZE.getMatchingCount()) return FIFTH_PRIZE;

        return NONE;
    }

    private List<WinningStat> createWinningStats(Map<WinningPrize, Integer> prizeCountMap) {
        List<WinningStat> winningStats = new ArrayList<>();

        for (WinningPrize prize : WinningPrize.values()) {
            if (prize == NONE) {
                continue;
            }

            winningStats.add(
                    new WinningStat(prize.getMatchingCount(), prize.isBonusMatch(),
                            prize.getPrizeAmount(), prizeCountMap.get(prize))
            );
        }

        return winningStats;
    }

    private int getMatchingCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean isBonusMatch(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
