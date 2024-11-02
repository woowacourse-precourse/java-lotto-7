package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

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

        stringBuilder.append(LottoPrize.FIFTH_PRIZE.getDescription()).append(" - ")
            .append(lottoResult.getLottoPrizeCounts(LottoPrize.FIFTH_PRIZE)).append("개").append("\n");
        stringBuilder.append(LottoPrize.FOURTH_PRIZE.getDescription()).append(" - ")
            .append(lottoResult.getLottoPrizeCounts(LottoPrize.FOURTH_PRIZE)).append("개").append("\n");
        stringBuilder.append(LottoPrize.THIRD_PRIZE.getDescription()).append(" - ")
            .append(lottoResult.getLottoPrizeCounts(LottoPrize.THIRD_PRIZE)).append("개").append("\n");
        stringBuilder.append(LottoPrize.SECOND_PRIZE.getDescription()).append(" - ")
            .append(lottoResult.getLottoPrizeCounts(LottoPrize.SECOND_PRIZE)).append("개").append("\n");
        stringBuilder.append(LottoPrize.FIRST_PRIZE.getDescription()).append(" - ")
            .append(lottoResult.getLottoPrizeCounts(LottoPrize.FIRST_PRIZE)).append("개").append("\n");

        stringBuilder.append("총 수익률은 ").append(String.format("%.1f", lottoResult.calculateYield())).append("%입니다.");
        System.out.println(stringBuilder);
    }
}
