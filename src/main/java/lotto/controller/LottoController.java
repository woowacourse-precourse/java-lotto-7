package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.util.StringToIntegerConverter;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        Money money = executeWithRetry(() -> new Money(covertToInteger(inputView.enterMoney())));

        LottoTicket lottoTicket = generateLottoTickets(money);

        WinningLotto winningLotto = executeWithRetry(() -> {
            String originWinningNumber = inputView.enterWinningNumber();
            Integer bonusNumber = covertToInteger(inputView.enterBonusNumber());
            return new WinningLotto(convertToLottoFormat(originWinningNumber), bonusNumber);
        });

        PrizeResult prizeResult = calculatePrizes(lottoTicket, winningLotto);

        outputWinningDetails(prizeResult, money);
    }

    private LottoTicket generateLottoTickets(Money money) {
        outputView.printTicketAmount(money);
        LottoTicket lottoTicket = new LottoTicket(money);
        outputView.printLotto(lottoTicket);
        return lottoTicket;
    }

    private PrizeResult calculatePrizes(LottoTicket lottoTicket, WinningLotto winningLotto) {
        PrizeResult prizeResult = new PrizeResult();
        prizeResult.calculate(winningLotto, lottoTicket);
        return prizeResult;
    }

    private void outputWinningDetails(PrizeResult prizeResult, Money money) {
        outputView.winningDetails(prizeResult, money);
    }

    private List<Integer> convertToLottoFormat(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int covertToInteger(String inputValue) {
        return StringToIntegerConverter.convert(inputValue);
    }

    private <T> T executeWithRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.renderError(e.getMessage());
            }
        }
    }
}