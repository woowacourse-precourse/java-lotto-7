package module;

import lotto.Lotto;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public enum Rank {
    FIFTH(3, false, 5000, "3개 일치"),
    FOURTH(4, false, 50000, "4개 일치"),
    SECOND(5, false, 1500000, "5개 일치"),
    SECONDWITHBONUS(5, true, 30000000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, 2000000000, "6개 일치"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean isMatchedBonus;
    private final int prize;
    private final String description;

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    Rank(int matchCount, boolean isMatchedBonus, int prize, String description) {
        this.matchCount = matchCount;
        this.isMatchedBonus = isMatchedBonus;
        this.prize = prize;
        this.description = description;
    }

    private static Rank getRank(int matchCount, boolean bonusMatch){
        for(Rank rank : values()){
            if(rank.matchCount == matchCount && (!rank.isMatchedBonus || bonusMatch == rank.isMatchedBonus)){
                return rank;
            }
        }
        return NONE;
    }

    private static Rank getLottoRank(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.getRank(matchCount, bonusMatch);
    }

    public static void printResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

        // 초기화
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = getLottoRank(lotto, winningNumbers, bonusNumber);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        int totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();

            if (rank != Rank.NONE) {
                NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
                String formattedPrize = numberFormat.format(rank.getPrize());
                System.out.println(rank.getDescription() + " (" + formattedPrize + "원) - " + count + "개");
            }
        }

        // 수익률 계산
        double profitRate = ((double) totalPrize / (lottos.size() * 1000)) * 100;

        System.out.println("총 수익 " + totalPrize + " 총 구입 " + (lottos.size() * 1000));

        // 소수점 둘째 자리에서 반올림
        profitRate = Math.round(profitRate * 10) / 10.0;

        // 수익률 출력
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
