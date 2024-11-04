package lotto.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinRecordTest {
    @BeforeEach
    void setupTestEnvironment() {
        System.setProperty("IS_TEST_ENV", "true");
    }

    @AfterEach
    void resetTestEnvironment() {
        System.clearProperty("IS_TEST_ENV");
    }

    @DisplayName("당첨 현황 저장 및 반환 확인")
    @Test
    void checkWinRecord() {
        WinRecord.resetInstance();
        List<Integer> winningRank = Arrays.asList(1, 2, 5, 0, 0);
        List<Integer> successWinRecord = Arrays.asList(0, 1, 1, 0, 0, 1);
        WinRecord winRecord = WinRecord.getWinRecord(winningRank);

        assertEquals(winRecord.getWinRecordCounts(), successWinRecord);
    }

    @ParameterizedTest
    @DisplayName("당첨 등수 예외 값 예외 확인")
    @ValueSource(ints = {-1, 6, 100})
    void checkWinRankError(int test) {
        WinRecord.resetInstance();

        assertThatThrownBy(() -> WinRecord.getWinRecord(Arrays.asList(test)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 등수로 들어올 수 없는 값이 들어왔습니다.");
    }

    @DisplayName("당첨 금액 총합 반환 확인")
    @Test
    void checkTotalWinningPrize() {
        WinRecord.resetInstance();
        List<Integer> winningRank = Arrays.asList(1, 2, 5, 0, 0);
        long successtotalPrize = 2_030_005_000;
        WinRecord winRecord = WinRecord.getWinRecord(winningRank);

        assertEquals(winRecord.getTotalWinningPrize(), successtotalPrize);
    }

    @DisplayName("당첨 최소 금액 총합 반환 확인")
    @Test
    void checkMinTotalWinningPrize() {
        WinRecord.resetInstance();
        List<Integer> winningRank = Collections.nCopies(100, 0);
        long successtotalPrize = 0;
        WinRecord winRecord = WinRecord.getWinRecord(winningRank);

        assertEquals(winRecord.getTotalWinningPrize(), successtotalPrize);
    }

    @DisplayName("당첨 최대 금액 총합 반환 확인")
    @Test
    void checkMaxTotalWinningPrize() {
        WinRecord.resetInstance();
        List<Integer> winningRank = Collections.nCopies(100, 1);
        long successtotalPrize = 2_000_000_000 * 100;
        WinRecord winRecord = WinRecord.getWinRecord(winningRank);

        assertEquals(winRecord.getTotalWinningPrize(), successtotalPrize);
    }

    @ParameterizedTest
    @DisplayName("당첨 금액 개별 확인")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void checkWinningPrize(int test) {
        WinRecord.resetInstance();
        WinRecord winRecord = WinRecord.getWinRecord(Arrays.asList(test));
        int successPrize = WinRecord.WINNING_PRIZES.get(test);

        assertEquals(winRecord.getTotalWinningPrize(), successPrize);
    }
}
