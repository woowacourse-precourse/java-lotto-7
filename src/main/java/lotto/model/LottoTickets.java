package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constants.PrizeRank;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(int amount) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottoTickets.add(generateLottoTicket());
        }

        this.lottoTickets = lottoTickets;
    }

    private Lotto generateLottoTicket() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        Collections.sort(randomNumbers);

        return new Lotto(randomNumbers);
    }

    public List<List<Integer>> getLottoTicketsNumbers() {
        List<List<Integer>> lottoTicketsNumbers = new ArrayList<>();

        for (Lotto lotto : lottoTickets) {
            lottoTicketsNumbers.add(lotto.getNumbers());
        }

        return lottoTicketsNumbers;
    }

    public Map<PrizeRank, Integer> getPrizeRankCountMap(WinningLotto winningLotto) {
        Map<PrizeRank, Integer> prizeRankCountMap = lottoTickets.stream()
                .map(lotto -> lotto.getPrizeRank(winningLotto))
                .collect(Collectors.groupingBy(prizeRank -> prizeRank, Collectors.summingInt(rank -> 1)));

        prizeRankCountMap.remove(PrizeRank.MATCH_FAIL);

        return prizeRankCountMap;
    }
}
