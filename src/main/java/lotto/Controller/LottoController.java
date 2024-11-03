package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            int numberOfLottos = purchaseAmount / 1000;

            List<Lotto> purchasedLottos = purchaseLottos(numberOfLottos);

            List<Integer> winningNumbers = InputView.inputWinningNumbers();
            int bonusNumber = InputView.inputBonusNumber();

            LottoResult lottoResult = calculateLottoResult(purchasedLottos, winningNumbers, bonusNumber);

            OutputView.printPurchasedLottos(numberOfLottos, extractLottoNumbers(purchasedLottos));
            OutputView.printWinningStatistics(lottoResult.getMatchCounts(), lottoResult.calculateYield(purchaseAmount));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos(int numberOfLottos) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.sort(Integer::compareTo);
            purchasedLottos.add(new Lotto(lottoNumbers));
        }
        return purchasedLottos;
    }

    private List<List<Integer>> extractLottoNumbers(List<Lotto> lottos) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }

    private LottoResult calculateLottoResult(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : purchasedLottos) {
            result.updateStatistics(lotto, winningNumbers, bonusNumber);
        }
        return result;
    }
}
