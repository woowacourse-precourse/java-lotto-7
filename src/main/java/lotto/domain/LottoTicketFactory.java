package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoNumberGenerator;

public class LottoTicketFactory {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoTicketFactory(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> generateLottoTickets(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int ticketIndex = 0; ticketIndex < ticketCount; ticketIndex++) {
            lottos.add(new Lotto(lottoNumberGenerator.generator()));
        }

        return lottos;
    }
}
