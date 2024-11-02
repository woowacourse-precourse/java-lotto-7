package lotto.application;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoNumberGeneratorService;
import lotto.service.LottoTicketBuyingService;
import lotto.service.LottoTicketIssueService;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;


    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String buyingPrice = inputView.startLottoGameAndReadBuyingPrice();
        Integer lottoTicketAmount = LottoTicketBuyingService.buyingLottoTicket(buyingPrice);
        LottoNumberGeneratorService lottoNumberGeneratorService = new LottoNumberGeneratorService();
        LottoTicketIssueService lottoTicketIssueService = new LottoTicketIssueService(lottoTicketAmount,
                lottoNumberGeneratorService);
        List<Lotto> issuedLotto = lottoTicketIssueService.issueLotto();

    }
}
