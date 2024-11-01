package lotto.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.configuration.Prize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProfitReportTest {


    static Stream<Arguments> 수익_계산_테스트_케이스() {
        return Stream.of(
                // 1등
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, 2_000_000_000),

                // 2등 (5개 일치 + 보너스 번호 일치)
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6), 7, 30_000_000),

                // 3등 (5개 일치)
                Arguments.of(List.of(1, 2, 3, 4, 5, 11), List.of(1, 2, 3, 4, 5, 6), 7, 1_500_000),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), List.of(1, 2, 3, 4, 5, 6), 7, 1_500_000),
                Arguments.of(List.of(1, 2, 3, 4, 7, 10), List.of(1, 2, 3, 4, 5, 6), 7, 1_500_000),

                // 4등 (4개 일치)
                Arguments.of(List.of(1, 2, 3, 4, 11, 12), List.of(1, 2, 3, 4, 5, 6), 7, 50_000),
                Arguments.of(List.of(1, 2, 3, 7, 11, 12), List.of(1, 2, 3, 4, 5, 6), 7, 50_000),

                // 5등 (3개 일치)
                Arguments.of(List.of(1, 2, 3, 11, 12, 13), List.of(1, 2, 3, 4, 5, 6), 7, 5_000),
                Arguments.of(List.of(1, 2, 3, 14, 15, 16), List.of(1, 2, 3, 4, 5, 6), 7, 5_000),

                // 당첨되지 않음 (0~2개 일치)
                Arguments.of(List.of(8, 9, 10, 11, 12, 13), List.of(1, 2, 3, 4, 5, 6), 7, 0),
                Arguments.of(List.of(30, 31, 32, 33, 34, 35), List.of(1, 2, 3, 4, 5, 6), 7, 0),

                // 보너스 번호만 일치 (당첨되지 않음)
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), List.of(1, 2, 3, 4, 5, 6), 7, 0));
    }


    static Stream<Arguments> 수익률_계산_테스트_케이스() {
        return Stream.of(Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), // 구매한 로또 리스트
                List.of(1, 2, 3, 4, 5, 6), // 당첨 번호 리스트
                7, // 보너스 번호
                200000000.0 // 예상 수익률 (2,000,000,000 / 1,000 * 100)
        ), Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(10, 11, 12, 13, 14, 15))),
                List.of(1, 2, 3, 4, 5, 6), 7, 100000000.0 // 예상 수익률 ((2,000,000,000 / 2,000) * 100)
        ), Arguments.of(List.of(new Lotto(List.of(8, 9, 10, 11, 12, 13))), List.of(1, 2, 3, 4, 5, 6), 7, 0.0
                // 예상 수익률 (0 / 1,000 * 100)
        ));
    }

    static Stream<Arguments> 각_등수_별_당첨_횟수_계산_테스트_케이스() {
        return Stream.of(
                // 1등 당첨 케이스
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        Map.of(Prize.FIRST, 1)
                ),
                // 2등 당첨 (5개 + 보너스 번호 일치)
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        Map.of(Prize.SECOND, 1)
                ),
                // 3등 당첨 (5개 일치)
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        Map.of(Prize.THIRD, 1)
                ),
                // 4등 당첨 (4개 일치)
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 10, 11))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        Map.of(Prize.FOURTH, 1)
                ),
                // 5등 당첨 (3개 일치)
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 10, 11, 12))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        Map.of(Prize.FIFTH, 1)
                ),
                // 여러 등수 복합 테스트
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                                new Lotto(List.of(1, 2, 3, 4, 10, 11)) // 4등
                        ),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        Map.of(Prize.FIRST, 1, Prize.SECOND, 1, Prize.THIRD, 1, Prize.FOURTH, 1)
                )
        );
    }


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

    // getter 테스트들

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

    // 계산 테스트들

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

    @ParameterizedTest
    @MethodSource("수익률_계산_테스트_케이스")
    void 성공__수익률_계산_테스트_케이스(List<Lotto> lottoInputs, List<Integer> winningNumbersInput, int bonusNumber,
                            double expected) {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput, bonusNumber);
        ProfitReport profitReport = new ProfitReport(lottoInputs, winningNumbers);

        // when
        double actual = profitReport.calculateProfitRate();

        // then
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @MethodSource("각_등수_별_당첨_횟수_계산_테스트_케이스")
    void 성공__각_등수_별_당첨_횟수_계산(List<Lotto> lottoInputs, List<Integer> winningNumbersInput, int bonusNumber,
                             Map<Prize, Integer> expected) {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput, bonusNumber);
        ProfitReport profitReport = new ProfitReport(lottoInputs, winningNumbers);

        // when
        Map<Prize, Integer> actual = profitReport.calculateWinningCountsByRank();

        // then
        assertEquals(expected, actual);
    }

}