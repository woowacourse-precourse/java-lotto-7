package lotto.controller;

import lotto.service.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.util.NumberGenerate;
import lotto.domain.BonusBall;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerate lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = new LottoMachine(lottoGenerator);
    }

    public void run() {
        PurchasedLottos purchasedLotto = inputMoney();

        outputView.showHowManyLotto(purchasedLotto);
        outputView.showAllLottoNums(purchasedLotto);

        WinningLotto winningLotto = createWinningLotto();

        LottoResult lottoResult = lottoMachine.calculateLottoWins(purchasedLotto, winningLotto);

        outputView.showWinStatus(lottoResult);
        outputView.showProfit(lottoResult, lottoMachine.inMoney());
    }

    private WinningLotto createWinningLotto() {
        Lotto lotto = inputLottoNumbers();

        while (true) {
            try {
                BonusBall bonusBall = inputBonusNumber();
                return new WinningLotto(lotto, bonusBall);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusBall inputBonusNumber() {
        while (true) {
            try {
                return new BonusBall(inputView.lottoBonusNumInput());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto inputLottoNumbers() {
        while (true) {
            try {
                String[] rawNumbers = inputView.lottoNumsInput();
                return new Lotto(rawNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PurchasedLottos inputMoney() {
        while (true) {
            try {
                int money = inputView.lottoMoneyInput();
                return lottoMachine.issueLotto(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
