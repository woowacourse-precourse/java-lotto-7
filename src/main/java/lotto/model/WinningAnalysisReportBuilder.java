package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;

import java.util.concurrent.atomic.AtomicInteger;


public class WinningAnalysisReportBuilder {
    private LottoTickets lottoTickets;
    private WinningNumbers winningNumbers;

    public WinningAnalysisReportBuilder withLottoTickets(LottoTickets lottoTickets) {
        validateLottoTickets(lottoTickets);
        this.lottoTickets = lottoTickets;
        return this;
    }

    public WinningAnalysisReportBuilder withWinningNumbers(WinningNumbers winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        return this;
    }

    public WinningAnalysisReport build() {
        validateInputs();
        WinningStatistics statistics = new WinningStatistics();
        AtomicInteger totalProfits = new AtomicInteger();

        processAllTickets(statistics, totalProfits);
        ProfitRate profitRate = ProfitRate.from(totalProfits.get(), lottoTickets.totalPrice());
        return new WinningAnalysisReport(statistics, profitRate);
    }

    private void validateInputs() {
        validateLottoTickets(lottoTickets);
        validateWinningNumbers(winningNumbers);
    }

    private void validateLottoTickets(LottoTickets lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
            throw new WinningNumberException(ErrorMessages.LOTTO_TICKETS_NULL);
        }
    }

    private void validateWinningNumbers(WinningNumbers winningNumbers) {
        if (winningNumbers == null) {
            throw new WinningNumberException(ErrorMessages.WINNING_NUMBERS_NULL);
        }
    }

    private void processAllTickets(WinningStatistics statistics, AtomicInteger totalProfits) {
        for (LottoTicket ticket : lottoTickets.tickets()) {
            processTicket(ticket, statistics, totalProfits);
        }
    }

    private void processTicket(LottoTicket ticket, WinningStatistics statistics, AtomicInteger totalProfits) {
        TicketProcessingContext context = new TicketProcessingContext(ticket.lotto(), winningNumbers, statistics, totalProfits);
        int matchCount = context.ticket.countMatchingNumbers(context.winningNumbers.mainNumbers());
        boolean bonusMatch = context.ticket.containsNumber(context.winningNumbers.bonusNumber());
        updateStatistics(context, matchCount, bonusMatch);
    }

    private void updateStatistics(TicketProcessingContext context, int matchCount, boolean bonusMatch) {
        WinningRule winningRule = WinningRule.of(matchCount, bonusMatch);
        context.statistics.increment(winningRule);
        context.totalProfits.addAndGet(winningRule.getPrizeAmount());
    }

    private record TicketProcessingContext(Lotto ticket, WinningNumbers winningNumbers, WinningStatistics statistics,
                                           AtomicInteger totalProfits) {
    }
}
