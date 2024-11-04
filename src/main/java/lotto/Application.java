package lotto;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int amount = inputView.readPurchaseAmount();
        List<Lotto> purchasedLottos = lottoMachine.purchaseLottos(amount);
        outputView.printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        LottoResult result = lottoMachine.checkWinning(purchasedLottos, winningNumbers, bonusNumber);
        outputView.printResult(result, amount);
        // TODO: 프로그램 구현
    }
}
