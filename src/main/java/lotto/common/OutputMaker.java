package lotto.common;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.PurchaseOverview;

import java.util.stream.Collectors;

public class OutputMaker {
    public static PurchaseOverview makePurchaseOverview(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos.getLottos()) {
            sb.append(makeLottoInfo(lotto));
        }
        return new PurchaseOverview(sb.toString());
    }

    private static String makeLottoInfo(Lotto lotto) {
        return lotto.getNumbers()
                .stream()
                .map(l -> String.valueOf(l.getNumber()))
                .collect(Collectors.joining(", ", "[", "]\n"));
    }
}
