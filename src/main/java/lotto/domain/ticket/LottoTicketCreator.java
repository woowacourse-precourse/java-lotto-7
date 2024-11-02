package lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;

public class LottoTicketCreator {

    private final LottoGenerator lottoGenerator;

    public LottoTicketCreator(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoTicket createLottoTicket(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
        return new LottoTicket(lottos);
    }
}
