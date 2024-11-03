package lotto;

public class LottoStore {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputView outputView = new OutputView();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void open() {
        Cash cash = inputHandler.inputCash();
        lottoMachine.purchase(cash);
        outputView.printLottoTickets(lottoMachine);

        WinningNumbers winningNumbers = inputHandler.inputWinningNumbers();
        BonusNumber bonusNumber = inputHandler.inputBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);


    }

}
