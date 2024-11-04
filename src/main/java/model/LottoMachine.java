package model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public void buyLottoTickets(int money) {
        int ticketCount = money / 1000;
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new Lotto(Lotto.generateLottoNumbers()));
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}