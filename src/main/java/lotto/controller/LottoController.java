package lotto.controller;


import java.util.List;
import java.util.function.Supplier;
import lotto.model.LottoTicket;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.model.WinningStatistics;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        Money money = retryIfErrorOccur(this::setMoney);
        int quantity = money.getQuantity();

        LottoTicket lottoTicket = lottoService.purchase(quantity);
        outputView.purchaseHistory(quantity, lottoTicket);

        WinningNumbers winningNumbers = retryIfErrorOccur(this::setWinningNumbers);

        winningStatistics(lottoTicket, winningNumbers, money);
    }

    private Money setMoney() {
        outputView.inputMoney();
        return new Money(inputView.inputNumber());
    }

    private WinningNumbers setWinningNumbers() {
        outputView.inputWinningNumbers();
        List<Integer> winningNumber = inputView.inputWinningNumbers();

        outputView.inputBonusNumber();
        int bonusNumber = inputView.inputNumber();

        return new WinningNumbers(winningNumber, bonusNumber);
    }

    private void winningStatistics(LottoTicket lottoTicket, WinningNumbers winningNumbers, Money money) {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.createStatistics(lottoTicket.getLottoTicket(), winningNumbers);
        outputView.winningStatistics(winningStatistics.getWinningCount());
        outputView.rateOfReturn(winningStatistics.getRateOfReturn(money));
    }

    private <T> T retryIfErrorOccur(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

