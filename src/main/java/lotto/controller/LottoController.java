package lotto.controller;

import lotto.model.draw.Bonus;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoBuyer;
import lotto.model.lotto.LottoStore;
import lotto.model.lotto.LottoTickets;
import lotto.model.result.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.draw.LottoDraw;

import java.util.function.Supplier;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoTickets lottoTickets;  // 클래스 필드로 추가

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        retryRunnable(this::buyTickets);
        Lotto winningNumber = retrySupplier(this::readValidWinningNumber);
        Bonus bonusNumber = retrySupplier(() -> new Bonus(inputView.readBonusNumber()));

        // 당첨 결과 계산 및 출력
        LottoDraw lottoDraw = LottoDraw.by(winningNumber, bonusNumber);
        WinningStatistics statistics = WinningStatistics.from(lottoDraw, lottoTickets);
        outputView.printWinningStatistics(statistics);
    }

    private void buyTickets() {
        int ticketCount = retrySupplier(this::readValidTicketCount);
        outputView.printTicketNumber(ticketCount);

        lottoTickets = LottoTickets.createTickets(ticketCount);  // 필드에 저장
        outputView.printLottoTickets(lottoTickets);
    }

    private int readValidTicketCount() {
        int budget = inputView.readBudget();
        LottoStore store = new LottoStore();
        LottoBuyer buyer = new LottoBuyer();
        buyer.buyTickets(budget, store);
        return buyer.getOwnedTickets();
    }

    private Lotto readValidWinningNumber() {
        return new Lotto(inputView.readWinningNumber());
    }

    private void retryRunnable(Runnable action) {
        while (true) {
            try {
                action.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }

    private <T> T retrySupplier(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }
}