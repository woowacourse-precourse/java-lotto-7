package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class Ticket {
    private final List<Lotto> lottos;
    private final int price;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final EnumMap<Prize, Integer> result;

    public Ticket(List<Lotto> lottos, int price, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.price = price;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.result = makeResult();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public EnumMap<Prize, Integer> getResult() {
        return this.result;
    }

    public double getEarningRate() {
        int totalPrize = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();

        double earningRate = (double) totalPrize / price;
        return Math.round(earningRate * 1000) / 10.0;
    }

    private EnumMap<Prize, Integer> makeResult() {
        EnumMap<Prize, Integer> result = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values()).forEach(prize -> result.put(prize, 0));

        lottos.forEach(lotto -> {
            Prize prize = Prize.getPrize(lotto, winningNumbers, bonusNumber);
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        });

        return result;
    }
}
