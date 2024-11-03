package lotto.service;

import static lotto.constants.Constants.LOTTO_MAX;
import static lotto.constants.Constants.LOTTO_MIN;
import static lotto.constants.Constants.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.utils.RandomNumbersGenerator;

public class LottoBowl {
    private final Ticket ticket;

    private LottoBowl(Ticket ticket) {
        this.ticket = ticket;
    }

    public static LottoBowl from(Ticket ticket) {
        return new LottoBowl(ticket);
    }

    public Lotties publishLotties() {
        List<Lotto> lotties = new ArrayList<>();

        for (int i = 0; i < ticket.getTicket(); i++) {
            Lotto singleLotto = pickBalls();
            lotties.add(singleLotto);
        }

        return new Lotties(lotties);
    }

    private Lotto pickBalls() {
        List<Integer> numbers = RandomNumbersGenerator.getNumbers(LOTTO_MIN, LOTTO_MAX, LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
