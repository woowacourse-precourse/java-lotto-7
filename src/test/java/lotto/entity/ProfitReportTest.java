package lotto.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProfitReportTest {

    // 생성 테스트

    @Test
    void 성공__생성() {
        // given
        Lotto lotto = Lotto.createRandomLotto();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        ProfitReport profitReport = new ProfitReport(List.of(lotto), winningNumbers);

        // then
        assertNotNull(profitReport);
    }

    @Test
    void 실패__로또_NULL() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ProfitReport(null, winningNumbers));

        // then
        Assertions.assertEquals("구매한 로또는 null 또는 비어있을 수 없습니다.", exception.getMessage());
    }

    @Test
    void 실패__로또_EMPTY() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ProfitReport(List.of(), winningNumbers));

        // then
        Assertions.assertEquals("구매한 로또는 null 또는 비어있을 수 없습니다.", exception.getMessage());
    }

}