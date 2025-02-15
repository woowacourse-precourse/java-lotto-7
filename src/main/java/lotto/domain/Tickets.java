package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import lotto.constant.GlobalConstant;

public class Tickets {

    private final List<Lotto> tickets;

    public Tickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public int getTicketAmount() {
        return tickets.size();
    }

    public List<Lotto> getUnmodifiableTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public TotalResult compareTicketsToWinningInfo(WinningInfo winningInfo) {
        EnumMap<Reward, Integer> totalResult = new EnumMap<>(Reward.class);
        Arrays.stream(Reward.values()).forEach(reward -> totalResult.put(reward, GlobalConstant.INIT_VAL.getValue()));
        tickets.forEach(ticket -> {
            Result result = ticket.compareToWinningInfo(winningInfo);
            totalResult.keySet()
                    .forEach(reward -> updateTotalResult(totalResult, reward, result.isCountSameAsReward(reward)));
        });

        return new TotalResult(totalResult);
    }

    private void updateTotalResult(EnumMap<Reward, Integer> totalResult, Reward reward, boolean isCountSameAsReward) {
        if (isCountSameAsReward) {
            int preVal = totalResult.get(reward);
            totalResult.put(reward, ++preVal);
        }
    }
}
