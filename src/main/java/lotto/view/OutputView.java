package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningStatistic;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    public void printPurchasedLottoCount(int lottoCount){
        System.out.println(lottoCount+"개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            lotto.printNumbers();
        }
    }

    public void printStatistics(List<WinningStatistic> statistics){
        System.out.println("당첨 통계\n" + "---");
        for(WinningStatistic statistic : statistics){
            String formattedPrice = formatPrice(statistic.getPrizeAmount());
            System.out.printf("%s (%s원) - %d개\n",statistic.presentStatus(),formattedPrice, statistic.getOccurrence());
        }
    }

    public String formatPrice(int price){
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedPrice = formatter.format(price);
        return formattedPrice;
    }
}
