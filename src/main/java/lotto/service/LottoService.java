package lotto.service;

import lotto.Lotto;
import lotto.util.MathUtil;
import lotto.util.ParseUtil;
import lotto.util.RandomUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoService {
    static final String DELIMITER = ",";
    private static Map<Integer, Integer> matchCountPrizeMap;

    public LottoService() {
        this.matchCountPrizeMap = new HashMap<>();
        matchCountPrizeMap.put(6, 2000000000);
        matchCountPrizeMap.put(5, 1500000);
        matchCountPrizeMap.put(4, 50000);
        matchCountPrizeMap.put(3, 5000);
    }

    public List<Lotto> generateLottos(int size) {
        List<Lotto> lottos = IntStream.range(0, size)
                .mapToObj(i -> new Lotto(RandomUtil.getSixRandomNumbers(1, 45)))
                .collect(Collectors.toList());
        return lottos;
    }

    public Map<Integer, Integer> getMatchCounts(List<Lotto> lottos, Lotto winningLotto) {
        Map<Integer, Integer> matchCounts = IntStream.rangeClosed(0, 6)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> 0));

        lottos.stream()
                .map(lotto -> MathUtil.getMatchCount(lotto.getNumbers(), winningLotto.getNumbers()))
                .forEach(matchCount -> matchCounts.put(matchCount, matchCounts.get(matchCount) + 1));

        return matchCounts;
    }

    public Lotto getWinningLotto(String winningNumbersInput) {
        List<String> tokens = ParseUtil.splitByDelimiters(winningNumbersInput, DELIMITER);
        List<Integer> winningNumbers = ParseUtil.parseToIntegerList(tokens);
        Lotto winningLotto = new Lotto(winningNumbers);
        return winningLotto;
    }

    public long getPrizeMoney(Map<Integer, Integer> matchCounts, int bonusNumber) {
        long totalPrizeMoney = 0;
        for(int i=3; i<=6; i++) {
            int matchCount = matchCounts.get(i);
            totalPrizeMoney += (long) matchCount * matchCountPrizeMap.get(i);
        }
        return totalPrizeMoney;
    }

    public int getBonusNumber(String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        return bonusNumber;
    }

    public String getRateOfReturn(long totalPrizeMoney, int purchaseAmount) {
        double rateOfReturn = ((double) totalPrizeMoney - purchaseAmount) / purchaseAmount * 100;
        rateOfReturn = Math.round(rateOfReturn * 100.0) / 100.0;
        return String.format("%.2f", rateOfReturn);
    }
}
