package lotto.dto;

import java.util.List;

public class LottoTicketStatus {

    List<LottoStatus> lottoStatuses;

    public LottoTicketStatus(List<LottoStatus> lottoStatuses) {
        this.lottoStatuses = lottoStatuses;
    }

    public List<LottoStatus> getLottoStatuses() {
        return lottoStatuses;
    }
}
