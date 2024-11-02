package lotto;

import lotto.domain.Result;

public class LottoGame {
    private final InputView inputView;
    private final LottoMachine lottoMachine;
    private Result result;

    public LottoGame() {
        this.inputView = new InputView();
        this.lottoMachine = new LottoMachine();
    }

    public void start() {
        inputView.inputPurchaseAmount();

        lottoMachine.purchaseLottos(inputView.getPurchaseAmount());
        lottoMachine.printLottos();

        inputView.inputWinningNumbers();
        inputView.inputBonusNumber();

        result = new Result(
                lottoMachine.getLottos(),
                inputView.getWinningNumbers(),
                inputView.getBonusNumber()
        );

        result.calculate();
        result.printResult(inputView.getPurchaseAmount());
    }
}
