package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<List<Integer>> lottoTickets;

    public LottoTickets(int ticket) {
        List<List<Integer>> lottoTickets = new ArrayList<>();
        for (int count = 0; count < ticket; count++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottoTickets.add(numbers);
        }
        this.lottoTickets = lottoTickets;
    }

    public List<List<Integer>> getLottoTickets() {
        return lottoTickets;
    }
}
