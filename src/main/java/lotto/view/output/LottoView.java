package lotto.view.output;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoView {

    public static void printLottos(Lottos lottos) {
        String lottoDisplay = createLottoDisplay(lottos);
        System.out.print(lottoDisplay);
    }

    private static String createLottoDisplay(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        StringBuilder result = new StringBuilder();

        result.append(lottoList.size())
                .append("개를 구매했습니다.\n");

        lottoList.forEach(lotto ->
            result.append(lotto.toString()).append("\n")
        );

        return result.toString();
    }
}
