package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPayment;
import lotto.dto.LottoTicketsDto;
import lotto.service.LottoService;
import lotto.strategy.QuickpickIssuanceStrategy;
import lotto.util.NumberArrayParser;
import lotto.util.NumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.Money;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            LottoService lottoService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        String a = inputView.getPurchaseAmount();
        Long b = NumberParser.parseLong(a);

        LottoPayment lottoPayment = LottoPayment.from(Money.from(b));
        List<Lotto> lottos = lottoService.purchaseAll(lottoPayment, new QuickpickIssuanceStrategy());
        outputView.printLottoTickets(LottoTicketsDto.from(lottos));

        String c = inputView.getWinningNumbers();
        List<Integer> d = NumberArrayParser.parse(c);
        Lotto e = Lotto.from(d);

        inputView.getBonusNumber();

//        outputView.printWinningStatistics();
    }
}
