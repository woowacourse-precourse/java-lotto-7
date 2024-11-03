package lotto.io;

import lotto.Lotto;
import lotto.LottoPrize;
import lotto.dto.LottoResult;

import java.util.List;

public class LottoResponseWriter {

    public void responseLottoPurchase(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<String> lottoNumbers = lotto.getNumbers().stream()
                .map(String::valueOf)
                .toList();
            String message = String.format("[%s]", String.join(", ", lottoNumbers));
            System.out.println(message);
        }
        System.out.println();
    }

    public void responseLottoPrize(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        long totalPrize = 0;

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            int prizeCount = lottoResult.prizeResult().getOrDefault(lottoPrize, 0);
            totalPrize += (long) lottoPrize.getMoney() * prizeCount;
            System.out.printf("%s - %d개%n", lottoPrizeKorean(lottoPrize), prizeCount);
        }

        double profitRate = (double) totalPrize / lottoResult.userBuyMoney() * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    private String lottoPrizeKorean(LottoPrize lottoPrize) {
        if (lottoPrize == LottoPrize.THREE_MATCH) return "3개 일치 (5,000원)";
        if (lottoPrize == LottoPrize.FOUR_MATCH) return "4개 일치 (50,000원)";
        if (lottoPrize == LottoPrize.FIVE_MATCH) return "5개 일치 (1,500,000원)";
        if (lottoPrize == LottoPrize.FIVE_MATCH_WITH_BONUS) return "5개 일치, 보너스 볼 일치 (30,000,000원)";
        if (lottoPrize == LottoPrize.SIX_MATCH) return "6개 일치 (2,000,000,000원)";
        throw new RuntimeException("[ERROR] 당첨 결과에 알맞는 메시지가 없습니다.");
    }
}
