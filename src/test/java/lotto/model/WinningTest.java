package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningTest {

    private Winning winning = new Winning(new Lotto(List.of(1,2,3,4,5,6)), new Bonus(7));

    @ParameterizedTest(name = "로또 숫자 메칭 개수 : {1} ")
    @MethodSource("lottoAndMatchedCount")
    void 로또번호_일치(Lotto lotto, int expectedMatchedCount) {
        //given
        //when
        int result = winning.match(lotto);
        //then
        assertThat(expectedMatchedCount).isEqualTo(result);
    }

    static Stream<Arguments> lottoAndMatchedCount() {
        return Stream.of(
                Arguments.arguments(new Lotto(List.of(1,2,3,4,5,6)), 6),
                Arguments.arguments(new Lotto(List.of(1,2,3,4,5,8)), 5),
                Arguments.arguments(new Lotto(List.of(1,2,3,4,8,9)), 4),
                Arguments.arguments(new Lotto(List.of(1,2,3,8,9,10)), 3),
                Arguments.arguments(new Lotto(List.of(1,2,8,9,10,11)), 2),
                Arguments.arguments(new Lotto(List.of(1,8,9,10,11,12)), 1),
                Arguments.arguments(new Lotto(List.of(8,9,10,11,12,13)), 0)
        );
    }

    @Test
    void 보너스_숫자_메칭() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,6,5,7));
        //when
        boolean result = winning.isBonusMatch(lotto);
        //then
        assertThat(result).isTrue();
    }
}