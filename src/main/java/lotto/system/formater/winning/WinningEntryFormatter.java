package lotto.system.formater.winning;

import lotto.system.utils.PrizeType;

public class WinningEntryFormatter { // 각 개별 당첨 항목 포맷

    private final static String WINNINGS_MESSAGE = "%d개 일치 (%d원) - %d개";
    private final static String BONUS_WINNINGS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";

    public static String formatWinnings(int code, int count) {
        PrizeType typeByCode = PrizeType.getTypeByCode(code);
        if (typeByCode == PrizeType.SECOND_PRIZE) {
            return String.format(BONUS_WINNINGS_MESSAGE, typeByCode.getCode(), typeByCode.getPrizeMoney(), count);
        }
        return String.format(WINNINGS_MESSAGE, typeByCode.getCode(), typeByCode.getPrizeMoney(), count);
    }

}
