package lotto;

import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getTicketCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos) {
            sb.append("[")
                .append(lotto.toString())
                .append("]")
                .append("\n");
        }

        return sb.toString();
    }
}
