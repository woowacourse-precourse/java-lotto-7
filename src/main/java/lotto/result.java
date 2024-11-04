package lotto;

public class result {
    public static void profitRate(int budget) {
        // 수익률 계산
        double totalProfitRate = 0;

        for ( LottoRank rank : LottoRank.values()) {
            int count = rank.getCount();
            int prize = rank.getPrize();
            double profitRate = (double) (count * prize) / budget * 100; // 수익률 계산
            totalProfitRate += profitRate; // 총 수익률에 더하기
        }

        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalProfitRate);
    }
}
