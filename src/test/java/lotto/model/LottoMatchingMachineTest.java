package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMatchingMachineTest {

    Winning winning;

    @BeforeEach
    void setUp() {
        this.winning = new Winning
                (new Lotto(List.of(1,2,3,4,5,6)), new Bonus(7));
    }

    @ParameterizedTest
    @DisplayName("숫자 매치 확인")
    @MethodSource("lottoInstance")
    void 숫자_매치(Lotto purchasedLotto, int matched){
        //when
        int matchedNumber = winning.match(purchasedLotto);
        //then
        assertThat(matched).isEqualTo(matchedNumber);
    }

    private static Stream<Arguments> lottoInstance(){
        return Stream.of(
                Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), 6),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,7)), 5),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,8)), 5),
                Arguments.of(new Lotto(List.of(1,2,3,4,8,9)), 4),
                Arguments.of(new Lotto(List.of(1,2,3,8,9,10)), 3),
                Arguments.of(new Lotto(List.of(1,2,8,9,10,11)), 2),
                Arguments.of(new Lotto(List.of(1,8,9,10,11,12)), 1),
                Arguments.of(new Lotto(List.of(8,9,10,11,12,13)), 0)
        );
    }

    @Test
    @DisplayName("보너스 매치 확인")
    void 보너스_매치(){
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,7));
        //when, then
        assertThat(winning.isBonusMatch(lotto)).isTrue();
    }
}