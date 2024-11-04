package lotto.dto;

import java.util.List;
import lotto.common.model.Lotto;

public class LottoTicketsDto {
    private static List<Lotto> LottoTickets;

    public static void set(List<Lotto> LottoTickets) {
        LottoTicketsDto.LottoTickets = LottoTickets;
    }

    public static List<Lotto> getLottoTickets() {
        return LottoTickets;
    }
}
