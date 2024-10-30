package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void numbersLengthOverException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void duplicatedLottoNumException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 출력하면 오름차순으로 정렬되어 출력된다.")
    @Test
    void printLotto() {
        // given
        Lotto lotto = new Lotto(List.of(45, 6, 2, 4, 12, 5));
        // when
        String toString = lotto.toString();
        // then
        assertThat(toString).isEqualTo("[2, 4, 5, 6, 12, 45]");
    }

    @DisplayName("보너스 번호를 할당한다.")
    @Test
    void setBonusNum() {
        // given
        Lotto lotto = new Lotto(List.of(45, 6, 2, 4, 12, 5));
        Bonus bonus = new Bonus(lotto);
        // when & then
        assertThatCode(() -> bonus.setNum(1)).doesNotThrowAnyException();
        assertTrue(bonus.isCorrectNum(1));
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {45, 6, 2, 4, 12, 5})
    void duplicatedBonusNumException(int bonusNum) {
        // given
        Lotto lotto = new Lotto(List.of(45, 6, 2, 4, 12, 5));
        Bonus bonus = new Bonus(lotto);
        // when & then
        assertThatThrownBy(() -> bonus.setNum(bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
