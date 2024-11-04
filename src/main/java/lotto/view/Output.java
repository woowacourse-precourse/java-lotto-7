package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCreate;
import lotto.domain.LottoMatch;
import lotto.domain.LottoResult;

public class Output {
    public static void printLottos(LottoCreate lottoCreate) {
        System.out.println(lottoCreate.getLottoCount() + "개를 구매했습니다.");
        for (Lotto lotto : lottoCreate.getLottos())
            System.out.println(lotto.getNumbers().toString());
        System.out.println();
    }

    public static void printStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            if (lottoMatch != LottoMatch.NONE) {
                System.out.printf("%s (%,d원) - %d개%n", lottoMatch.getStatements(),
                        lottoMatch.getPrize(),
                        lottoResult.getLottoResult(lottoMatch));
            }
        }
    }
}
