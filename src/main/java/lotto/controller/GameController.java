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

    private LottoMachine lottoMachine;
    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    public GameController() {
        this.lottoMachine = new LottoMachine();
    }

    public void run() {
        purchaseAndViewLottoTicket();
        generateWinningLotto();
        calculateAndViewResult();
    }

    public void purchaseAndViewLottoTicket() {
        int money = InputHandler.inputMoney();
        lottoTicket = lottoMachine.purchaseTicket(money);
        OutputView.outputLottoNumbers(lottoTicket);
    }

    public void generateWinningLotto() {
        Lotto winLotto = InputHandler.inputLottoNumbers();
        Bonus bonusNumber = InputHandler.inputBonusNumber(winLotto.getNumbers());
        winningLotto = new WinningLotto(winLotto, bonusNumber);
    }

    public void calculateAndViewResult() {
        lottoResult = new LottoResult(lottoTicket.getPrice());
        for (Lotto lotto : lottoTicket.getLottos()) {
            lottoResult.recordResult(winningLotto, lotto);
        }
        OutputView.outputRankSummary(lottoResult.getResultRank(), lottoResult.calculateProfitRate());
    }

}
