package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    private List<Lotto> tickets;

    public LottoPurchase(int amount) {
        Validator.validateAmount(amount);
        this.tickets = generateTickets(amount / 1000);
    }

    private List<Lotto> generateTickets(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(LottoNumbers.randomNumbers()));
        }
        return tickets;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

}
