package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.utils.LottoGenerator;
import lotto.utils.UserInputUtil;
import lotto.view.OutView;

import java.util.List;

public class LottoRunner {
    public static void run() {
        long purchaseBudget = UserInputUtil.takePurchaseBudget();
        List<Lotto> userWallet = LottoGenerator.generateLottoWallet(purchaseBudget);

        final LottoService lottoService = new LottoService(userWallet);
        List<Integer> winningNumbers = UserInputUtil.takeLottoNumbers();
        int bonusNumber = UserInputUtil.takeBonusNumber();
        OutView.showWinningResult(
                lottoService.getWinningResultTable(winningNumbers,bonusNumber)
                ,purchaseBudget);
    }
}
