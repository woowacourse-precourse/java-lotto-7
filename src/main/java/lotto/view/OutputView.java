package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.LottoRate;

public class OutputView {

    public void printLottoNumber(int count){
        System.out.println(count + "개를 구매하였습니다.");
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            String number = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + number + "] ");
        }
    }

    public void producePrize(Map<LottoRate, Integer> prize, double returnValue) {
        System.out.println("당첨 통계\n---");

        for (LottoRate rate : LottoRate.values()) {
            if (rate == LottoRate.NONE) {
                continue;
            }
            int count = prize.getOrDefault(rate, 0);
            if(rate == LottoRate.FIVE_MATCH_WITH_BONUS){
                cathBonus(rate, count);
                continue;
            }
            catchGeneral(rate, count);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnValue);
    }

    private static void catchGeneral(LottoRate rate, int count) {
        System.out.printf("%d개 일치 (%d원) - %d개%n",
                            rate.getMatchCount(), rate.getPrize(), count);
    }

    private static void cathBonus(LottoRate rate, int count) {
        System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개%n",
                rate.getMatchCount(), rate.getPrize(), count);
    }
}
