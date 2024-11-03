package lotto.service;

import lotto.factory.LottoMachine;
import lotto.model.*;

public class LottoService {
    private final LottoMachine lottoMachine;
    private final LottoBuyer buyer;

    public LottoService(LottoBuyer buyer, LottoMachine lottoMachine) {
        this.buyer = buyer;
        this.lottoMachine = lottoMachine;
    }

    public LottoTickets buyLottoTickets(Money money) {
        return buyer.buyLottoTickets(lottoMachine, money);
    }

    public WinningAnalysisReport createWinningReport(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        return WinningAnalysisReport.builder()
                .withLottoTickets(lottoTickets)
                .withWinningNumbers(winningNumbers)
                .build();
    }
}
