package lotto.domain.lottoMachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningLottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = Lotto.from("1,2,3,4,5,6");
    }

    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        BonusNumber bonusNumber = BonusNumber.from("1");
        assertThatThrownBy(() -> WinningLotto.of(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideLottoForRank")
    void 로또_당첨_결과를_확인할_수_있다(String numbers, Rank expected) {
        // given
        BonusNumber bonusNumber = BonusNumber.from("7");
        WinningLotto winningLotto = WinningLotto.of(lotto, bonusNumber);

        // when
        Rank rank = winningLotto.getRank(Lotto.from(numbers));

        // then
        assertThat(rank).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoForRank() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", Rank.FIRST),
                Arguments.of("1,2,3,4,5,7", Rank.SECOND),
                Arguments.of("1,2,3,4,5,8", Rank.THIRD),
                Arguments.of("1,2,3,4,8,9", Rank.FOURTH),
                Arguments.of("1,2,3,8,9,10", Rank.FIFTH),
                Arguments.of("1,2,8,9,10,11", Rank.NONE)
        );
    }
}
