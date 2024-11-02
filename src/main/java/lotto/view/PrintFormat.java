package lotto.view;

import java.util.Arrays;

public enum PrintFormat {
    WITH_BONUS_MATCH(true, "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n"),
    WITHOUT_BONUS_MATCH(false, "%d개 일치 (%,d원) - %d개%n");
    private final boolean containBonusMatch;
    private final String messageFormat;

    PrintFormat(boolean containBonusMatch, String messageFormat) {
        this.containBonusMatch = containBonusMatch;
        this.messageFormat = messageFormat;
    }

    public static String getFormat(boolean isBonusNumberRequired) {
        return Arrays.stream(values()).filter(value -> value.containBonusMatch == isBonusNumberRequired).findFirst()
                .get().messageFormat;
    }
}
