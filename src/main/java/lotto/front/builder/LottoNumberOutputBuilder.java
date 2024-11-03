package lotto.front.builder;

import java.util.List;

import static lotto.global.enums.OutputMessage.*;

public class LottoNumberOutputBuilder {
    private static final String NEW_LINE = "\n";

    public static String build(List<List<Integer>> lottoNumberSets) {
        StringBuilder stringBuilder = new StringBuilder();

        String purchaseLottoMessage = String.format(LOTTO_PURCHASE.getMessage(), lottoNumberSets.size());
        stringBuilder.append(purchaseLottoMessage).append(NEW_LINE);

        lottoNumberSets.forEach(purchasedLotto -> stringBuilder.append(purchasedLotto.toString()).append(NEW_LINE));
        return stringBuilder.toString();
    }
}
