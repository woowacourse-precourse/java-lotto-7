package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputviewFormatter {

    public static String formatLottoNumbers(Lottos lottos) {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos.getLottos()) {
            sb.append(lotto.getLottoNumbers()).append("\n");
        }

        return sb.toString().trim();
    }
}
