package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Prize;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        int amount = getValidPurchaseAmount(lottoService);
        int count = lottoService.calculateLottoCount(amount);
        List<Lotto> lottos = lottoService.generateLottos(count);

        OutputView.printPurchaseCount(count);
        OutputView.printLottos(lottos);

        Lotto winningLotto = getValidWinningNumbers();
        LottoNumber bonusNumber = getValidBonusNumber(winningLotto);
        
        Map<Prize, Integer> results = lottoService.calculateResults(lottos, winningLotto, bonusNumber);
        OutputView.printResults(results, amount);
    }

    private static int getValidPurchaseAmount(LottoService lottoService) {
        while (true) {
            try {
                int amount = InputView.inputPurchaseAmount();
                lottoService.calculateLottoCount(amount); // validates the amount
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto getValidWinningNumbers() {
        while (true) {
            try {
                return InputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static LottoNumber getValidBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                return InputView.inputBonusNumber(winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
