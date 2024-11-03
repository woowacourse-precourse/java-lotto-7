package view;

import domain.lotto.Lotto;
import domain.prize.Prize;
import domain.prize.PrizeResult;

import java.util.List;

import static domain.prize.Prize.FIRST;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto));
    }

    public static void printPrizeStatistics(PrizeResult prizeResult, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        printPrizeLine(Prize.FIFTH, prizeResult.getFifthCount());
        printPrizeLine(Prize.FOURTH, prizeResult.getFourthCount());
        printPrizeLine(Prize.THIRD, prizeResult.getThirdCount());
        printPrizeLine(Prize.SECOND, prizeResult.getSecondCount());
        printPrizeLine(FIRST, prizeResult.getFirstCount());

        double profitRate = calculateProfitRate(prizeResult, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private static void printPrizeLine(Prize prize, int count) {
        String prizeDescription = null;
        switch (prize) {
            case FIRST:
                prizeDescription = "6개 일치 (2,000,000,000원) - ";
                break;
            case SECOND:
                prizeDescription = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
                break;
            case THIRD:
                prizeDescription = "5개 일치 (1,500,000원) - ";
                break;
            case FOURTH:
                prizeDescription = "4개 일치 (50,000원) - ";
                break;
            case FIFTH:
                prizeDescription = "3개 일치 (5,000원) - ";
                break;
            case NONE:
                break;
            default:
                prizeDescription = "";
        }
        System.out.println(prizeDescription + count + "개");
    }

    private static double calculateProfitRate(PrizeResult prizeResult, int purchaseAmount) {
        long totalPrize = prizeResult.calculateTotalPrize();
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}