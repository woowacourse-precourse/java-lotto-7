package view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import lotto.Lotto;
import lotto.LottoRank;
import lotto.LottoResult;

public class OutputView {

    public static void printPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printPurchaseQuantity(BigDecimal purchaseQuantity) {
        System.out.println("\n" + purchaseQuantity + "개를 구매했습니다.");
    }

    public void printLottos(Set<Lotto> lottos) {
        lottos.stream()
              .map(Lotto::getNumbers)
              .forEach(System.out::println);
    }

    public void printLottoResult(LottoResult lottoResult) {
        printResultMessage();
        Map<LottoRank, Integer> rankCounts = lottoResult.getRankCounts();

        Arrays.stream(LottoRank.values())
              .filter(rank -> rank != LottoRank.NONE)
              .forEach(rank -> printLottoRank(rank, rankCounts.get(rank)));
    }

    private void printResultMessage() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    private void printLottoRank(LottoRank lottoRank, int matchCount) {
        DecimalFormat prizeFormatter = new DecimalFormat("#,###");
        String formattedPrize = prizeFormatter.format(lottoRank.getPrize());

        System.out.printf("%d개 일치", lottoRank.getWinningCount());
        if (lottoRank.isBonusMatched()) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.printf(" (%s원) - %d개\n", formattedPrize, matchCount);
    }

    public void printReturnOnInvestment(BigDecimal returnOnInvestment) {
        System.out.printf("총 수익률은 %,.1f%%입니다.%n", returnOnInvestment);
    }
}
