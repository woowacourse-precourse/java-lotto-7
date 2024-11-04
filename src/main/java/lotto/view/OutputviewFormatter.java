package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class OutputviewFormatter {

    public static String formatLottoNumbers(Lottos lottos) {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            List<Integer> sortableLottoNumbers = new ArrayList<>(lottoNumbers);
            Collections.sort(sortableLottoNumbers);
            sb.append(sortableLottoNumbers).append("\n");
        }

        return sb.toString().trim();
    }
}
