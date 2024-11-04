package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoBallTest {

    @DisplayName("로또볼은 1 부터 45 사이의 숫자를 갖는 로또볼을 뽑는다.")
    @ValueSource(ints = {1, 45})
    @ParameterizedTest
    void 로또볼은_1부터_45_사이의_숫자(int number) {
        assertThat(LottoBall.draw(number).number())
                .isEqualTo(number);
    }

    @DisplayName("1 미만 45 초과의 숫자를 갖는 로또볼은 존재하지 않아 예외가 발생한다.")
    @ValueSource(ints = {0, 46})
    @ParameterizedTest
    void 범위를_벗어난_로또볼은_예외_발생(int number) {
        assertThatThrownBy(() -> LottoBall.draw(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호", "1", "45");
    }

}
