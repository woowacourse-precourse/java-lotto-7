package lotto;

import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        LottoService lottoService = new LottoService();

        int purchaseAmount = InputView.inputPurchaseAmount();
        List<Lotto> userLotto = lottoService.generateLotto(purchaseAmount);

        OutputView.printLotto(userLotto);

        Lotto winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        Map<LottoRank, Integer> result = lottoService.calculateLottoResults(userLotto, winningNumbers, bonusNumber);
    }
}
