package lotto;

public class LottoStore {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputView outputView = new OutputView();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void open() {
        Cash cash = inputHandler.inputCash();
        lottoMachine.purchase(cash);
        outputView.printLottoTickets(lottoMachine);

        Lotto lotto = inputHandler.inputWinningNumbers();
        BonusNumber bonusNumber = inputHandler.inputBonusNumber(lotto);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        //TODO 당첨 통계 출력
    }

}
