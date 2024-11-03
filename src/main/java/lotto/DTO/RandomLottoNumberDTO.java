package lotto.DTO;

import lotto.Domain.LottoTickets;

public class RandomLottoNumberDTO {
    private LottoTickets lottoTickets;

    public RandomLottoNumberDTO(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }
}
