package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int ZERO = 0;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int count) {
        List<Lotto> lottos = IntStream.range(ZERO, count)
                .mapToObj(i -> new Lotto(pickLottoNumbers()))
                .toList();

        return new Lottos(lottos);
    }

    private static List<Integer> pickLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_SIZE)
                .stream()
                .sorted()
                .toList();
    }

    public Map<String, Integer> lottoDraw(LottoWinningNumbers lottoWinningNumbers) {
        List<Integer> winningCount = lottoWinningNumbers.calculateWinningCount(this);
        List<Boolean> bonusCheck = lottoWinningNumbers.calculateBonusCheck(this);

        return calculateLottoResults(winningCount, bonusCheck);

    }

    public int totalWinningPrice(Map<String, Integer> rankCount) {
        return rankCount.entrySet().stream()
                .mapToInt(rank -> Winners.fromDescription(rank.getKey()).getPrize() * rank.getValue())
                .sum();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        String result = lottos.stream()
                .map(lotto -> lotto.toString() + "\n")
                .collect(Collectors.joining());
        return result.trim();
    }

    private Map<String, Integer> calculateLottoResults(List<Integer> winningCount, List<Boolean> bonusCheck) {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Winners rank : Winners.values()) {
            rankCount.put(rank.getDescription(), 0);
        }

        for (int i = 0; i < winningCount.size(); i++) {
            int matchCount = winningCount.get(i);
            boolean hasBonus = bonusCheck.get(i);
            Winners rank = Winners.determineRank(matchCount, hasBonus);

            rankCount.put(rank.getDescription(), rankCount.get(rank.getDescription()) + 1);
        }
        return rankCount;
    }

}
