package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * WinningAnalysisReportBuilder는 로또 당첨 분석 보고서를 생성하는 빌더 클래스입니다.
 */
public class WinningAnalysisReportBuilder {
    private LottoTickets lottoTickets;
    private WinningNumbers winningNumbers;

    public WinningAnalysisReportBuilder withLottoTickets(LottoTickets lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
            throw new LottoException(ErrorMessages.LOTTO_TICKETS_NULL);
        }
        this.lottoTickets = lottoTickets;
        return this;
    }

    public WinningAnalysisReportBuilder withWinningNumbers(WinningNumbers winningNumbers) {
        if (winningNumbers == null) {
            throw new LottoException(ErrorMessages.WINNING_NUMBERS_NULL);
        }
        this.winningNumbers = winningNumbers;
        return this;
    }

    public WinningAnalysisReport build() {
        validateInputs();
        WinningStatistics statistics = initializeStatistics();
        AtomicInteger totalProfits = new AtomicInteger();

        processAllTickets(statistics, totalProfits);
        ProfitRate profitRate = ProfitRate.from(totalProfits.get(), lottoTickets.totalPrice());
        return new WinningAnalysisReport(statistics, profitRate);
    }

    private void validateInputs() {
        if (lottoTickets == null) {
            throw new LottoException(ErrorMessages.LOTTO_TICKETS_NULL);
        }
        if (winningNumbers == null) {
            throw new LottoException(ErrorMessages.WINNING_NUMBERS_NULL);
        }
    }

    private WinningStatistics initializeStatistics() {
        return new WinningStatistics();
    }

    private void processAllTickets(WinningStatistics statistics, AtomicInteger totalProfits) {
        for (LottoTicket ticket : lottoTickets.tickets()) {
            processTicket(ticket.lotto(), statistics, totalProfits);
        }
    }

    private void processTicket(Lotto ticket, WinningStatistics statistics, AtomicInteger totalProfits) {
        int matchCount = ticket.countMatchingNumbers(winningNumbers.mainNumbers());
        boolean bonusMatch = ticket.containsNumber(winningNumbers.bonusNumber());
        updateStatistics(statistics, totalProfits, matchCount, bonusMatch);
    }

    private void updateStatistics(WinningStatistics statistics, AtomicInteger totalProfits, int matchCount, boolean bonusMatch) {
        WinningRule winningRule = WinningRule.of(matchCount, bonusMatch);
        statistics.increment(winningRule);
        totalProfits.addAndGet(winningRule.getPrizeAmount());
    }
}
