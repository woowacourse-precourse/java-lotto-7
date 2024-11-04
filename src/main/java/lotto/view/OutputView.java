package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.List;

import static lotto.domain.LottoPrize.*;

public class OutputView {

    private static final String HYPHEN = "-";

    public static void showPurchasedLottos(Lottos lottos) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottos.getSize()).append("개를 구매했습니다.").append("\n");

        for (Lotto lotto : lottos.getLottos()) {
            String printLotto = lotto.printLotto();
            stringBuilder.append(printLotto).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void showPurchasedLottosStatus(LottoResult lottoResult) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계").append("\n");
        stringBuilder.append(HYPHEN.repeat(3)).append("\n");

        List<LottoPrize> prizes = List.of(FIFTH_PRIZE, FOURTH_PRIZE, THIRD_PRIZE, SECOND_PRIZE, FIRST_PRIZE);
        for (LottoPrize prize : prizes) {
            stringBuilder.append(prize.getDescription()).append(" - ")
                .append(lottoResult.getLottoPrizeCounts(prize)).append("개").append("\n");
        }

        stringBuilder.append("총 수익률은 ").append(String.format("%.1f", lottoResult.calculateYield())).append("%입니다.");
        System.out.println(stringBuilder);
    }
}
