package lotto.view;

import lotto.dto.PurchasedLottosResponse;
import lotto.dto.WinningSummaryResponse;
import lotto.view.formatter.OutputFormatter;

public class OutputView {
    private final OutputFormatter outputFormatter;
    private static OutputView instance;

    private OutputView(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView(OutputFormatter.getInstance());
        }

        return instance;
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

    public void printPurchasedLottos(PurchasedLottosResponse purchasedLottos) {
        String formattedLottos = outputFormatter.formatPurchasedLottos(purchasedLottos);
        System.out.println(formattedLottos);
    }

    public void printWinningResult(WinningSummaryResponse winningSummary) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        winningSummary.winningDetailResponse()
                .forEach(winningDetail -> {
                    String formattedWinningDetail = outputFormatter.formatWinningDetail(winningDetail);
                    System.out.println(formattedWinningDetail);
                });
        System.out.printf("총 수익률은 %.1f%%입니다.%n", winningSummary.profitRate());
    }
}
