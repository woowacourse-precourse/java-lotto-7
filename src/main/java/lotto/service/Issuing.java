package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class Issuing {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MAX_SIZE = 6;

    public static void lottoTickets(LottoTicket ticket) {
        for (int i = 0; i < ticket.getCount(); i++) {
            ticket.addLottoTicket(randomLotto());
        }
    }

    private static Lotto randomLotto() {
        List<Integer> numbers = new ArrayList<>(
            Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, MAX_SIZE));
        return new Lotto(numbers);
    }
}
