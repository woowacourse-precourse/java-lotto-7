package lotto.interfaces.lotto;

import lotto.common.exception.LottoException;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoService;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.LottoMoney;
import lotto.domain.money.Revenue;
import lotto.domain.prize.LottoResult;
import lotto.domain.ticket.LottoTicket;
import lotto.interfaces.input.InputHandler;
import lotto.interfaces.output.OutputHandler;
import lotto.interfaces.prize.LottoResultResponse;
import lotto.interfaces.ticket.LottoTicketResponse;

public class LottoController {

    private final LottoService lottoService;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LottoController(LottoService lottoService, InputHandler inputHandler, OutputHandler outputHandler) {
        this.lottoService = lottoService;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void lottoGameStart() {
        LottoMoney lottoMoney = getLottoMoney();
        LottoTicket lottoTicket = lottoService.generateLottoTicket(lottoMoney.getLottoCount());
        outputHandler.printPurchasedLotto(LottoTicketResponse.from(lottoTicket));
        WinningLotto winningLotto = getWinningLotto();
        LottoResult lottoResult = lottoService.matchLottoTicket(lottoTicket, winningLotto);
        outputHandler.printLottoResult(LottoResultResponse.of(lottoResult, new Revenue(lottoResult, lottoMoney)));
    }

    private LottoMoney getLottoMoney() {
        while (true) {
            try {
                return inputHandler.readPurchaseAmount();
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto;
        while (true) {
            try {
                winningLotto = inputHandler.readWinningLotto();
                break;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
        LottoNumber bonusNumber;
        while (true) {
            try {
                bonusNumber = inputHandler.readBonusNumber();
                break;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
        return new WinningLotto(winningLotto, bonusNumber);
    }
}
