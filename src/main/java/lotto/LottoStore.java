package lotto;

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
        
        return new WinningLotto(lotto, bonusNumber);
    }

    private void showStatistics(WinningLotto winningLotto, Cash cash) {
        statisticalMachine.calculate(lottoMachine.currentLottoTickets(), winningLotto);
        outputView.printWinningStatistics(statisticalMachine);
        outputView.printTotalProfit(statisticalMachine.getTotalProfit(cash));
    }

}
