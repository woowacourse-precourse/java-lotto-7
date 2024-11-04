package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static List<Lotto> purchaseLottos(int amount) {

        List<Lotto> lottos = new ArrayList<>();
        int numberOfLottos = amount / LOTTO_PRICE;
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT)));
        }

        return lottos;
    }

    private static Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        return Rank.of(matchCount, bonusMatch);
    }

    public static String calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> resultCount = initializeResultCount();

        for (Lotto lotto : lottos) {
            Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
            resultCount.put(rank, resultCount.get(rank) + 1);
        }

        return formatResult(resultCount);
    }

    public static double calculateYield(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        Map<Rank, Integer> resultCount = initializeResultCount();
        long totalPrize = 0;

        for (Lotto lotto : lottos) {
            Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
            resultCount.put(rank, resultCount.get(rank) + 1);
            totalPrize += rank.getPrize();
        }

        return (double) totalPrize / purchaseAmount * 100;
    }

    private static Map<Rank, Integer> initializeResultCount() {
        Map<Rank, Integer> resultCount = new HashMap<>();
        for (Rank rank : Rank.values()) {
            resultCount.put(rank, 0);
        }
        return resultCount;
    }

    private static String formatResult(Map<Rank, Integer> resultCount) {
        StringBuilder result = new StringBuilder();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NO_RANK) {
                result.append(rank.getDescription()).append(" - ").append(resultCount.get(rank)).append("개\n");
            }
        }
        return result.toString().trim();
    }
}
