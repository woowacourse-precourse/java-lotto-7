package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    public int calculateLottoCount(int amount) {
        return amount / 1000;
    }

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public List<Integer> convertToNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    public Map<LottoRank, Integer> calculateWinningStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        initializeStatistics(statistics);

        for (Lotto lotto : lottos) {
            LottoRank rank = determineWinningRank(lotto, winningLotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    private void initializeStatistics(Map<LottoRank, Integer> statistics) {
        for (LottoRank rank : LottoRank.values()) {
            statistics.put(rank, 0);
        }
    }

    private LottoRank determineWinningRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.matchNumbersCount(lotto);
        boolean matchBonus = winningLotto.matchBonusNumber(lotto);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    public double calculateReturnRate(Map<LottoRank, Integer> statistics, int purchaseAmount) {
        long totalPrize = calculateTotalPrize(statistics);
        return (totalPrize * 100.0) / purchaseAmount;
    }

    private long calculateTotalPrize(Map<LottoRank, Integer> statistics) {
        return statistics.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}