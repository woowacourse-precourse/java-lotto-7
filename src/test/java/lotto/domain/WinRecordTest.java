package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinRecordTest {
    @DisplayName("당첨 현황 저장 및 반환 확인")
    @Test
    void checkWinRecord() {
        List<Integer> winningRank = Arrays.asList(1, 2, 5, 0, 0);
        List<Integer> successWinRecord = Arrays.asList(1, 1, 0, 0, 1);
        WinRecord winRecord = new winRecord(winningRank);

        assertDoesNotThrow(() -> winRecord.setWinRecord(winningRank));

        assertEquals(winRecord.getWinRecord(), successWinRecord);
    }

    @DisplayName("당첨 금액 총합 반환 확인")
    @Test
    void checkWinRecord() {
        List<Integer> winningRank = Arrays.asList(1, 2, 5, 0, 0);
        long successtotalPrize = 2_030_005_000;
        winRecord winRecord = new winRecord(winningRank);
        winRecord.setWinRecord(winningRank);

        assertEquals(winRecord.getTotalPrize(), successtotalPrize);
    }
}
