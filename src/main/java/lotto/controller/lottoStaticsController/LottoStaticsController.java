package lotto.controller.lottoStaticsController;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStatics;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.dto.IncomeStatics;
import lotto.dto.PrizeStatics;
import lotto.io.OutputHandler;

public class LottoStaticsController {

    private final OutputHandler outputHandler;

    public LottoStaticsController(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public void printLottoStatics(
            final List<Lotto> purchasedLottos,
            final WinningLotto winningLotto,
            final Money money
    ) {
        LottoStatics lottoStatics = LottoStatics.of(purchasedLottos, winningLotto, money);
        outputHandler.handlePrizeStatics(PrizeStatics.from(lottoStatics));
        outputHandler.handleIncomeStatics(IncomeStatics.from(lottoStatics));
    }
}
