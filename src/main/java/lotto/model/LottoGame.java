package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;
    private Map<Prize, Integer> results = new HashMap<>();

    public LottoGame(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Prize, Integer> getResult() {
        for (Lotto lotto : lottos) {
            Prize result = lotto.checkResult(winningNumbers, bonusNumber);
            results.put(result, results.getOrDefault(result, 0) + 1);
        }

        return results;
    }

    public double getProfitRate() {
        Integer totalPrize = Prize.calculatePrize(results);
        Integer usedMoney = 1000 * lottos.size();

        return (double) totalPrize / usedMoney;
    }
}
