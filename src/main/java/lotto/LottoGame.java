package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.LottoDrawer;
import lotto.domain.LottoTicket;
import lotto.domain.NumbersGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.external.RandomNumbersGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGame {

    private final Input input;
    private final Output output;

    public LottoGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void purchase() {
        String rawPurchaseAmount = input.readPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(rawPurchaseAmount);

        draw(purchaseAmount);
    }

    private void draw(PurchaseAmount purchaseAmount) {
        NumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        LottoDrawer lottoDrawer = new LottoDrawer(purchaseAmount, randomNumbersGenerator);

        LottoTicket lottoTicket = lottoDrawer.generateLottos();

        output.printLottoTicket(lottoTicket);

        result(lottoTicket);
    }

    public void result(LottoTicket lottoTicket) {

        List<Integer> winningNumbers = input.readWinningLotto();
        String rawBonusNumber = input.readBonusNumber();

        BonusNumber bonusNumber = new BonusNumber(rawBonusNumber);

        WinningLotto winningLotto = new WinningLotto(
                winningNumbers, bonusNumber
        );

        Map<Rank, Integer> lottoResult = winningLotto.lottoWinningResult(lottoTicket);
    }
}
