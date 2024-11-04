package lotto.domain;

import java.util.*;

public class LottoResult {

    private static final int DEFAULT_VALUE = 0;
    private static final int INCREMENT_COUNT = 1;

    private final EnumMap<LottoRankType, Integer> rankCountMap;

    private LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        rankCountMap = initializeRankCountMap();
        calculateLottoRanks(lottos, winningNumbers, bonusNumber);
    }

    public static LottoResult of(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(lottos, winningNumbers, bonusNumber);
    }

    public EnumMap<LottoRankType, Integer> getRankCountMap() {
        return rankCountMap;
    }

    private EnumMap<LottoRankType, Integer> initializeRankCountMap() {
        EnumMap<LottoRankType, Integer> rankCountMap = new EnumMap<>(LottoRankType.class);
        Arrays.stream(LottoRankType.values())
                .forEach(rank -> rankCountMap.put(rank, DEFAULT_VALUE));
        return rankCountMap;
    }

    private void calculateLottoRanks(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        lottos.forEach(lotto -> calculateRankForLotto(lotto.getNumbers(), winningNumbers, bonusNumber));
    }

    private void calculateRankForLotto(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean hasBonusNumber = containsBonusNumber(lottoNumbers, bonusNumber);
        LottoRankType rank = LottoRankType.of(matchCount, hasBonusNumber);
        rankCountMap.put(rank, rankCountMap.get(rank) + INCREMENT_COUNT);
    }

    private boolean containsBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

}