package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.service.Calculator;
import lotto.service.LottoResult;
import lotto.service.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        while (true) {
            try {
                // 1. 구입 금액 입력 받기
                int purchaseAmount = inputView.inputPurchaseAmount();
                LottoStore store = new LottoStore(purchaseAmount);
                outputView.printNumberOfLotto(store);
                outputView.printNumbers(store);

                // 2. 당첨 번호 입력 받기
                List<Integer> userLottoNumber = inputView.inputLottoNumbers();
                int bonusNumber = inputView.inputBonusNumber();
                WinningNumbers winningNumbers = new WinningNumbers(userLottoNumber, bonusNumber);

                // 비즈니스 로직 처리
                Calculator calculator = new Calculator(winningNumbers);
                List<Lotto> purchasedLotto = store.getPurchasedLotto();
                LottoResult lottoResult = new LottoResult(purchasedLotto, winningNumbers, calculator);
                outputView.printResults(lottoResult);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        inputView.close();
    }
}
