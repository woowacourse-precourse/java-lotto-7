package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseLotto;
import lotto.domain.Rank;
import lotto.domain.RateOfReturn;

public class OutputView {

    private static final String RATE_FORMAT = "#,##0.0";

    public static void printPurchaseInputText() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedCount(PurchaseLotto purchaseLotto) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchaseLotto.getLottoCount());
    }

    public static void printPurchasedLottoTickets(PurchaseLotto purchaseLotto) {
        StringBuilder lottoTickets = new StringBuilder();
        purchaseLotto.getTickets().stream()
                .forEach(lotto -> lottoTickets.append(lotto).append("\n"));
        System.out.println(lottoTickets);
    }

    public static void printWinningNumberInputText() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputText() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printWinningResult(LottoResult lottoResult) {
        System.out.println("\n당첨 통계\n---");
        Arrays.stream(Rank.values())
                .forEach(rank -> System.out.printf(rank.getLotteryStatistics(), lottoResult.getMatchesCount(rank)));
    }

    public static void printRateOfReturn(RateOfReturn rateOfReturn) {
        DecimalFormat decimalFormat = new DecimalFormat(RATE_FORMAT);
        System.out.printf("총 수익률은 %s%%입니다.", decimalFormat.format(rateOfReturn.getRateOfReturn()));
    }

    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
