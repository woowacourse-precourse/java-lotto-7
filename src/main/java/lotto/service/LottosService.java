package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottosService {

    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int COUNT_ZERO = 0;

    public static List<Lotto> lottos(int purchaseTickets) {
        List<Lotto> lottos = new ArrayList<>();
        int count = COUNT_ZERO;
        for (; count < purchaseTickets; count++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(NUM_MIN, NUM_MAX, LOTTO_SIZE);
        return numbers;
    }

}
