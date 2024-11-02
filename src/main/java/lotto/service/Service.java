package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.LottosValidation;

public class Service {

    private static final int TICKET_COST = 1000;
    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int COUNT_ZERO = 0;

    public static int purchaseTickets(int amount) {
        int purchaseTickets = amount / TICKET_COST;
        return purchaseTickets;
    }

    public static List<Lotto> lottos(int purchaseTickets) {
        List<Lotto> lottos = new ArrayList<>();
        int count = COUNT_ZERO;
        for (; count < purchaseTickets; count++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        LottosValidation.lottosValidation(purchaseTickets, lottos);
        return lottos;
    }

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(NUM_MIN, NUM_MAX, LOTTO_SIZE);
        return numbers;
    }

}
