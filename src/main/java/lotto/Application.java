package lotto;

import lotto.InputView;
import lotto.ResultView;
import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.LottoResult;
import lotto.Validator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.readPurchaseAmount();
            int lottoCount = purchaseAmount / 1000;
            List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
            ResultView.printLottos(lottos);

            List<Integer> winningNumbers = InputView.readWinningNumbers();
            int bonusNumber = InputView.readBonusNumber();
            Validator.validateBonusNumberDuplication(bonusNumber, winningNumbers);

            Lotto winningLotto = new Lotto(winningNumbers);
            LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}