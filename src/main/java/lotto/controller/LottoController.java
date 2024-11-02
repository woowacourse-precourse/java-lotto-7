package lotto.controller;

import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    private final LottoService lottoService;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView, LottoService lottoService) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoTicket lottoTicket = buyLottoTicket();
        lottoOutputView.printLottoCount(lottoTicket.getLottosCount());
        lottoOutputView.printLottoTicket(lottoTicket.getLottoTicketNumbers());

        WinningLotto winningLotto = makeWinningNumber();
        addBunusNumber(winningLotto);

        LottoResult lottoResult = compareLottoTicketWithWinningLotto(lottoTicket, winningLotto);
        double totalEarnings = lottoService.calculateEarnings(lottoResult.getRankResults(), lottoTicket);
        lottoOutputView.printLottoResult(lottoResult.getRankResults(), totalEarnings);
    }

    private LottoResult compareLottoTicketWithWinningLotto(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return lottoService.compareLotto(lottoTicket, winningLotto);
    }

    private void addBunusNumber(WinningLotto winningLotto) {
        while (true) {
            try {
                String bonusNumber = lottoInputView.getBonusNumber();
                lottoService.addBonusNumber(winningLotto, bonusNumber);
                return ;
            } catch (IllegalArgumentException exception) {
                lottoOutputView.printExceptionMessage(exception);
            }
        }
    }

    private WinningLotto makeWinningNumber() {
        while (true) {
            try {
                String winningNumber = lottoInputView.getWinningNumber();
                return lottoService.createWinningLotto(winningNumber);
            } catch (IllegalArgumentException exception) {
                lottoOutputView.printExceptionMessage(exception);
            }
        }
    }

    private LottoTicket buyLottoTicket() {
        while (true) {
            try {
                String purchaseMoney = lottoInputView.getLottoPurchaseMoney();
                return lottoService.createLottoTicket(purchaseMoney);
            } catch (IllegalArgumentException exception) {
                lottoOutputView.printExceptionMessage(exception);
            }
        }
    }
}
