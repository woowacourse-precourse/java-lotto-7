package lotto.presentation;

import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class LottoController {

  private final LottoInputController inputController = new LottoInputController();
  private final LottoTicketController ticketController = new LottoTicketController();
  private final LottoResultController resultController = new LottoResultController();

  public void run() {
    int purchaseAmount = inputController.getValidatedPurchaseAmount();
    LottoTicket lottoTicket = ticketController.createLottoTickets(purchaseAmount);

    List<Integer> winningNumbers = inputController.getValidatedWinningNumbers();
    int bonusNumber = inputController.getValidatedBonusNumber(winningNumbers);
    WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

    Map<Rank, Long> rankResults = resultController.calculateRanks(lottoTicket, winningLotto);
    resultController.displayResults(rankResults, purchaseAmount);
  }
}
