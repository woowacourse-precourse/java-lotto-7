package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    LottoView lottoView;
    LottoMachine lottoMachine;

    public LottoController(LottoView lottoView, LottoMachine lottoMachine) {
        this.lottoView = lottoView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        try {
            int purchaseAmount = lottoView.inputPurchaseAmount();
            List<Lotto> lottos = lottoMachine.buyLotto(purchaseAmount);
            lottoView.printLotto(lottos);
            Lotto winning = new Lotto(Arrays.stream(lottoView.inputWinningNumbers().split(",")).map(Integer::parseInt).toList());
            int bonusNumber = lottoView.inputBonusNumber();
            List<Grade> grade = LottoComparison.compare(lottos, winning, bonusNumber);
            lottoView.printWinningResult(grade);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
