package lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoDrawer;
import lotto.domain.LottoTicket;
import lotto.domain.NumbersGenerator;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningCombination;
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

    public void play() {
        PurchaseAmount purchaseAmount = purchase();
        LottoTicket lottoTicket = draw(purchaseAmount);
        WinningCombination winningCombination = announceResults();
        match(lottoTicket, winningCombination);
    }

    private PurchaseAmount purchase() {
        return retryUntilValid(() -> {
            String rawPurchaseAmount = input.readPurchaseAmount();
            return new PurchaseAmount(rawPurchaseAmount);
        });
    }

    private LottoTicket draw(PurchaseAmount purchaseAmount) {
        NumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        LottoDrawer lottoDrawer = new LottoDrawer(purchaseAmount, randomNumbersGenerator);
        LottoTicket lottoTicket = lottoDrawer.generateLottos();

        output.printLottoTicket(lottoTicket);
        return lottoTicket;
    }

    private WinningCombination announceResults() {
        Lotto winningLotto = retryUntilValid(() -> {
            List<Integer> winningNumbers = input.readWinningLotto();
            return new Lotto(winningNumbers);
        });

        Bonus bonus = retryUntilValid(() -> {
            String rawBonusNumber = input.readBonusNumber();
            return new Bonus(rawBonusNumber);
        });

        return new WinningCombination(winningLotto, bonus);
    }

    private void match(LottoTicket lottoTicket, WinningCombination winningCombination) {
        Map<Rank, Integer> lottoResult = winningCombination.lottoWinningResult(lottoTicket);
    }

    private <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
