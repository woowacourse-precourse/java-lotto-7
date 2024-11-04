package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    public void run() {
        PurchaseAmount purchaseAmount = InputView.readPurchaseAmount();
        List<Lotto> lottos = purchaseLottos(purchaseAmount);

        WinningNumbers winningNumbers = InputView.readWinningNumbers();

        WinningResult result = WinningResult.of(lottos, winningNumbers, purchaseAmount.amount());
        OutputView.printWinningResult(result);
    }

    private List<Lotto> purchaseLottos(final PurchaseAmount purchaseAmount) {
        int purchaseQuantity = calculatePurchaseQuantity(purchaseAmount);
        OutputView.printPurchaseQuantity(purchaseQuantity);

        List<Lotto> lottos = IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> generateRandomLotto())
                .toList();
        OutputView.printLottos(lottos);
        return lottos;
    }

    private Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN_NUMBER,
                LottoNumber.MAX_NUMBER,
                Lotto.LOTTO_SIZE
        );
        return Lotto.from(numbers);
    }

    private int calculatePurchaseQuantity(final PurchaseAmount purchaseAmount) {
        return purchaseAmount.amount() / PurchaseAmount.UNIT_AMOUNT;
    }
}
