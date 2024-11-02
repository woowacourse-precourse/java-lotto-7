package lotto.domain;

import lotto.constants.Ranking;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.LottoValue.LOTTO_PRICE;

public class LottoTicket {
    private static final double PERCENTAGE_UNIT = 100.0;

    private final List<Lotto> lottos;

    public LottoTicket(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public EnumMap<Ranking, Integer> checkRanking(final WinningLotto winningLotto) {
        EnumMap<Ranking, Integer> rankingMap = new EnumMap<>(Ranking.class);
        lottos.stream()
                .map(lotto -> checkRanking(lotto, winningLotto))
                .forEach(ranking -> rankingMap.merge(ranking, 1, Integer::sum));
        return rankingMap;
    }

    private Ranking checkRanking(final Lotto lotto, final WinningLotto winningLotto){
        int matchCount = lotto.calculateMatchCount(winningLotto.getLotto().getNumbers());
        boolean isBonus = lotto.isContainNumber(winningLotto.getBonusNumber());
        return Ranking.of(matchCount, isBonus);
    }

    public double calculateProfitRate(final WinningLotto winningLotto) {
        long totalReward = calculateTotalReward(checkRanking(winningLotto));
        int purchaseAmount = calculatePurchaseAmount();
        return (double) totalReward / purchaseAmount * PERCENTAGE_UNIT;
    }

    private long calculateTotalReward(final EnumMap<Ranking, Integer> rankingMap) {
        return rankingMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    private int calculatePurchaseAmount() {
        return LOTTO_PRICE.getValue() * getLottoCount();
    }

    public List<List<Integer>> getAllLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumberValues)
                .collect(Collectors.toList());
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
