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
}
