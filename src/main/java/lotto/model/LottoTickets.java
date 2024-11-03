package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.constant.prize.Prize;

public record LottoTickets(List<Lotto> tickets) {
    public Map<Prize, Integer> aggregateWinningResult(final WinningNumbers winningNumbers) {
        Map<Prize, Integer> result = initializeResult();
        tickets.stream()
                .map(winningNumbers::checkPrize)
                .filter(prize -> prize != Prize.NON)
                .forEach(prize -> increasePrizeCount(result, prize));
        return result;
    }

    private Map<Prize, Integer> initializeResult() {
        Map<Prize, Integer> result = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NON) {
                result.put(prize, 0);
            }
        }
        return result;
    }

    private void increasePrizeCount(final Map<Prize, Integer> result, final Prize prize) {
        result.replace(prize, result.get(prize) + 1);
    }
}
