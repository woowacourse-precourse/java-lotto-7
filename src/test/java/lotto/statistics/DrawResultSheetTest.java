package lotto.statistics;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawResultSheetTest {

    @DisplayName("일치하는 개수 카운터를 넣어 생성, 총 상금 계산을 요청하면 총 상금을 반환한다.")
    @Test
    void shouldReturnTotalPrizeAmountWhenRequestCalculating() {
        // give
        List<Integer> matchedCounter = List.of(1, 1, 1, 1, 1, 1, 1, 1);
        DrawResultSheet drawResultSheet = new DrawResultSheet(matchedCounter);
        long expectedPrizeAmount = 2031555000L;

        // when
        long actualPrizeAmount = drawResultSheet.calculateTotalPrizeAmount();

        // then
        Assertions.assertThat(actualPrizeAmount).isEqualTo(expectedPrizeAmount);
    }
}
