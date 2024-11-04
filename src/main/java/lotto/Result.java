package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<String, Integer> hitResult;

    public Result(Lotto winningLotto, int bonusNumber, List<Lotto> userTickets) {
        Map<String, Integer> hitResult = createResult(winningLotto, bonusNumber, userTickets);
        this.hitResult = hitResult;
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

    public Map<String, Integer> getHitResult() {
        return this.hitResult;
    }
}
