package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private final int amount;
    private final List<Lotto> lottoTickets;

    public Purchase(int amount) {
        this.amount = amount;
        this.lottoTickets = createLottoTickets();
    }

    public int getPurchaseAmount() {
        return amount;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }



    private List<Lotto> createLottoTickets() {
        List<Lotto> tickets = new ArrayList<>();
        int numberOfTickets = getPurchaseAmount() / 1000;
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(new Lotto());
        }
        return tickets;
    }
}
