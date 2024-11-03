package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.budget.Budget;
import lotto.model.win.Prize;

public class LottoResultBuilder {
    private final List<Prize> prizes;
    private final double HALF_UP = 10.0d;
    private Budget budget;

    public LottoResultBuilder() {
        prizes = new ArrayList<>();
    }

    public LottoResultBuilder budget(Budget budget) {
        this.budget = budget;
        return this;
    }

    public LottoResultBuilder addAllPrize(List<Prize> list) {
        prizes.addAll(list);
        return this;
    }

    private double calculateRate() {
        int totalBudget = budget.money();
        int totalMoney = prizes.stream()
                .map(prize -> prize.money)
                .reduce(0, Integer::sum);

        double profitRate = totalMoney / (double) totalBudget * 100;
        return (Math.round(profitRate * HALF_UP) / HALF_UP);
    }

    private Map<Prize, Long> createTable() {
        return prizes.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
    }

    public LottoResult build() {
        double rate = calculateRate();
        Map<Prize, Long> resultTable = createTable();
        return new LottoResult(rate, resultTable);
    }
}
