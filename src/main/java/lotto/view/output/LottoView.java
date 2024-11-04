package lotto.view.output;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoView {

    public static void printLottos(Lottos lottos) {
        String lottoDisplay = createLottoDisplay(lottos);
        System.out.print(lottoDisplay);
    }

    private static String createLottoDisplay(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n")
                .append(lottos.getLottoCount())
                .append("개를 구매했습니다.\n")
                .append(lottoListDisplay(lottos))
                .append("\n");

        return stringBuilder.toString();
    }

    private static String lottoListDisplay(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

}
