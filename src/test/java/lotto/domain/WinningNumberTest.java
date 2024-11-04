package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {
    @Test
    void 당첨번호_생성() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumber).isNotNull();
    }

    @Test
    void 당첨번호_중복_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 5), 7)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_개수_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5), 7)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_번호범위_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 46), 7)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_보너스번호_중복_예외처리() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 6)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    void 보너스번호_범위_예외처리(int value) {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), value)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨_확인() {
        Lotto firstLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 7));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumber.findReward(firstLotto)).isEqualTo(LottoReward.FIRST);
        assertThat(winningNumber.findReward(secondLotto)).isEqualTo(LottoReward.SECOND);
    }
}
