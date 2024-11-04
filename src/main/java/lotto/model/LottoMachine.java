package lotto.model;

import lotto.util.RandomNumberGenerator;

import java.util.*;

public class LottoMachine {

    public Lottos generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }

        return Lottos.of(lottos);
    }

    public LottoResult getLottoResult(Lottos lottos, WinningNumbers winningNumbers, int bonusNumber) {
        Map<Rank, Integer> statistic = initializeMap();
        for (Lotto lotto : lottos.getLottos()) {
            int comparedCount = winningNumbers.compareAt(lotto);
            boolean isBonusNumberContained = winningNumbers.containAt(bonusNumber);
            Optional<Rank> optionalRank = getOptionalRank(comparedCount, isBonusNumberContained);
            optionalRank.ifPresent(
                    rank -> statistic.put(rank, statistic.getOrDefault(rank, 0) + 1)
            );
        }

        return LottoResult.of(statistic);
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = RandomNumberGenerator.generate();
        return Lotto.of(lottoNumbers);
    }

    private Map<Rank, Integer> initializeMap() {
        Map<Rank, Integer> statistic = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(rank -> statistic.put(rank, 0));

        return statistic;
    }

    private Optional<Rank> getOptionalRank(int count, boolean contain) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.support(count, contain))
                .findFirst();
    }

}
