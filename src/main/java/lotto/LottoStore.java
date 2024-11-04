package lotto;

public class LottoStore {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputView outputView = new OutputView();
    private final LottoMachine lottoMachine = new LottoMachine();
    private final StatisticalMachine statisticalMachine = new StatisticalMachine();

    public void open() {
        Cash cash = inputHandler.inputCash();
        lottoMachine.purchase(cash);
        outputView.printLottoTickets(lottoMachine);

        Lotto lotto = inputHandler.inputWinningNumbers();
        BonusNumber bonusNumber = inputHandler.inputBonusNumber(lotto);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        statisticalMachine.calculate(lottoMachine.currentLottoTickets(), winningLotto);
        outputView.printWinningStatistics(statisticalMachine);
        outputView.printTotalProfit(statisticalMachine.getTotalProfit(cash));
    }

}
