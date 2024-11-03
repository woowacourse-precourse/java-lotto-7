package lotto;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.util.EarningCalculator;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        int count = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = getLottosFrom(count);
        OutputView.showPurchaseLotto(count, lottos);

        Lotto winningLotto = getWinningLotto();
        Bonus bonus = getBonus();
        checkIfBonusIsDuplicate(winningLotto, bonus);

        LottoManager lottoManager = new LottoManager(lottos, winningLotto, bonus);
        OutputView.showLottoResult(lottoManager.getLottoResultMap());

        int winningAmount = lottoManager.calculateWinningAmount();
        String earningsRate = EarningCalculator.calculateEarningsRate(winningAmount, purchaseAmount);
        OutputView.showEarningRate(earningsRate);
    }

    private int getPurchaseAmount() {
        try {
            int purchaseAmount = InputView.readPurchaseAmount();
            checkIfPurchaseAmountIsValid(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    private Lotto getWinningLotto() {
        try {
            return InputView.readWinningLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private Bonus getBonus() {
        try {
            return InputView.readBonus();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonus();
        }
    }

    private void checkIfBonusIsDuplicate(Lotto lotto, Bonus bonus) {
        if (lotto.hasBonus(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    private void checkIfPurchaseAmountIsValid(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 로또 가격 단위로 이루어져야 합니다.");
        }
    }

    private static List<Lotto> getLottosFrom(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(RandomNumberGenerator.generateRandomNumbers()))
                .toList();
    }
}
