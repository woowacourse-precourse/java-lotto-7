package lotto.controller;

import lotto.domain.BallNumber;
import lotto.domain.LottoTickets;
import lotto.domain.Winning;
import lotto.service.InputProcessor;
import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputProcessor inputProcessor;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputProcessor = new InputProcessor();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        LottoTickets lottoTickets = getLottoTickets();
        BallNumber ballNumber = getBallNumber();
        processLotto(lottoTickets, ballNumber);
    }

    private LottoTickets getLottoTickets() {
        LottoTickets lottoTickets = inputProcessor.parsePurchaseAmount();
        outputView.printIssuedLottos(lottoTickets);

        return lottoTickets;
    }

    private BallNumber getBallNumber() {
        List<Integer> winningNumbers = inputProcessor.parseWinningNumbers();
        int bonusNumber = inputProcessor.parseBonusNumber(winningNumbers);
        return new BallNumber(winningNumbers, bonusNumber);
    }

    private void processLotto(LottoTickets lottoTickets, BallNumber ballNumber) {
        Winning winning = lottoService.countWinning(lottoTickets, ballNumber);
        double rateOfReturn = lottoService.calculateRateOfReturn(lottoTickets, winning);

        outputView.printResult(winning, rateOfReturn);
    }

}
