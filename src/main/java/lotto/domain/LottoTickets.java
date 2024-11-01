package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;
    private final List<Lotto> lottoTickets;

    public LottoTickets(int numberOfTickets) {
        this.lottoTickets = createLottoTickets(numberOfTickets);
    }

    private List<Lotto> createLottoTickets(int numberOfTickets) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> randoms = Randoms.pickUniqueNumbersInRange(START, END, COUNT);
            tickets.add(new Lotto(randoms));
        }

        return tickets;
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
