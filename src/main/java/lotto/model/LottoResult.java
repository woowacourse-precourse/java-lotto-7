package lotto.model;

import java.util.List;

public class LottoResult {
    private final List<Prize> prizes;

    public LottoResult(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<Prize> getResult() {
        return prizes.stream().toList();
    }

    public long calculateTotalProfit() {
        return this.prizes.stream().mapToLong(prize -> prize.getMoney()).sum();
    }

    public int getLottoCount() {
        return prizes.size();
    }
}
