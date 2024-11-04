package lotto.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.configuration.Prize;
import lotto.dto.PrizeCountEntry;
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
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(List.of(7, 8, 9, 10, 11, 12)), // 꽝
                                new Lotto(List.of(13, 14, 15, 16, 17, 18)), // 꽝
                                new Lotto(List.of(19, 20, 21, 22, 23, 24)), // 꽝
                                new Lotto(List.of(25, 26, 27, 28, 29, 30)), // 꽝
                                new Lotto(List.of(31, 32, 33, 34, 35, 36)), // 꽝
                                new Lotto(List.of(37, 38, 39, 40, 41, 42))  // 꽝
                        ),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        0.0
                ),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 꽝
                                new Lotto(List.of(13, 14, 15, 16, 17, 18)), // 꽝
                                new Lotto(List.of(19, 20, 21, 22, 23, 24)), // 꽝
                                new Lotto(List.of(25, 26, 27, 28, 29, 30)), // 꽝
                                new Lotto(List.of(31, 32, 33, 34, 35, 36)), // 꽝
                                new Lotto(List.of(37, 38, 39, 40, 41, 42))  // 꽝
                        ),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        2_000_000_000.0 / 6000 * 100
                ),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                                new Lotto(List.of(1, 3, 5, 14, 22, 45))
                        ),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        62.5
                )
        );
    }


    static Stream<Arguments> 각_등수_별_당첨_횟수_계산_테스트_케이스() {
        return Stream.of(
                // 1등 당첨 케이스
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(
                                new PrizeCountEntry(Prize.NONE, 0),
                                new PrizeCountEntry(Prize.FIFTH, 0),
                                new PrizeCountEntry(Prize.FOURTH, 0),
                                new PrizeCountEntry(Prize.THIRD, 0),
                                new PrizeCountEntry(Prize.SECOND, 0),
                                new PrizeCountEntry(Prize.FIRST, 1)
                        )),
                // 2등 당첨 (5개 + 보너스 번호 일치)
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(
                                new PrizeCountEntry(Prize.NONE, 0),
                                new PrizeCountEntry(Prize.FIFTH, 0),
                                new PrizeCountEntry(Prize.FOURTH, 0),
                                new PrizeCountEntry(Prize.THIRD, 0),
                                new PrizeCountEntry(Prize.SECOND, 1),
                                new PrizeCountEntry(Prize.FIRST, 0))
                ),
                // 3등 당첨 (5개 일치)
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(
                                new PrizeCountEntry(Prize.NONE, 0),
                                new PrizeCountEntry(Prize.FIFTH, 0),
                                new PrizeCountEntry(Prize.FOURTH, 0),
                                new PrizeCountEntry(Prize.THIRD, 1),
                                new PrizeCountEntry(Prize.SECOND, 0),
                                new PrizeCountEntry(Prize.FIRST, 0))
                ),
                // 4등 당첨 (4개 일치)
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 10, 11))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(
                                new PrizeCountEntry(Prize.NONE, 0),
                                new PrizeCountEntry(Prize.FIFTH, 0),
                                new PrizeCountEntry(Prize.FOURTH, 1),
                                new PrizeCountEntry(Prize.THIRD, 0),
                                new PrizeCountEntry(Prize.SECOND, 0),
                                new PrizeCountEntry(Prize.FIRST, 0))
                ),
                // 5등 당첨 (3개 일치)
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 10, 11, 12))),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(
                                new PrizeCountEntry(Prize.NONE, 0),
                                new PrizeCountEntry(Prize.FIFTH, 1),
                                new PrizeCountEntry(Prize.FOURTH, 0),
                                new PrizeCountEntry(Prize.THIRD, 0),
                                new PrizeCountEntry(Prize.SECOND, 0),
                                new PrizeCountEntry(Prize.FIRST, 0)
                        )
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
                        List.of(
                                new PrizeCountEntry(Prize.NONE, 0),
                                new PrizeCountEntry(Prize.FIFTH, 0),
                                new PrizeCountEntry(Prize.FOURTH, 1),
                                new PrizeCountEntry(Prize.THIRD, 1),
                                new PrizeCountEntry(Prize.SECOND, 1),
                                new PrizeCountEntry(Prize.FIRST, 1)
                        )
                ),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                                new Lotto(List.of(1, 3, 5, 14, 22, 45))
                        ),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        List.of(
                                new PrizeCountEntry(Prize.NONE, 7),
                                new PrizeCountEntry(Prize.FIFTH, 1),
                                new PrizeCountEntry(Prize.FOURTH, 0),
                                new PrizeCountEntry(Prize.THIRD, 0),
                                new PrizeCountEntry(Prize.SECOND, 0),
                                new PrizeCountEntry(Prize.FIRST, 0)
                        )
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
        assertEquals(winningNumbers.getMainNumbers(), actual.getMainNumbers());
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
                () -> actual.getMainNumbers().add(1));

        // then
        assertEquals(winningNumbers.getMainNumbers(), actual.getMainNumbers());
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
        assertEquals(expected, actual, 0.00001);

    }

    @ParameterizedTest
    @MethodSource("각_등수_별_당첨_횟수_계산_테스트_케이스")
    void 성공__각_등수_별_당첨_횟수_계산(List<Lotto> lottoInputs, List<Integer> winningNumbersInput, int bonusNumber,
                             List<PrizeCountEntry> expected) {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput, bonusNumber);
        ProfitReport profitReport = new ProfitReport(lottoInputs, winningNumbers);

        // when
        List<PrizeCountEntry> actual = profitReport.calculateWinningCountsByPrize();

        // then
        assertEquals(expected, actual);
    }

}