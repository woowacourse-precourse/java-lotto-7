package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            LottoMachine lottoMachine = new LottoMachine();
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();

            int purchaseAmount = inputView.inputPurchaseAmount();
            lottoMachine.purchaseLottos(purchaseAmount);
            outputView.printPurchasedLottos(lottoMachine.getLottos());

            WinningLotto winningLotto = inputView.inputWinningLotto();
            lottoMachine.calculateResults(winningLotto);

            outputView.printStatistics(lottoMachine.getResult(), purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Console.close();
    }
}
