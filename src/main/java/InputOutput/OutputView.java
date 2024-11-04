package InputOutput;

import Rank.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void firstMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void promptWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void bonusNumberMessage(){
        System.out.println("");
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public static int calculateNumberOfSheetsFromAmount(int price){
        if (price < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 금액은 1,000원 이상이어야 합니다.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원의 배수여야 합니다.");
        }
        int numberOfTickets = price / 1000;
        return numberOfTickets;
    }
    public static void printLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println("");
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket); // 각 로또 티켓의 번호 출력
        }
        System.out.println("");
    }
    public static int printWinningStatistics(Map<Rank, Integer> rankCount){
        System.out.println("");
        System.out.println("당첨 통계\n---");
        int totalPrize = 0;
        // 원하는 출력 순서대로 Rank 배열 정의
        Rank[] ranksToPrint = {
                Rank.FIFTH, // 3개 일치
                Rank.FOURTH, // 4개 일치
                Rank.THIRD,
                Rank.SECOND, // 5개 일치, 보너스 볼 일치
                Rank.FIRST, // 6개 일치
        };

        for (Rank rank : ranksToPrint) {
            int count = rankCount.getOrDefault(rank, 0);
            System.out.printf("%s - %d개\n", rank.description, count);
            totalPrize += count * rank.prize;
        }
        return totalPrize;
    }
    public static void outputReturnRate(int totalPrize, int price){
        double yield = (double) totalPrize / price * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}
