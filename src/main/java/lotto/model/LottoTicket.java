package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return ticket.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
