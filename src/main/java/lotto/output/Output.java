package lotto.output;

import static lotto.constants.OutputPrompts.MATCHED_FIVE;
import static lotto.constants.OutputPrompts.MATCHED_FIVE_BONUS;
import static lotto.constants.OutputPrompts.MATCHED_FOUR;
import static lotto.constants.OutputPrompts.MATCHED_SIX;
import static lotto.constants.OutputPrompts.MATCHED_THREE;
import static lotto.constants.OutputPrompts.PURCHASE_RESULT;
import static lotto.constants.OutputPrompts.TOTAL_PROFIT_RATE;
import static lotto.constants.OutputPrompts.WINNING_STATISTICS_HEADER;
import static lotto.constants.RankNumber.FIFTH;
import static lotto.constants.RankNumber.FIRST;
import static lotto.constants.RankNumber.FOURTH;
import static lotto.constants.RankNumber.SECOND;
import static lotto.constants.RankNumber.THIRD;

import java.text.DecimalFormat;
import java.util.Arrays;
import lotto.input.Lotto;
import lotto.input.Purchase;
import lotto.logic.LottoNumbersGenerator;
import lotto.logic.LottoResultEvaluator;

public class Output {

    public static void purchaseCountOutput(Purchase purchase) {
        System.out.printf(PURCHASE_RESULT.getMessage(), purchase.getCount());
    }

    public static void generateLottosOutput(LottoNumbersGenerator lottos) {
        System.out.println();
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public static void resultOutput(LottoResultEvaluator lottoResultEvaluator) {
        System.out.println("\n" + WINNING_STATISTICS_HEADER.getMessage());
        System.out.printf(MATCHED_THREE.getMessage(), lottoResultEvaluator.getResult().getOrDefault(FIFTH.getNumber(), 0));
        System.out.printf(MATCHED_FOUR.getMessage(), lottoResultEvaluator.getResult().getOrDefault(FOURTH.getNumber(), 0));
        System.out.printf(MATCHED_FIVE.getMessage(), lottoResultEvaluator.getResult().getOrDefault(THIRD.getNumber(), 0));
        System.out.printf(MATCHED_FIVE_BONUS.getMessage(), lottoResultEvaluator.getResult().getOrDefault(SECOND.getNumber(), 0));
        System.out.printf(MATCHED_SIX.getMessage(), lottoResultEvaluator.getResult().getOrDefault(FIRST.getNumber(), 0));

        profitRateOutput(lottoResultEvaluator);
    }

    private static void profitRateOutput(LottoResultEvaluator lottoResultEvaluator) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        System.out.printf(TOTAL_PROFIT_RATE.getMessage(), decimalFormat.format(lottoResultEvaluator.getReturnRate()));
    }


}
