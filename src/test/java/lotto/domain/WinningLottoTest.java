package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @DisplayName("담첨번호에 보너스 번호 포함시 예외")
    @Test
    void validateContainBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(4);
        assertThatThrownBy(() -> WinningLotto.createWinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또와 로또를 비교해 등수 반환")
    @ParameterizedTest
    @MethodSource("lottos")
    void getRankTest(Lotto purchasedLotto,Rank expactRank) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = WinningLotto.createWinningLotto(lotto, bonusNumber);
        assertThat(winningLotto.getRank(purchasedLotto)).isEqualTo(expactRank);
    }

    static Stream<Arguments> lottos() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Rank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Rank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), Rank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 8)), Rank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)), Rank.FIFTH),
                Arguments.of(new Lotto(List.of(1, 2, 7, 8, 9, 10)), null),
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), null)
        );
    }

}
