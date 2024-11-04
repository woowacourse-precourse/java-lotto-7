package lotto.store.logger;

import lotto.store.lotto.Lotto;

import java.util.List;

public class LottoStoreLogFormatter {
    private static final String PURCHASED_SIZE_MESSAGE_FORMAT = "%d개를 구매했습니다.";

    public String format(List<Lotto> lottos) {
        StringBuilder result = new StringBuilder();
        result.append(PURCHASED_SIZE_MESSAGE_FORMAT.formatted(lottos.size())).append("\n");
        for (Lotto lotto : lottos) {
            result.append(lotto).append("\n");
        }
        return result.toString();
    }
}
