package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> ticket;

    public LottoTicket(List<Lotto> ticket) {
        this.ticket = ticket;
    }

    public static LottoTicket of(int amount) {
        List<Lotto> temp = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            temp.add(new Lotto(Lotto.generate()));
        }
        return new LottoTicket(temp);
    }

    public List<Lotto> getTicket() {
        return ticket;
    }
}
