package lotto.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    void 실패__당첨_번호_가져온것_수정_불변테스트() {
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
    void 실패__구매한_로또_가져온것_수정_불변테스트() {
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

    // 계산 테스트들

    static Stream<Arguments> 수익_계산_테스트_케이스() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, 2_000_000_000),   // 1등
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6), 7, 30_000_000),      // 2등
                Arguments.of(List.of(1, 2, 3, 4, 5, 11), List.of(1, 2, 3, 4, 5, 6), 7, 1_500_000),      // 3등
                Arguments.of(List.of(1, 2, 3, 4, 7, 11), List.of(1, 2, 3, 4, 5, 6), 7, 1_500_000),      // 3등 + 보너스 번호
                Arguments.of(List.of(1, 2, 3, 4, 11, 12), List.of(1, 2, 3, 4, 5, 6), 7, 50_000),        // 4등
                Arguments.of(List.of(1, 2, 3, 7, 11, 12), List.of(1, 2, 3, 4, 5, 6), 7, 50_000),        // 4등 + 보너스 번호
                Arguments.of(List.of(1, 2, 3, 11, 12, 13), List.of(1, 2, 3, 4, 5, 6), 7, 5_000),        // 5등
                Arguments.of(List.of(1, 2, 7, 11, 12, 13), List.of(1, 2, 3, 4, 5, 6), 7, 5_000)         // 5등 + 보너스 번호
        );
    }

    @ParameterizedTest
    @MethodSource("수익_계산_테스트_케이스")
    void 성공__수익_계산(List<Integer> lottoInput, List<Integer> winningNumbersInput, int bonusNumber, long expected) {
        // given
        Lotto lotto = new Lotto(lottoInput);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput, bonusNumber);
        ProfitReport profitReport = new ProfitReport(List.of(lotto), winningNumbers);

        // when
        long actual = profitReport.calculateProfit();

        // then
        assertEquals(expected, actual);
    }

    @Test
    void 성공__수익률_계산_테스트_케이스() {
        // calculateProfit
    }

    @Test
    void 성공__각_등수_별_당첨_횟수_계산() {
        // calculateWinningCountsByRank
    }

}