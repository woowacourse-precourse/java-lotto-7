package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.Rank;

public class LottoService {
    private static LottoService instance;
    private final Map<Rank, Integer> winCount;

    private LottoService() {
        winCount = new HashMap<>();
        initWinCount();
    }

    public static LottoService getInstance() {
        if (instance == null) {
            instance = new LottoService();
        }

        return instance;
    }

    private void initWinCount() {
        winCount.put(Rank.FIRST_PLACE, 0);
        winCount.put(Rank.SECOND_PLACE, 0);
        winCount.put(Rank.THIRD_PLACE, 0);
        winCount.put(Rank.FOURTH_PLACE, 0);
        winCount.put(Rank.FIFTH_PLACE, 0);
    }

    public List<Lotto> purchaseLottoTickets(int price) {
        int count = price / 1000;
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(generateLottoNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .toList();
    }

    public Map<Rank, Integer> checkWinning(List<Lotto> tickets, List<Integer> winningNumbers, Integer bonusNumber) {
        initWinCount();
        for (Lotto ticket : tickets) {
            List<Integer> ticketNumbers = ticket.getNumbers();
            long matchCount = ticketNumbers.stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatched = ticketNumbers.contains(bonusNumber);

            updateWinCount(matchCount, bonusMatched);
        }

        return new HashMap<>(winCount);
    }

    private void updateWinCount(long matchCount, boolean bonusMatched) {
        if (matchCount == 6) {
            winCount.put(Rank.FIRST_PLACE, winCount.get(Rank.FIRST_PLACE) + 1);
        } else if (matchCount == 5 && bonusMatched) {
            winCount.put(Rank.SECOND_PLACE, winCount.get(Rank.SECOND_PLACE) + 1);
        } else if (matchCount == 5) {
            winCount.put(Rank.THIRD_PLACE, winCount.get(Rank.THIRD_PLACE) + 1);
        } else if (matchCount == 4) {
            winCount.put(Rank.FOURTH_PLACE, winCount.get(Rank.FOURTH_PLACE) + 1);
        } else if (matchCount == 3) {
            winCount.put(Rank.FIFTH_PLACE, winCount.get(Rank.FIFTH_PLACE) + 1);
        }
    }
}
