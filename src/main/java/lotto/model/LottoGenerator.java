package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static List<Integer> generate() {
        List<Integer> lotto = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(1, 45, 6));

        Collections.sort(lotto);
        return lotto;
    }

    public static List<List<Integer>> makeTickets(int amount) {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tickets.add(new ArrayList<>(generate()));
        }

        return tickets;
    }
}
