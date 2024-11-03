package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Constants.Error;

class LottoTest {
    @Test
    @DisplayName("로또_번호의_개수가_6개가_넘어가면_예외가_발생한다")
    void 로또번호_개수_upperbound() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또_번호의_개수가_6개보다_적으면_예외가_발생한다")
    void 로또번호_개수_lowerbound() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("범위를 벗어난 숫자가 있으면 예외가 발생한다. 최소범위 테스트")
    @Test
    void 범위_테스트_min() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 숫자가 있으면 예외가 발생한다. 최대범위 테스트")
    @Test
    void 범위_테스트_max() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 중복 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 보너스_번호_중복_테스트(int value) {
        assertThatThrownBy(
                () -> {
                    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                    lotto.validateBonusNumber(value);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.LOTTO_NUMBERS_DUPLICATED.getText());
    }

    @DisplayName("보너스 번호 범위 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {-1000, 0, 46, 1000})
    void 보너스_번호_범위_테스트(int value) {
        assertThatThrownBy(
                () -> {
                    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
                    lotto.validateBonusNumber(value);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.LOTTO_NUMBERS_OUT_OF_RANGE.getText());
    }

    @DisplayName("보너스 번호 기능 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {7, 8, 9, 45})
    void 보너스_번호_기능_테스트(int value) {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            lotto.validateBonusNumber(value);
        });
    }


}
