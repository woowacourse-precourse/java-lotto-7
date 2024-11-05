package lotto.view.formatter;

import lotto.dto.PurchasedLottosResponse;
import lotto.dto.WinningSummaryResponse;

import java.text.NumberFormat;
import java.util.stream.Collectors;

public class OutputFormatter {
    private OutputFormatter() {
    }

    private static class OutputFormatterHolder {
        private static final OutputFormatter instance = new OutputFormatter();
    }

    public static OutputFormatter getInstance() {
        return OutputFormatter.OutputFormatterHolder.instance;
    }

    public String formatPurchasedLottos(PurchasedLottosResponse responses) {
        return responses.lottoResponses()
                .stream()
                .map(response -> response.numbers()
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]"))
                )
                .collect(Collectors.joining("\n"));
    }

    public String formatWinningResult(WinningSummaryResponse.WinningDetailResponse response) {
        String bonusStatus = "";
        if (response.bonusNumberStatus().equals("INCLUDE_BONUS")) {
            bonusStatus = ", 보너스 볼 일치";
        }

        return String.format("%d개 일치%s (%s원) - %d개",
                response.matchingNumberCount(),
                bonusStatus,
                NumberFormat.getInstance().format(response.prizeMoney()),
                response.winningCount());
    }
}
