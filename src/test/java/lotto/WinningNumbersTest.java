package lotto;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("당첨 번호와 보너스 번호는 중복이 되면 예외가 발생한다.")
    @Test
    void 당첨_번호와_보너스_번호는_중복이_되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개여야");
    }

    @DisplayName("6개 번호 일치 시 1등 반환")
    @Test
    void matchSixNumbers_returnsFirstRank() {
        Rank rank = Rank.valueOf(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.getPrize()).isEqualTo(2000000000);
    }

    @DisplayName("5개 번호 일치 + 보너스 번호 일치 시 2등 반환")
    @Test
    void matchFiveNumbersAndBonus_returnsSecondRank() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.getPrize()).isEqualTo(30000000);
    }

    @DisplayName("5개 번호 일치 시 3등 반환")
    @Test
    void matchFiveNumbers_returnsThirdRank() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.getPrize()).isEqualTo(1500000);
    }

    @DisplayName("4개 번호 일치 시 4등 반환")
    @Test
    void matchFourNumbers_returnsFourthRank() {
        Rank rank = Rank.valueOf(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
        assertThat(rank.getPrize()).isEqualTo(50000);
    }

    @DisplayName("3개 번호 일치 시 5등 반환")
    @Test
    void matchThreeNumbers_returnsFifthRank() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
        assertThat(rank.getPrize()).isEqualTo(5000);
    }

    @DisplayName("일치하는 번호가 2개 이하일 때 당첨되지 않음 (NONE 반환)")
    @Test
    void lessThanThreeMatches_returnsNone() {
        Rank rank = Rank.valueOf(2, false);
        assertThat(rank).isEqualTo(Rank.NONE);
        assertThat(rank.getPrize()).isEqualTo(0);
    }
}
