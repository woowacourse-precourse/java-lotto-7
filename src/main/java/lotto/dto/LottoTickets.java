package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public record LottoTickets(
        List<Lotto> tickets
) {

    public int size() {
        return tickets.size();
    }
}
