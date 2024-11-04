package lotto.system.formater.winning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.system.utils.PrizeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningEntryFormatterTest {

    @Test
    @DisplayName("유효한 코드와 개수를 사용하여 당첨 항목 포맷")
    void formatWinnings_withValidCodeAndCount() {
        int code = 3;
        int count = 5;

        PrizeType prizeType = PrizeType.getTypeByCode(code);
        String expectedOutput = String.format("%s - %d개", prizeType.getDescription(), count);

        String formattedOutput = WinningEntryFormatter.formatWinnings(code, count);

        assertEquals(expectedOutput, formattedOutput);
    }

    @Test
    @DisplayName("개수가 0인 경우 당첨 항목 포맷")
    void formatWinnings_withZeroCount() {
        int code = 5;
        int count = 0;

        PrizeType prizeType = PrizeType.getTypeByCode(code);
        String expectedOutput = String.format("%s - %d개", prizeType.getDescription(), count);

        String formattedOutput = WinningEntryFormatter.formatWinnings(code, count);

        assertEquals(expectedOutput, formattedOutput);
    }
}