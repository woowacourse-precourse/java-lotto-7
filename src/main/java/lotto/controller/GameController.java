package lotto.controller;


import lotto.helper.handler.InputHandler;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.model.LottoTicket;
import lotto.model.WinningLotto;
import lotto.view.output.OutputView;

public class GameController {

    private final LottoMachine lottoMachine;
    private final InputHandler inputHandler;
    private final OutputView outputView;

    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    public GameController(LottoMachine lottoMachine, InputHandler inputHandler, OutputView outputView) {
        this.lottoMachine = lottoMachine;
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void run() {
        purchaseAndViewLottoTicket();
        generateWinningLotto();
        calculateAndViewResult();
    }

    private void purchaseAndViewLottoTicket() {
        int money = inputHandler.inputMoney();
        lottoTicket = lottoMachine.purchaseTicket(money);
        outputView.outputLottoNumbers(lottoTicket);
    }

    private void generateWinningLotto() {
        Lotto winLotto = inputHandler.inputLottoNumbers();
        Bonus bonusNumber = inputHandler.inputBonusNumber(winLotto.getNumbers());
        winningLotto = new WinningLotto(winLotto, bonusNumber);
    }

    private void calculateAndViewResult() {
        lottoResult = new LottoResult(lottoTicket.getPrice());
        lottoTicket.getLottos().stream()
                        .forEach(lotto -> lottoResult.recordResult(winningLotto, lotto));
        outputView.outputRankSummary(lottoResult.getResultRank(), lottoResult.calculateProfitRate());
    }

}
