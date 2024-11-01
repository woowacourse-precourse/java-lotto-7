package lotto.view;

import java.util.List;
import java.util.SequencedMap;
import lotto.domain.Rank;

public class OutputView {

    public static void printPurchaseCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public static void printLottoTickets(List<List<Integer>> lottoTickets){
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void printWinningStatistics(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningResults(SequencedMap<Rank,Integer> results){
        for (Rank rank : Rank.values()) {
            int count = results.get(rank);
            if(rank == Rank.NONE){
                continue;
            }

            if(rank == Rank.FIVE_AND_BONUS){
                System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                        rank.getMatchCount(), formatCurrency(rank.getPrize()), count));
                continue;
            }

            System.out.println(String.format("%d개 일치 (%s원) - %d개",
                    rank.getMatchCount(), formatCurrency(rank.getPrize()), count));
        }

    }

    private static String formatCurrency(long amount){
        return String.format("%,d", amount);
    }

}
