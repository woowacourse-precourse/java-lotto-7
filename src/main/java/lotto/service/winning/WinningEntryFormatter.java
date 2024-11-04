package lotto.service.winning;

import static lotto.config.WinningMessage.CONTENT;

import lotto.utils.PrizeType;

public class WinningEntryFormatter { // 각 개별 당첨 항목 포맷

    public static String formatWinnings(int code, int count) {
        PrizeType typeByCode = PrizeType.getTypeByCode(code);
        return String.format(CONTENT.getMessage(), typeByCode.getDescription(), count);
    }
}
