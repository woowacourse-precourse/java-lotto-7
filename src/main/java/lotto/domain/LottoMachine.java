package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    private List<Lotto> lottos;
    private List<Prize> prizes;

    public void run() {
        PurchaseAmount purchaseAmount = InputView.readPurchaseAmount();
        System.out.println();

        purchaseLottos(purchaseAmount);
        System.out.println();
    }

    private void purchaseLottos(final PurchaseAmount purchaseAmount) {
        int purchaseQuantity = calculatePurchaseQuantity(purchaseAmount);
        OutputView.printPurchaseQuantity(purchaseQuantity);

        this.lottos = IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> generateRandomLotto())
                .toList();
        OutputView.printLottos(this.lottos);
    }

    private Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN_NUMBER,
                LottoNumber.MAX_NUMBER,
                Lotto.LOTTO_SIZE
        );
        return Lotto.from(numbers);
    }

    private int calculatePurchaseQuantity(PurchaseAmount purchaseAmount) {
        return purchaseAmount.amount() / PurchaseAmount.UNIT_AMOUNT;
    }
}
