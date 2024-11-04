package lotto.presentation.result;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import lotto.service.dto.WinningResult;

final class ResultFormatter {

    private ResultFormatter() {}

    static String formatPurchaseCountMessage(final int lottoTicketsCount) {
        return String.join("", lottoTicketsCount + "개를 구매했습니다.");
    }

    static String formatLottoNumberMessage(final List<String> lottoNumber) {
        return lottoNumber.stream()
                .collect(Collectors.joining(", ", "[", "]"));
    }

    static String formatWinningStatisticsMessage(final WinningResult winningResult, final String winningCount) {
        String prefix = formatWinningStatisticsPrefixMessage(winningResult);
        String suffix = formatWinningStatisticsSuffixMessage(winningCount);
        return String.join(" - ", prefix, suffix);
    }

    private static String formatWinningStatisticsPrefixMessage(final WinningResult winningResult) {
        NumberFormat moneyFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        if (winningResult.hasBonusNumber()) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", winningResult.matchingCount(),
                    moneyFormat.format(winningResult.winningMoney()));
        }
        return String.format("%d개 일치 (%s원)", winningResult.matchingCount(),
                moneyFormat.format(winningResult.winningMoney()));
    }

    private static String formatWinningStatisticsSuffixMessage(final String winningResultStatistics) {
        return String.join("", winningResultStatistics, "개");
    }

    static String formatReturnOnInvestmentMessage(final BigDecimal returnOnInvestment) {
        DecimalFormat returnOnInvestmentFormat = new DecimalFormat("#,##0.0");
        BigDecimal returnOnInvestmentPercentage = getRoundingPercentage(returnOnInvestment);

        String returnOnInvestmentPercentageMessage = String.join("",
                returnOnInvestmentFormat.format(returnOnInvestmentPercentage), "%");
        return String.format("총 수익률은 %s입니다.", returnOnInvestmentPercentageMessage);
    }

    private static BigDecimal getRoundingPercentage(final BigDecimal returnOnInvestment) {
        return returnOnInvestment.multiply(BigDecimal.valueOf(100L))
                .setScale(1, RoundingMode.HALF_UP);
    }

}
