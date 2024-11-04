package lotto;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class LottoCollection {
    private final List<Lotto> tickets;
    private final Map<Rank, Integer> result;

    public LottoCollection(int num) {
        this.tickets = new ArrayList<>();
        this.result = new HashMap<>();

        for (int index = 0; index < num; index++) {
            tickets.add(new Lotto());
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    // check result of Lotteries
    public void checkResult(Lotto winningLotto, int bonus) {
        result.clear();

        for (Lotto lottery : tickets) {
            int matchCount = lottery.countMatchingNumbers(winningLotto);
            boolean checkBonus = matchCount == 5 && lottery.containBonusNumber(bonus);

            Rank rank = Rank.searchRank(matchCount, checkBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }
}
