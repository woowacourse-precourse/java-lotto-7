package lotto.view;

import lotto.dto.PrizeResponse;
import lotto.dto.PurchasedLottosResponse;

import java.text.NumberFormat;
import java.util.List;
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

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printPurchasedLottos(PurchasedLottosResponse purchasedLottosResponse) {
        System.out.println(formatPurchasedLottos(purchasedLottosResponse));
    }

    public void printWinningResult(List<PrizeResponse> prizeResponses) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        prizeResponses.forEach(prizeResponse -> {
            String result = prizeResponse.matchingNumberCount() + "개 일치";
            if (prizeResponse.bonusNumberStatus().equals("INCLUDE_BONUS")) {
                result += ", 보너스 볼 일치";
            }
            result += " (" + NumberFormat.getInstance().format(prizeResponse.prizeMoney()) + "원)"
                    + " - "
                    + prizeResponse.winningCount() + "개";

            System.out.println(result);
        });
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
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
}
