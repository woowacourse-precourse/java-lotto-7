package lotto.view;

import lotto.Lotto;
import lotto.Prize;
import lotto.number.LottoNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final List<Prize> PRIZES = List.of(Prize.FIVE, Prize.FOUR, Prize.THREE, Prize.TWO, Prize.ONE);
    private static final String PURCHASE_LOTTO_SENTENCE = "개를 구매했습니다.";
    private static final String HIT_LOTTO_STATISTICS = "당첨 통계";
    private static final String DELIMITER = "---";

    public static void purchaseLottoResultView(List<Lotto> lottos) {
        System.out.println(lottos.size()+PURCHASE_LOTTO_SENTENCE);

        lottos.forEach(lotto ->  {
            lottoNumberResultView(lotto.getNumbers());
        });

    }

    public static void lottoNumberResultView(List<LottoNumber> lotto) {
        String formattedNumbers = lotto.stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(formattedNumbers);
    }

    public static void hitLottoNumberResultView(Map<Prize, Integer> prizes) {
        System.out.println();
        System.out.println(HIT_LOTTO_STATISTICS);
        System.out.println(DELIMITER);

        for(Prize prize : PRIZES) {
            int prizeCount = prizes.getOrDefault(prize, 0);
            System.out.println(prize.getMessage()+prizeCount+"개");
        }
    }

    public static void ratioResultView(double ratio) {
        System.out.println("총 수익률은 " + ratio +"%입니다.");
    }

}
