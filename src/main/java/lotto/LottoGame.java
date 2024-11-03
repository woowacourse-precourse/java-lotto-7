package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
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

        NumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount, randomNumbersGenerator);

        LottoTicket lottoTicket = new LottoTicket(lottoMachine.generateLottos());

        output.printLottoTicket(lottoTicket);

        run(lottoTicket);
    }

    public void run(LottoTicket lottoTicket) {

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
        );

        Map<Rank, Integer> lottoResult = winningLotto.lottoWinningResult(lottoTicket);
    }
}
