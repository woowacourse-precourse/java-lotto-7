package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public Lotto generate() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public List<Lotto> generateTickets(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(generate());
        }
        return tickets;
    }
}
