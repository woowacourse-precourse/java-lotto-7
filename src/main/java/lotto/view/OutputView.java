package lotto.view;

import java.util.List;

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
}
