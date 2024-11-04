package lotto.view.output.util;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.response.PurchasedLottoDTO;

public final class OutputFormatter {
    private static final String PURCHASE_LOTTO_COUNT_FORMAT = "%d개를 구매했습니다.\n";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static String formatPurchaseLottoCount(Integer count) {
        return String.format(PURCHASE_LOTTO_COUNT_FORMAT, count);
    }

    public static String formatLottoNumbers(List<PurchasedLottoDTO> lottos) {
        return lottos.stream()
                .map(lotto -> lotto.numbers().toString())
                .collect(Collectors.joining(LINE_SEPARATOR)) + LINE_SEPARATOR;
    }
}
