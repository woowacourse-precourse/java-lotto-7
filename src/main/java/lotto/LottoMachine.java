package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<Lotto>();

    public LottoMachine(int money) {
        purchaseLottos(money);
    }

    private void purchaseLottos(int money) {
        int numberOfLottos = money / LOTTO_PRICE;
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(Lotto.generateRandomLotto());
        }
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    private Map<LottoRank, Integer> calculateResults(List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> results = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbers);
            boolean hasBonusMatch = lotto.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.fromMatchCount(matchCount, hasBonusMatch);

            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }

        return results;
    }

    private int countMatchingNumbers(List<Integer> userNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : userNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public int checkWinning(List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> results = calculateResults(winningNumbers, bonusNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) {
                int count = results.getOrDefault(rank, 0);
                totalPrize += count * rank.getPrize();
                System.out.printf("%s - %d개%n", rank.getDescription(), results.getOrDefault(rank, 0));
            }
        }
        return totalPrize;
    }




}
