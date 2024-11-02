package lotto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;

import static lotto.Constant.*;

public class Output {
    public static void printLotto(List<Lotto> values) {
        System.out.println("\n" + values.size() + "개를 구매했습니다.");
        for (Lotto value : values) {
            System.out.println(Arrays.toString(value.getNumbers().toArray()));
        }

        System.out.println();
    }

    public static void printWinner(int cost) {
        System.out.println("당첨 통계\n---");
        for (LottoEnum value : LottoEnum.values()) {
            if (value.getPrize() == 0) {
                break;
            }
            if (value.getMatchCount() == LOTTO_BONUS_CORRECT) {
                System.out.println("5개 일치, 보너스 볼 일치 (" + prizeToString(value.getPrize()) + "원) - " + value.getWinnerCount() + "개");
                continue;
            }
            System.out.println(value.getMatchCount() + "개 일치 (" + prizeToString(value.getPrize()) + "원) - " + value.getWinnerCount() + "개");
        }

        System.out.println("총 수익률은 " + new DecimalFormat("#,###.0").format((LottoEnum.sum() / cost) * 100) + "%입니다.");
    }

    public static String prizeToString(int prize) {
        return NumberFormat.getNumberInstance().format(prize);
    }
}
