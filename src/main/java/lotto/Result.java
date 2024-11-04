package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Result {
    private final List<Lotto> tickets;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public Result(List<Lotto> tickets, Lotto winningLotto, int bonusNumber) {
        this.tickets = tickets;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void print() {

        Map<Rank, Long> stats = new HashMap<>();

        for (Rank rank :  Rank.values()){
            stats.put(rank, 0L);
        }

        tickets.stream()
                .map(this::getRank)
                .filter(Objects::nonNull)
                .forEach(rank -> stats.put(rank, stats.get(rank) + 1));

        stats.forEach((rank, count) -> System.out.println(rank.formatOutput(count)));

        double rate = calculateRate(stats);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }

    private Rank getRank(Lotto ticket){
        long matchCount = ticket.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();

        boolean matchBonus = ticket.getNumbers().contains(bonusNumber);

        return Rank.valueOf((int) matchCount, matchBonus);
    }

    private double calculateRate(Map<Rank, Long> stats){
        long totalPrize = stats.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        long totalCost = tickets.size() * 1000L;
        return (double) totalPrize / totalCost * 100;
    }
}
