package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.generator.LottoNumberGenerator;

public class LottoTicket {
    private final List<Lotto> ticket;

    public LottoTicket(Money money) {
        int count = money.calculateLottoTickets();
        this.ticket = generateTicket(count);
    }

    private List<Lotto> generateTicket(int count) {
        List<Lotto> tickets = new ArrayList<>();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto(lottoNumberGenerator.generate()));
        }
        return tickets;
    }

    public List<Lotto> getLottos() {
        return ticket;
    }
}
