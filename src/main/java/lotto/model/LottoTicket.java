package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoStatus;
import lotto.dto.LottoTicketStatus;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public LottoTicketStatus getLottoTicketStatus() {

        List<LottoStatus> lottoStatuses = lottos.stream()
                .map(Lotto::getStatus)
                .collect(Collectors.toList());

        return new LottoTicketStatus(lottoStatuses);
    }
}
