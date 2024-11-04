package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.LottoSimulatorValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSimulator {
    private final static int PRICE_OF_SINGLE_LOTTO = 1000;
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 45;
    private final static int COUNT_OF_NUMBER = 6;
    private final static int DEFAULT = 0;
    private final static int PERCENT_CONSTANT = 100;
    private final int cost;
    private List<Lotto> purchasedLotto;
    private Map<Integer, Integer> prizeResult;

    public LottoSimulator(String cost) {
        validateCost(cost);
        this.cost = Integer.parseInt(cost);
        purchasedLotto = new ArrayList<>();
        prizeResult = new HashMap<>();
    }

    public void buyRandomLotto() {
        int count = cost / PRICE_OF_SINGLE_LOTTO;
        purchasedLotto.addAll(
                IntStream.range(0, count)
                        .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_OF_NUMBER)))
                        .collect(Collectors.toList())
        );
    }

    public void countPrize(Draw draw) {
        for (int i = 0; i < purchasedLotto.size(); i++) {
            int count = purchasedLotto.get(i).checkLotto(draw.getWinningNumbers());
            boolean bonus = purchasedLotto.get(i).checkBonus(draw.getBonusNumber());
            Prize prize = Prize.findPrizeByCountAndBonus(count, bonus);

            if (prize != null) {
                prizeResult.put(prize.rank, prizeResult.getOrDefault(prize.rank, DEFAULT) + 1);
            }
        }
    }

    public double checkProfitRate() {
        double sum = 0;
        for (int i = Prize.FIRST_PRIZE.rank; i <= Prize.FIFTH_PRIZE.rank; i++) {
            double count = 0;
            if (prizeResult.containsKey(i)) {
                count = prizeResult.get(i);
            }
            sum += count * Prize.findPrizeByRank(i).jackpot;
        }
        return (sum / cost) * PERCENT_CONSTANT;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public Map<Integer, Integer> getPrizeResult() {
        return prizeResult;
    }

    private void validateCost(String cost){
        LottoSimulatorValidation.validateCostFormat(cost);
        LottoSimulatorValidation.validateLottoCost(cost);
    }
}
