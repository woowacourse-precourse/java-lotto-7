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
import java.util.function.Function;
import java.util.function.Supplier;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        InputView inputView = new InputView(Console::readLine);
        OutputView outputView = new OutputView();

        Money money = repeatLoop(() -> {
            int moneyInput = inputView.chargeMoneyInput();;
            return new Money(moneyInput);
        });

        List<Lotto> purchasedLottos = lottoService.createLotto(money);
        outputView.printLottos(purchasedLottos);

        Lotto winningLottoNums = repeatLoop(() -> {
            List<Integer> winningNumber = inputView.winningNumberInput();
            return new Lotto(winningNumber);
        });

        WinningLotto winningLotto = repeatLoop(() -> {
            int bonusNumber = inputView.bonusNumberInput();
            BonusNumber bonusNum = new BonusNumber(bonusNumber);
            return WinningLotto.createWinningLotto(winningLottoNums, bonusNum);
        });

//        Console.close();

        PrizeStatistics prizeStatistics = lottoService.calculateStatistics(purchasedLottos, winningLotto);
        outputView.printWinning(prizeStatistics);

        double ratio = lottoService.calculateProfitRatio(money, prizeStatistics);
        outputView.printRatio(ratio);
    }

    private <T> T repeatLoop(Supplier<T> inputFunction) {
        try {
            return inputFunction.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatLoop(inputFunction);
        }
    }
}
