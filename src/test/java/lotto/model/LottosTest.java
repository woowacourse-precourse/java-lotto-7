package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {
    static Lottos sampleLottos;

    @BeforeEach
    void setUpTest() {
        sampleLottos = new Lottos();
        sampleLottos.insertLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        sampleLottos.insertLotto(new Lotto(List.of(1, 2, 3, 11, 12, 13)));
        sampleLottos.insertLotto(new Lotto(List.of(1, 2, 3, 4, 12, 13)));
    }

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("lottosTest")
    @DisplayName("선택한 수에 따른 결과 테스트")
    void prize_findByHitAndBonusTest(Lotto targetLotto, int targetBonus, String message, int totalMoney) {

        Result sampleResult = sampleLottos.getResult(targetLotto, targetBonus);

        assertEquals(sampleResult.totalMoney(), totalMoney);
    }

    static Stream<Arguments> lottosTest() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 12, 13, 45)), 4, "2등+3등+5등", 31_505_000),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7, "1등+4등+5등", 2_000_055_000),
                Arguments.of(new Lotto(List.of(1, 2, 3, 20, 21, 22)), 4, "5등 3개", 15_000),
                Arguments.of(new Lotto(List.of(30, 31, 32, 33, 34, 35)), 1, "x", 0)
        );
    }
}
