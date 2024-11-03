package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    public void run() {
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            List<Lotto> purchasedLottos = purchaseLottos(purchaseAmount);
            OutputView.printPurchasedLotto(purchasedLottos);

            Lotto winningLotto = InputView.inputWinningLotto();
            int bonusNumber = InputView.inputBonusNumber(winningLotto.getNumbers());

            LottoResult result = calculateResult(purchasedLottos, winningLotto, bonusNumber);
            OutputView.printResult(result, purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Lotto> purchaseLottos(int amount){
        return IntStream.rangeClosed(0, amount / LOTTO_PRICE - 1)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }

    private LottoResult calculateResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        LottoResult result = new LottoResult();
        purchasedLottos.forEach(lotto -> result.addRank(LottoRank.getRank(lotto, winningLotto, bonusNumber)));
        return result;
    }

}
