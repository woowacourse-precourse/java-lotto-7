package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public class PurchaseDTO {

    private final int totalCost;
    private final List<Lotto> lottoTickets;

    public PurchaseDTO(int totalCost, List<Lotto> lottoTickets) {
        this.totalCost = totalCost;
        this.lottoTickets = lottoTickets;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
