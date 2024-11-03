package lotto.store.logger;

import lotto.store.lotto.Lotto;

import java.util.List;

public class LottoStoreLogFormatter {
    public String format(List<Lotto> lottos) {
        StringBuilder result = new StringBuilder();
        result.append("%d개를 구매했습니다.\n".formatted(lottos.size()));
        for (Lotto lotto : lottos) {
            result.append(lotto).append("\n");
        }
        return result.toString();
    }
}
