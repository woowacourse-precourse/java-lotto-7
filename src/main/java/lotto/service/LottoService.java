package lotto.service;

import lotto.calculation.LottoTicketManager;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.List;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoTicketManager lottoTicketManager;

    public LottoService(LottoGenerator lottoGenerator, LottoTicketManager ticketCalculator) {
        this.lottoGenerator = lottoGenerator;
        this.lottoTicketManager = ticketCalculator;
    }

    public List<Lotto> generateLottos(int amount) {
        return lottoGenerator.generateLotto(lottoTicketManager.calculateTicketCount(amount));
    }
}