package lotto;

import java.util.List;
import lotto.io.InputMessage;
import lotto.io.InputReader;

public class LottoApplication {

    private final InputReader inputReader;
    private final LottoGenerator lottoGenerator;

    public LottoApplication() {
        this.inputReader = new InputReader();
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        InputMessage.purchaseAmount();
        long purchaseAmount = inputReader.readPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.purchase(purchaseAmount);
    }

}
