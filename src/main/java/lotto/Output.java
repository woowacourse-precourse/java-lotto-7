package lotto;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

public class Output {
    public static void printLotto(List<Lotto> values) {
        System.out.println(values.size() + "개를 구매했습니다.");
        for (int i = 0; i < values.size(); i++) {
            System.out.println(Arrays.toString(values.get(i).getNumbers().toArray()));
        }
        System.out.println();
    }

    public static void printWinner(int cost) {
        System.out.println("당첨 통계\n---");

        for (LottoEnum lotto : LottoEnum.values()) {
            if (lotto.getPrizeAmount() == 0) {
                break;
            }
            if (lotto.getMatchCount() == Constant.LOTTO_BONUS_CORRECT) {
                System.out.println("5개 일치, 보너스 볼 일치 (" + getPrizeToString(lotto.getPrizeAmount()) + "원) - " + lotto.getWinnerCount() + "개");
                continue;
            }
            System.out.println(lotto.getMatchCount() + "개 일치 (" + getPrizeToString(lotto.getPrizeAmount()) + "원) - " + lotto.getWinnerCount() + "개");
        }

        System.out.println("총 수익률은 " + getRevenue(cost) + "% 입니다.");
    }

    public static double getRevenue(int cost) {
        return LottoEnum.sum() / cost;
    }

    public static String getPrizeToString(int prize) {
        return NumberFormat.getNumberInstance().format(prize);
    }
}
