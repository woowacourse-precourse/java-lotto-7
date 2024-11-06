package lotto.view.formatter;

import lotto.dto.PurchasedLottosResponse;
import lotto.dto.WinningSummaryResponse;

import java.text.NumberFormat;
import java.util.stream.Collectors;

public class OutputFormatter {
    private static OutputFormatter instance;

    private OutputFormatter() {
    }

    public static OutputFormatter getInstance() {
        if (instance == null) {
            instance = new OutputFormatter();
        }

        return instance;
    }

    public String formatPurchasedLottos(PurchasedLottosResponse purchasedLottos) {
        return purchasedLottos.lottoResponses()
                .stream()
                .map(lotto -> lotto.numbers()
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]"))
                )
                .collect(Collectors.joining("\n"));
    }

    public String formatWinningDetail(WinningSummaryResponse.WinningDetailResponse winningDetail) {
        String bonusStatus = "";
        if (winningDetail.bonusNumberStatus().equals("INCLUDE")) {
            bonusStatus = ", 보너스 볼 일치";
        }

        return String.format("%d개 일치%s (%s원) - %d개",
                winningDetail.matchingNumberCount(),
                bonusStatus,
                NumberFormat.getInstance().format(winningDetail.prizeMoney()),
                winningDetail.winningCount());
    }
}
