package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoTickets {
    List<Lotto> tickets;

    private LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets of(List<Lotto> tickets) {
        return new LottoTickets(tickets);
    }

    public int getCount() {
        return tickets.size();
    }

    public List<String> getLottoNumbers() {
        return tickets.stream()
                .map(Object::toString)
                .toList();
    }

    public Map<Integer, Integer> matchNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        rankMap.put(1, 0);
        rankMap.put(2, 0);
        rankMap.put(3, 0);
        rankMap.put(4, 0);
        rankMap.put(5, 0);
        for (int i = 0; i < tickets.size(); i++) {
            int rank = tickets.get(i).getRank(winningNumbers, bonusNumber);
            if (rank != 0) {
                rankMap.put(rank, rankMap.get(rank) + 1);
            }
        }
        return rankMap;
    }



}
