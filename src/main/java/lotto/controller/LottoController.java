package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Money;
import lotto.model.PrizeStatistics;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import lotto.service.LottoService;
import view.InputView;
import view.OutputView;
import view.exception.LottoException;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        InputView inputView = new InputView(Console::readLine);
        OutputView outputView = new OutputView();

        boolean isContinue = true;
        Money money = null;
        while (isContinue) {
            try {
                int moneyInput = inputView.chargeMoneyInput();
                money = new Money(moneyInput);
                isContinue = false;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Lotto> purchasedLottos = lottoService.createLotto(money);
        outputView.printLottos(purchasedLottos);

        isContinue = true;
        Lotto winningLottoNums = null;
        while (isContinue) {
            try {
                List<Integer> winningNumber = inputView.winningNumberInput();
                winningLottoNums = new Lotto(winningNumber);
                isContinue = false;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }

        isContinue = true;
        BonusNumber bonusNum = null;
        while (isContinue) {
            try {
                int bonusNumber = inputView.bonusNumberInput();
                bonusNum = new BonusNumber(bonusNumber);
                isContinue = false;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }

//        Console.close();

        WinningLotto winningLotto = WinningLotto.createWinningLotto(winningLottoNums, bonusNum);

        PrizeStatistics prizeStatistics = lottoService.calculateStatistics(purchasedLottos, winningLotto);
        outputView.printWinning(prizeStatistics);

        double ratio = lottoService.calculateProfitRatio(money, prizeStatistics);
        outputView.printRatio(ratio);
    }
}
