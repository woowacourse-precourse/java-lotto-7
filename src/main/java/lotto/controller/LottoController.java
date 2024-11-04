package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPayment;
import lotto.domain.WinningLotto;
import lotto.dto.LottoTicketsDto;
import lotto.dto.WinningResultDto;
import lotto.dto.WinningStatisticsDto;
import lotto.service.LottoService;
import lotto.service.LottoWinningCheckService;
import lotto.strategy.QuickpickIssuanceStrategy;
import lotto.util.NumberArrayParser;
import lotto.util.NumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.vo.LottoNumber;
import lotto.vo.Money;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoWinningCheckService lottoWinningCheckService;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            LottoService lottoService,
            LottoWinningCheckService lottoWinningCheckService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.lottoWinningCheckService = lottoWinningCheckService;
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

        String f = inputView.getBonusNumber();
        Integer h = NumberParser.parseInt(f);

        List<WinningResultDto> check = lottoWinningCheckService.check(lottos, WinningLotto.of(e, LottoNumber.from(h)));
        WinningStatisticsDto statistics = lottoWinningCheckService.createStatistics(check, lottoPayment);

        outputView.printWinningStatistics(statistics);
    }
}
