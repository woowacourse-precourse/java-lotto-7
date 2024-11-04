package lotto.io;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import lotto.dto.IncomeStatics;
import lotto.dto.PrizeStatics;
import lotto.dto.PurchasedLottos;

public class OutputParser {

    private static final String NEW_LINE = "\n";

    public String parsePurchasedLottos(final PurchasedLottos purchasedLottos) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(NEW_LINE);
        stringBuilder.append(purchasedLottos.lottos().size());
        stringBuilder.append("개를 구매했습니다.");
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(getPurchasedLottoString(purchasedLottos));

        return stringBuilder.toString();
    }

    private static String getPurchasedLottoString(final PurchasedLottos purchasedLottos) {
        StringBuilder stringBuilder = new StringBuilder();

        purchasedLottos.lottos().forEach(lotto -> {
            stringBuilder.append(lotto);
            stringBuilder.append(NEW_LINE);
        });

        return stringBuilder.toString();
    }

    public String parsePrizeStatics(final PrizeStatics prizeStatics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(NEW_LINE);
        stringBuilder.append("당첨 통계");
        stringBuilder.append(NEW_LINE);
        stringBuilder.append("---");
        stringBuilder.append(getPrizeCountString(prizeStatics));

        return stringBuilder.toString();
    }

    private static String getPrizeCountString(final PrizeStatics prizeStatics) {
        StringBuilder stringBuilder = new StringBuilder();

        prizeStatics.prizeCount().forEach((prize, count) -> {
            stringBuilder.append(NEW_LINE);
            stringBuilder.append(prize.description);
            stringBuilder.append(" - ");
            stringBuilder.append(count);
            stringBuilder.append("개");
        });

        return stringBuilder.toString();
    }

    public String parseIncomeStatics(final IncomeStatics incomeStatics) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("총 수익률은 ");
        stringBuilder.append(formatPercent(incomeStatics.incomePercent()));
        stringBuilder.append("%입니다.");

        return stringBuilder.toString();
    }

    private static String formatPercent(final double incomePercent) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

        return decimalFormat.format(incomePercent);
    }

    public String parseExceptionMessage(final Exception e) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(NEW_LINE);
        stringBuilder.append("[ERROR] ");
        stringBuilder.append(e.getMessage());
        stringBuilder.append(NEW_LINE);

        return stringBuilder.toString();
    }
}
