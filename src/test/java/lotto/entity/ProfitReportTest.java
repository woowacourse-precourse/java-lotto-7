package lotto.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // getter 테스트들

    @Test
    void 성공__당첨_번호_가져오기() {
        // given
        Lotto lotto = Lotto.createRandomLotto();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        ProfitReport profitReport = new ProfitReport(List.of(lotto), winningNumbers);

        // when
        WinningNumbers actual = profitReport.getWinningNumbers();

        // then
        assertEquals(winningNumbers.getWinningNumbers(), actual.getWinningNumbers());
        assertEquals(winningNumbers.getBonusNumber(), actual.getBonusNumber());
    }

    @Test
    void 실패__당첨_번호_가져온것_수정() {
        // given
        Lotto lotto = Lotto.createRandomLotto();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        ProfitReport profitReport = new ProfitReport(List.of(lotto), winningNumbers);

        // when
        WinningNumbers actual = profitReport.getWinningNumbers();
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class,
                () -> actual.getWinningNumbers().add(1));

        // then
        assertEquals(winningNumbers.getWinningNumbers(), actual.getWinningNumbers());
    }

    @Test
    void 성공__구매한_로또_가져오기() {
        // given
        Lotto lotto = Lotto.createRandomLotto();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        ProfitReport profitReport = new ProfitReport(List.of(lotto), winningNumbers);

        // when
        List<Lotto> actual = profitReport.getPurchasedLottos();

        // then
        assertEquals(1, actual.size());
        assertEquals(lotto, actual.get(0));
    }

    @Test
    void 실패__구매한_로또_가져온것_수정() {
        // given
        Lotto lotto = Lotto.createRandomLotto();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        ProfitReport profitReport = new ProfitReport(List.of(lotto), winningNumbers);

        // when
        List<Lotto> actual = profitReport.getPurchasedLottos();
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class,
                () -> actual.add(Lotto.createRandomLotto()));

        // then
        assertEquals(1, actual.size());
        assertEquals(lotto, actual.get(0));
    }

    @Test
    void 성공__투자한_금액_조회() {
        // given
        Lotto lotto = Lotto.createRandomLotto();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        ProfitReport profitReport = new ProfitReport(List.of(lotto), winningNumbers);

        // when
        int actual = profitReport.getPaymentAmount();

        // then
        assertEquals(1000, actual);
    }

    /**
     * Feature TODO
     * - [ ] 수익률 계산
     * - [ ] 수익 계산
     * - [ ] 각 등수 별 당첨 횟수 계산
     * - [ ] 각 로또별 당첨 여부 계산
     * <p>
     * - [x] 투자 금액 (gettter)
     * - [x] 당첨 번호 (getter)
     * - [x] 구매한 로또 (getter)
     */
}