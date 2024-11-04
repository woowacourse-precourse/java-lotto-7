package lotto.store;

import lotto.console.InputHandler;
import lotto.console.OutputView;
import lotto.store.machine.LottoMachine;
import lotto.store.machine.StatisticalMachine;
import lotto.store.user.Lotto;
import lotto.store.winning.BonusNumber;
import lotto.store.winning.WinningLotto;
import lotto.store.user.Cash;

public class LottoStore {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputView outputView = new OutputView();
    private final LottoMachine lottoMachine = new LottoMachine();
    private final StatisticalMachine statisticalMachine = new StatisticalMachine();

    public void open() {
        Cash cash = purchaseLottoByCash();
        
        WinningLotto winningLotto = createWinningLotto();

        showStatistics(winningLotto, cash);
    }

    private Cash purchaseLottoByCash() {
        Cash cash = inputHandler.inputCash();
        lottoMachine.purchase(cash);
        outputView.printLottoTickets(lottoMachine);
        
        return cash;
    }

    private WinningLotto createWinningLotto() {
        Lotto lotto = inputHandler.inputWinningNumbers();
        BonusNumber bonusNumber = inputHandler.inputBonusNumber(lotto);
        
        return WinningLotto.of(lotto, bonusNumber);
    }

    private void showStatistics(WinningLotto winningLotto, Cash cash) {
        statisticalMachine.calculate(lottoMachine.currentLottoTickets(), winningLotto);
        outputView.printWinningStatistics(statisticalMachine);
        outputView.printTotalProfit(statisticalMachine.getTotalProfit(cash));
    }

}
