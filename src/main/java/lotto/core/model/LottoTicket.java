package lotto.core.model;

import java.util.List;
import lotto.core.dto.LottoTicketDto;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket dtoOf(LottoTicketDto dto) {
        List<Lotto> lottos = dto.lottos().stream().map(Lotto::dtoOf).toList();
        return new LottoTicket(lottos);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int count() {
        return this.lottos.size();
    }
}
