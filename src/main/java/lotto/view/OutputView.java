package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OutputView extends View {

    private final int FIRST_PRIZE = 1;
    private final int LAST_PRIZE = 5;
    private final int LOTTO_PRICE = 1000;
    private final List<Integer> WINNER_PRIZE = new ArrayList<>(
            List.of(2000000000,
                    30000000,
                    1500000,
                    50000,
                    5000)
    );

    public void printLottos(List<Lotto> lottos) {
        br();
        System.out.println(lottos.size() + PURCHASE_PROMPT);

        for (Lotto lotto : lottos) {
            List<Integer> sortedNumber = new ArrayList<>(lotto.numbers()).stream().sorted().toList();
            System.out.println(sortedNumber);
        }
    }

    public void printStats(Map<Integer, Integer> resultMap) {
        br();
        System.out.println(STATISTICS_PROMPT);
        System.out.println(THREE_DASH_PROMPT);

        for (int prize = LAST_PRIZE; prize >= FIRST_PRIZE; prize--) {
            int count = nullToZero(resultMap.get(prize));
            System.out.println(MATCH_PROMPTS.get(prize - 1) + count + COUNT_PROMPT);
        }
    }

    public void printProfit(List<Lotto> lottos, Map<Integer, Integer> resultMap) {
        int totalPrize = calculateTotalPrize(resultMap);
        int totalAmount = lottos.size() * LOTTO_PRICE;
        double profit = (double) totalPrize / totalAmount * 100;

        System.out.printf(PROFIT_PROMPT, profit);
    }

    private int calculateTotalPrize(Map<Integer, Integer> resultMap) {
        int totalPrize = 0;

        for (int prize = LAST_PRIZE; prize >= FIRST_PRIZE; prize--) {
            int count = nullToZero(resultMap.get(prize));
            totalPrize += WINNER_PRIZE.get(prize - 1) * count;
        }

        return totalPrize;
    }

    private int nullToZero(Integer count) {
        return Optional.ofNullable(count).orElse(0);
    }

}
