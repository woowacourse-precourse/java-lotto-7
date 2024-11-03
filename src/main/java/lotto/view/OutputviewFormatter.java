package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputviewFormatter {

    public static String formatLottoNumbers(Lottos lottos) {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            Collections.sort(lottoNumbers);
            sb.append(lottoNumbers).append("\n");
        }

        return sb.toString().trim();
    }
}
