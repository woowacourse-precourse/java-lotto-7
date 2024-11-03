package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTicketsTest {

    @Test
    @DisplayName("발행한 로또 번호 값 출력 포맷에 맞게 반환 테스트")
    void 발행한_로또_번호_출력_포맷_테스트() {
        // Given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        LottoTickets lottoTickets = new LottoTickets(lottos);

        // When
        String result = lottoTickets.toString();

        // Then
        String expected = """
                [1, 2, 3, 4, 5, 6]
                [7, 8, 9, 10, 11, 12]
                [13, 14, 15, 16, 17, 18]""";
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("lottoPrizeDataProvider")
    @DisplayName("로또 당첨 결과를 확인 테스트")
    void 로또_당첨_결과_확인_테스트(WinningLotto winningLotto,
                               LottoTickets lottoTickets,
                               Map<LottoPrize, Integer> expectedResults) {
        // Given & When
        Map<LottoPrize, Integer> lottoPrizesMap = lottoTickets.getLottoPrizesMap(winningLotto);

        // Then
        assertThat(lottoPrizesMap).containsExactlyInAnyOrderEntriesOf(expectedResults);
    }

    static Stream<Object[]> lottoPrizeDataProvider() {
        return Stream.of(
                new Object[]{
                    new WinningLotto(
                            new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 당첨 번호
                            new Number(10))
                    ,
                    new LottoTickets(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                            new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 3등
                            new Lotto(List.of(1, 2, 3, 4, 8, 9)), // 4등
                            new Lotto(List.of(1, 2, 3, 10, 11, 12)), // 5등
                            new Lotto(List.of(1, 2, 13, 14, 15, 16)), // 꽝
                            new Lotto(List.of(17, 18, 19, 20, 21, 22)) // 꽝
                    )),
                    Map.of(LottoPrize.FIRST_PRIZE, 1,
                            LottoPrize.SECOND_PRIZE, 0,
                            LottoPrize.THIRD_PRIZE, 1,
                            LottoPrize.FOURTH_PRIZE, 1,
                            LottoPrize.FIFTH_PRIZE, 1,
                            LottoPrize.NO_PRIZE, 2)
                },
                new Object[]{
                        new WinningLotto(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Number(10)),
                        new LottoTickets(List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등 (보너스 포함)
                                new Lotto(List.of(1, 2, 3, 4, 8, 9)), // 3등
                                new Lotto(List.of(1, 2, 3, 10, 11, 12)), // 4등
                                new Lotto(List.of(1, 2, 13, 14, 15, 16)), // 5등
                                new Lotto(List.of(17, 18, 19, 20, 21, 22)) // 꽝
                        )),
                        Map.of(
                                LottoPrize.FIRST_PRIZE, 1,
                                LottoPrize.SECOND_PRIZE, 0,
                                LottoPrize.THIRD_PRIZE, 1,
                                LottoPrize.FOURTH_PRIZE, 1,
                                LottoPrize.FIFTH_PRIZE, 1,
                                LottoPrize.NO_PRIZE, 2
                        )
                }
        );
    }

}