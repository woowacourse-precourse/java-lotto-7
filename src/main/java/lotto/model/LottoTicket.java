package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoStatus;
import lotto.dto.LottoTicketStatus;

public class LottoTicket {
    List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public LottoTicketStatus getLottoTicketStatus() {

        List<LottoStatus> lottoStatuses = new ArrayList<>();
        lottos.stream()
                .map(Lotto::getStatus)
                .forEach(lottoStatuses::add);

        return new LottoTicketStatus(lottoStatuses);
    }
}
