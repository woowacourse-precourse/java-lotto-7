package lotto.view.formatter;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class LottoFormatter {

    public LottoFormatter() {
    }

    public String formatCount(List<Lotto> lottos) {
        int lottoCount = lottos.size();
        String lottosInfo = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));

        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottosInfo;
    }

    public String formatInfo(List<Lotto> lottos) {
        String lottosInfo = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
        return lottosInfo;
    }
}
