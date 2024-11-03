package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinCalculatorTest {
    static LottoWinCalculator lottoWinMan;
    
    @BeforeAll
    static void setLottoManager() {
        lottoWinMan = new LottoWinCalculator(List.of(1,2,3,4,5,6), 7);
    }

    static Stream<Arguments> 로또_개별_테스트값_생성() {
        // {테스트 로또, 예상 당첨결과}
        return Stream.of(
                    Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), WinningType.CLASS_1),
                    Arguments.of(new Lotto(List.of(1,2,7,4,5,6)), WinningType.CLASS_2),
                    Arguments.of(new Lotto(List.of(1,2,3,29,5,6)), WinningType.CLASS_3),
                    Arguments.of(new Lotto(List.of(10,20,3,4,5,6)), WinningType.CLASS_4),
                    Arguments.of(new Lotto(List.of(10,20,30,4,5,6)), WinningType.CLASS_5),
                    Arguments.of(new Lotto(List.of(10,20,30,40,5,6)), WinningType.NONE)
                );
    }

    @ParameterizedTest(name = "로또 당첨결과 테스트 [{index}] {1}")
    @MethodSource("로또_개별_테스트값_생성")
    void 로또_당첨결과_기능_테스트(Lotto lotto, WinningType expected) {
        assertEquals(expected, lottoWinMan.getWinningResult(lotto));
    }

    static Stream<Arguments> 로또_다중_테스트값_생성() {
        // {테스트 로또 리스트, 당첨 종류(오름차순)별 갯수 리스트}
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1,2,3,4,5,6)), 
                                new Lotto(List.of(1,2,3,4,5,6)),
                                new Lotto(List.of(1,2,3,4,5,6)),
                                new Lotto(List.of(1,2,3,4,5,6)),
                                new Lotto(List.of(1,2,3,4,5,6)),
                                new Lotto(List.of(1,2,3,4,5,6)),
                                new Lotto(List.of(1,2,3,4,5,6)),
                                new Lotto(List.of(1,2,3,4,5,6))
                        ), 
                        List.of(8)),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1,7,3,4,5,6)), 
                                new Lotto(List.of(1,20,30,4,5,6)),
                                new Lotto(List.of(1,2,3,4,5,6)),
                                new Lotto(List.of(10,20,30,40,15,6)),
                                new Lotto(List.of(10,20,30,4,5,6)),
                                new Lotto(List.of(1,9,3,4,5,6)),
                                new Lotto(List.of(12,2,3,4,5,6)),
                                new Lotto(List.of(1,12,30,4,5,6))
                        ), 
                        List.of(1, 1, 1, 2, 2, 1)),
                Arguments.of(
                        List.of(
                                new Lotto(List.of(1,7,10,4,5,6)), 
                                new Lotto(List.of(45,44,43,42,5,6)),
                                new Lotto(List.of(1,2,7,4,5,6)),
                                new Lotto(List.of(10,20,30,40,15,6)),
                                new Lotto(List.of(10,6,30,4,2,1)),
                                new Lotto(List.of(1,3,2,7,5,6)),
                                new Lotto(List.of(12,42,3,44,5,6)),
                                new Lotto(List.of(1,2,30,44,45,6))
                        ), 
                        List.of(2,2,2,2))
                );
    }

    @ParameterizedTest(name = "로또 당첨 통계 테스트 [{index}]")
    @MethodSource("로또_다중_테스트값_생성")
    void 로또_당첨_통계_기능_테스트(List<Lotto> lottos, List<Integer> expected) {
        assertThat(lottoWinMan.getWinningStat(lottos).values()).containsExactlyElementsOf(expected);
    }
}
