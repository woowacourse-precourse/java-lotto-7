package lotto.view;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.Wallet;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.WinningLottos;

public class Output {
    private final static String PRINT_RANK_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private final static String PRINT_SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private final static String PRINT_RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.\n";


    public static void printError(String error) {
        System.out.printf("[ERROR] %s \n", error);
    }

    public static void printPurchasedLottoList(Wallet wallet, RandomLottos randomLottos){
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n",wallet.getTicket());
        for(Lotto lotto : randomLottos.getLottos()){
            System.out.println(lotto);
        }
    }

    public static void printLottoWinningStatistics(WinningLottos winningLottos){
        System.out.println("당첨 통계");
        System.out.println("---");
        StringBuilder printout = new StringBuilder();

        for(Map.Entry<Rank,Integer> entry : winningLottos.getWinningStatistics().entrySet()){
            Rank rank = entry.getKey();
            if(rank.equals(Rank.NOTHING)){
                continue;
            }

            int matchCount = rank.getMatchCount();
            String formatedPrizedMoney = String.format("%,d", rank.getPrizeMoney());
            int matchResult = entry.getValue();

            if(rank.equals(Rank.SECOND)){
                printout.append(
                        String.format(PRINT_SECOND_RANK_FORMAT, matchCount, formatedPrizedMoney, matchResult)
                );
                continue; //todo 이거 꼭 써야도;ㅁ 아니면 5/true 시 2,3등 업데이트됨
            }
            printout.append(
                    String.format(PRINT_RANK_FORMAT, matchCount, formatedPrizedMoney, matchResult)
            );
        }
        System.out.println(printout);
    }

    public static void printRateOfReturn(Wallet wallet){
        System.out.printf(PRINT_RATE_OF_RETURN_FORMAT, wallet.getRateOfReturn());

    }



}
