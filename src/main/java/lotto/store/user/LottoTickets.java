package lotto.store.user;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottos;

    private LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets from(List<Lotto> lottos) {
        return new LottoTickets(lottos);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
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
