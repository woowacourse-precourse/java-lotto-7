package lotto.dto;

import java.util.List;

public class LottoTicketStatus {

    private final List<LottoStatus> lottoStatuses;
    private final int purchaseAmount;

    public LottoTicketStatus(List<LottoStatus> lottoStatuses, int purchaseAmount) {
        this.lottoStatuses = lottoStatuses;
        this.purchaseAmount = purchaseAmount;
    }

    public List<LottoStatus> getLottoStatuses() {
        return lottoStatuses;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
