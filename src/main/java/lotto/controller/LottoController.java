package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
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
import lotto.util.RetryExecutor;
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
        LottoPayment payment = withRetry(this::createLottoPayment);
        List<Lotto> purchasedLottos = purchaseLottos(payment);

        Lotto winningNumbers = withRetry(this::createWinningNumbers);
        WinningLotto winningLotto = withRetry(() -> createWinningLottoWithBonusNumber(winningNumbers));

        processResults(purchasedLottos, winningLotto, payment);
    }

    private LottoPayment createLottoPayment() {
        String input = inputView.getPurchaseAmount();
        Long amount = NumberParser.parseLong(input);
        return LottoPayment.from(Money.from(amount));
    }

    private List<Lotto> purchaseLottos(LottoPayment payment) {
        List<Lotto> lottos = lottoService.purchaseAll(payment, new QuickpickIssuanceStrategy());
        outputView.printLottoTickets(LottoTicketsDto.from(lottos));
        return lottos;
    }

    private Lotto createWinningNumbers() {
        String input = inputView.getWinningNumbers();
        List<Integer> numbers = NumberArrayParser.parse(input);
        return Lotto.from(numbers);
    }

    private WinningLotto createWinningLottoWithBonusNumber(Lotto winningNumbers) {
        String input = inputView.getBonusNumber();
        Integer number = NumberParser.parseInt(input);
        return WinningLotto.of(winningNumbers, LottoNumber.from(number));
    }

    private void processResults(List<Lotto> lottos, WinningLotto winningLotto, LottoPayment payment) {
        List<WinningResultDto> results = lottoWinningCheckService.check(lottos, winningLotto);
        WinningStatisticsDto statistics = lottoWinningCheckService.createStatistics(results, payment);
        outputView.printWinningStatistics(statistics);
    }

    private <T> T withRetry(Supplier<T> function) {
        return RetryExecutor.execute(
                function,
                (error) -> outputView.printError(error.getMessage()),
                IllegalArgumentException.class
        );
    }
}
