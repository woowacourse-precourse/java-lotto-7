package lotto.presentation;

import lotto.application.LottoService;
import lotto.domain.LottoTicket;
import lotto.view.OutputLottoView;

public class LottoTicketController {

  private final LottoService lottoService = new LottoService();

  public LottoTicket createLottoTickets(int purchaseAmount) {
    LottoTicket lottoTicket = lottoService.generateLottoTickets(purchaseAmount);
    OutputLottoView.printPurchasedTickets(lottoTicket.getTickets());
    return lottoTicket;
  }
}
