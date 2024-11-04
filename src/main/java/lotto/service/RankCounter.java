package lotto.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Ticket;
import lotto.util.BonusCondition;
import lotto.util.Ranks;

/**
 * 등수를 카운트한 리스트 반환 : [꽝, 1등, 2등, 3등, 4등, 5등]
 */
public class RankCounter {

    private final List<Ticket> tickets;
    private final Lotto lotto;
    private final Bonus bonus;


    public RankCounter(List<Ticket> tickets, Lotto lotto, Bonus bonus) {
        this.tickets = tickets;
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public List<Long> getRankCount() {
        List<Long> rankCount = Stream.generate(() -> 0L)
                .limit(Ranks.values().length)
                .collect(Collectors.toList());

        for (Ticket ticket : tickets) {
            Ranks rank = getRank(ticket);
            rankCount.set(rank.getNumber(), rankCount.get(rank.getNumber()) + 1);
        }

        return rankCount;
    }

    private Ranks getRank(Ticket ticket) {
        int matchCount = getMatchCount(ticket);
        BonusCondition isBonus = BonusCondition.NOT_APPLICABLE;

        if (matchCount == Ranks.FIFTH.getNumber()) {
            isBonus = getBonusCondition(ticket);
        }

        for (Ranks rank : Ranks.values()) {
            if (rank.getMatchCount() == matchCount && rank.getBonusCondition() == isBonus) {
                return rank;
            }
        }

        return Ranks.NO_WIN;
    }

    private int getMatchCount(Ticket ticket) {
        return (int) ticket.getNumbers().stream()
                .filter(number -> lotto.getNumbers().stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private BonusCondition getBonusCondition(Ticket ticket) {
        if (ticket.getNumbers().stream().anyMatch(n -> n.equals(bonus.getNumber()))) {
            return BonusCondition.WIN;
        }

        return BonusCondition.LOSE;
    }


}
