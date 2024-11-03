package lotto.system.formater.winning;

import lotto.system.utils.PrizeType;

public class WinningEntryFormatter { // 각 개별 당첨 항목 포맷

    private static final String FORMAT_MESSAGE = "%s - %d개";

    public static String formatWinnings(int code, int count) {
        PrizeType typeByCode = PrizeType.getTypeByCode(code);
        return String.format(FORMAT_MESSAGE, typeByCode.getDescription(), count);
    }
}
