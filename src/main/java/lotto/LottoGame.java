package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.external.RandomNumbersGenerator;
import lotto.view.Input;

public class LottoGame {

    private final Input input;

    public LottoGame(Input input) {
        this.input = input;
    }

    public void run() {

        String rawPurchaseAmount = input.readPurchaseAmount();

        int lottoCount = 3;

        LottoMachine lottoMachine = new LottoMachine(lottoCount, new RandomNumbersGenerator());

        LottoTicket lottoTicket = new LottoTicket(lottoMachine.generateLottos());

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
        );

        Map<Rank, Integer> lottoResult = winningLotto.lottoWinningResult(lottoTicket);
    }
}
