package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {
    private final Map<String, Integer> hitResult;

    public Result(Lotto winningLotto, int bonusNumber, List<Lotto> userTickets) {
        this.hitResult = createResult(winningLotto, bonusNumber, userTickets);
    }

    private Map<String, Integer> createResult(Lotto winningLotto, int bonusNumber, List<Lotto> userTickets) {
        Map<String, Integer> hitResult = new HashMap<>();

        for (Lotto ticket : userTickets) {
            int hitCount = getHitCount(winningLotto, ticket);
            boolean bonusHit = getBonusHit(bonusNumber, ticket);
            rankingCount(hitCount, bonusHit, hitResult);
        }

        return hitResult;
    }

    private int getHitCount(Lotto winningLotto, Lotto ticket) {
        return (int) ticket.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
    }

    private boolean getBonusHit(int bonusNumber, Lotto ticket) {
        return ticket.getNumbers().contains(bonusNumber);
    }

    private void rankingCount(int hitCount, boolean bonusHit, Map<String, Integer> hitResult) {
        String rankName = Ranking.getEnumName(hitCount, bonusHit);
        hitResult.put(rankName, hitResult.getOrDefault(rankName, 0) + 1);
    }

    public String getResult() {
        return Arrays.stream(Ranking.values())
                .filter(rank -> !rank.name().equals(Ranking.NO_RANK.name()))
                .map(rank -> rank.getRankingMessage(this.hitResult.getOrDefault(rank.name(), 0)))
                .collect(Collectors.joining("\n"));
    }

    public String calculateStatistic(int purchaseAmount) {
        double percentage = getTotalPrize() / purchaseAmount * 100;
        return String.format("%.1f", percentage);
    }

    private double getTotalPrize() {
        return Arrays.stream(Ranking.values())
                .filter(rank -> !rank.name().equals(Ranking.NO_RANK.name()))
                .mapToDouble(rank -> rank.getPrize() * this.hitResult.getOrDefault(rank.name(), 0))
                .sum();
    }

    public Map<String, Integer> getHitResult() {
        return this.hitResult;
    }
}
