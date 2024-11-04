package lotto.presentation.result;

import static lotto.presentation.result.ResultFormatter.formatLottoNumberMessage;
import static lotto.presentation.result.ResultFormatter.formatPurchaseCountMessage;
import static lotto.presentation.result.ResultFormatter.formatReturnOnInvestmentMessage;
import static lotto.presentation.result.ResultFormatter.formatWinningStatisticsMessage;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lotto.service.dto.LottoPurchaseResponse;
import lotto.service.dto.WinningDrawResponse;
import lotto.service.dto.WinningResult;

public class ResultView {

    private static final String NEW_LINE = System.lineSeparator();

    public void printLottoPurchaseResult(final LottoPurchaseResponse lottoPurchaseResponse) {
        StringBuilder builder = new StringBuilder();

        appendPurchaseCountMessage(builder, formatPurchaseCountMessage(lottoPurchaseResponse.lottoTicketsCount()));
        appendLottoNumberMessage(builder, lottoPurchaseResponse.lottoNumbers());

        System.out.println(builder);
    }

    public void printDrawWinningResult(final WinningDrawResponse winningDrawResponse) {
        StringBuilder builder = new StringBuilder();

        appendDrawWinningResultGuide(builder);
        appendWinningResultStatisticsMessage(builder, winningDrawResponse);
        appendReturnOnInvestmentPercentageMessage(builder, winningDrawResponse.returnOnInvestment());

        System.out.println(builder);
    }

    public void printUserExceptionMessage(final String exceptionMessage) {
        System.out.println(String.join(" ", "[ERROR]", exceptionMessage));
    }

    private void appendPurchaseCountMessage(final StringBuilder builder, final String purchaseCountMessage) {
        builder.append(NEW_LINE)
                .append(purchaseCountMessage)
                .append(NEW_LINE);
    }

    private void appendLottoNumberMessage(final StringBuilder builder, final List<List<String>> lottoNumbers) {
        lottoNumbers.forEach((lottoNumber) -> {
            builder.append(formatLottoNumberMessage(lottoNumber))
                    .append(NEW_LINE);
        });
    }

    private void appendDrawWinningResultGuide(final StringBuilder builder) {
        builder.append(NEW_LINE)
                .append("당첨 통계")
                .append(NEW_LINE)
                .append("---")
                .append(NEW_LINE);
    }

    private void appendWinningResultStatisticsMessage(
            final StringBuilder builder,
            final WinningDrawResponse winningDrawResponse
    ) {
        Map<WinningResult, Long> winningResultStatistics = winningDrawResponse.winningResultStatistics();
        for (WinningResult winningResult : winningResultStatistics.keySet()) {
            long winningCount = winningResultStatistics.get(winningResult);
            builder.append(formatWinningStatisticsMessage(winningResult, Long.toString(winningCount)))
                    .append(NEW_LINE);
        }
    }

    private void appendReturnOnInvestmentPercentageMessage(
            final StringBuilder builder,
            final BigDecimal returnOnInvestment
    ) {
        String returnOnInvestmentMessage = formatReturnOnInvestmentMessage(returnOnInvestment);
        builder.append(returnOnInvestmentMessage);
    }

}
