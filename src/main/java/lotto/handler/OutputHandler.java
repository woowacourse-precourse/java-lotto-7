package lotto.handler;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import lotto.CorrectStatus;
import lotto.Lotto;

public class OutputHandler {

    public void printPurchasedLotto(final int ticket, final List<Lotto> purchasedLottos){

        System.out.println();
        System.out.println(ticket+"개를 구매했습니다.");

        purchasedLottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public void printWinningStatics(final Map<CorrectStatus,Integer> map){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        map.keySet().forEach(correctStatus -> {
            System.out.println(correctStatus.getMessage()+map.get(correctStatus)+"개");
        });
    }

    public void printProfitRate(final int profit,final int money){
        double profitRate = (double) profit / money * 100;

        DecimalFormat df = new DecimalFormat("#,###.0");

        System.out.println("총 수익률은 " + df.format(profitRate) + "%입니다.");
    }
}
