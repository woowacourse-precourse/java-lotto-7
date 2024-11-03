package lotto;

import java.util.List;

public class OutputHandler {

    // 티켓 출력 메서드
    public void printTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket);
        }
    }

    // 당첨 결과 출력 메서드
    public void printResults(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getCountForRank(LottoRank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getCountForRank(LottoRank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getCountForRank(LottoRank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getCountForRank(LottoRank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getCountForRank(LottoRank.FIRST) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roundToFirstDecimalPlace(result.calculateProfitRate()));
    }

    // 수익률을 소수점 첫째 자리까지 반올림하는 메서드
    private double roundToFirstDecimalPlace(double value) {
        return Math.round(value * 10) / 10.0;
    }
}
