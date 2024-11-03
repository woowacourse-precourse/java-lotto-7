package lotto.statistics;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusBallTest {

    @DisplayName("로또 번호가 1~45가 아니면 예외가 발생한다.")
    @Test
    void shouldThrowIllegalArgumentExceptionWhenIsNotInRangeBonus() {
        assertThatThrownBy(() -> new BonusBall(65))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45만 가능합니다.");
    }

    @DisplayName("숫자 배열에 보너스 번호가 있으면 true를 반환한다.")
    @Test
    void shouldReturnTrueWhenHasBonus() {
        // give
        BonusBall bonusBall = new BonusBall(1);
        List<Integer> myLotto = List.of(1, 2, 3, 4, 5, 6);
        boolean expectedMatchResult = true;

        // when
        boolean actualMatchResult = bonusBall.matchBonus(myLotto);

        // then
        Assertions.assertThat(actualMatchResult).isEqualTo(expectedMatchResult);
    }

    @DisplayName("숫자 배열에 보너스 번호가 없으면 false를 반환한다.")
    @Test
    void shouldReturnFalseWhenHasNotBonus() {
        // give
        BonusBall bonusBall = new BonusBall(7);
        List<Integer> myLotto = List.of(1, 2, 3, 4, 5, 6);
        boolean expectedMatchResult = false;

        // when
        boolean actualMatchResult = bonusBall.matchBonus(myLotto);

        // then
        Assertions.assertThat(actualMatchResult).isEqualTo(expectedMatchResult);
    }
}
