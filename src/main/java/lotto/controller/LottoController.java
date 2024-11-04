package lotto.controller;

import lotto.enums.Ranking;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;
    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        Money money= moneyGenerate();
        outputView.printMoney(money.getMoney());

        List<Lotto> lottos = lottoService.lottosGenerate(money);

        for (Lotto lotto : lottos) {
            outputView.printLotto(lotto);
        }
        Lotto winningNumberLotto = winningNumberGenerate();
        BonusNumber bonusNumber = bonusNumberGenerate(winningNumberLotto);

        WinningNumber winningNumber = new WinningNumber(winningNumberLotto, bonusNumber);

        Map<Ranking, Integer> result = lottoService.compareLottosWithWinning(lottos,winningNumber);
        outputView.printResult(result);

        double returnRate = lottoService.calculateReturnRate(result, money);
        outputView.printReturnRate(returnRate);

    }

    private Lotto winningNumberGenerate() {
        while (true){
            try {
                return lottoService.lottoGenerate(inputView.readWinningNumber());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber bonusNumberGenerate(Lotto lotto) {
        while (true){
            try {
                return new BonusNumber(inputView.readBonusNum(),lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Money moneyGenerate() {
        while (true) {
            try {
                int moneyInput = inputView.readMoney();
                return lottoService.moneyGenerate(moneyInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
