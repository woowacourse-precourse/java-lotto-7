package lotto.view;

import lotto.dto.PurchasedLottosResponse;
import lotto.dto.WinningSummaryResponse;

import java.text.NumberFormat;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
    }

    private static class OutputViewHolder {
        private static final OutputView instance = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.instance;
    }

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void promptLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void promptBonusNumber() {
        System.out.println("\n보너스 번호을 입력해 주세요.");
    }

    public void printPurchasableLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(PurchasedLottosResponse purchasedLottosResponse) {
        System.out.println(formatPurchasedLottos(purchasedLottosResponse));
    }

    public void printWinningResult(WinningSummaryResponse winningResultResponse) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        winningResultResponse.matchingCountResponses()
                .forEach(matchingCountResponse -> System.out.println(formatWinningResult(matchingCountResponse)));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", winningResultResponse.profitRate());
    }

    private String formatPurchasedLottos(PurchasedLottosResponse responses) {
        return responses.lottoResponses()
                .stream()
                .map(response -> response.numbers()
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]"))
                )
                .collect(Collectors.joining("\n"));
    }

    private String formatWinningResult(WinningSummaryResponse.MatchingCountResponse response) {
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
