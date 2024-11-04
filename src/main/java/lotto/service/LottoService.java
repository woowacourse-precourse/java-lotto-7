package lotto.service;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Lotto> purchaseLottos(int amount) {
        int numberOfLottos = calculateNumberOfLottos(amount);
        return createLottos(numberOfLottos);
    }

    private int calculateNumberOfLottos(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount / LOTTO_PRICE;
    }

    private List<Lotto> createLottos(int numberOfLottos) {
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER_COUNT)))
                .collect(Collectors.toList());
    }

    public Map<Rank, Long> calculateResults(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        return userLottos.stream()
                .map(lotto -> getRank(lotto, winningLotto, bonusNumber))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private Rank getRank(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    public double calculateProfitRate(Map<Rank, Long> results, int totalSpent) {
        long totalWinnings = results.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalWinnings / totalSpent) * 100;
    }
}
