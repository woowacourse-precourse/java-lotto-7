package lotto.domain.lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("로또 번호 범위를 넘어가는 숫자는 로또 번호로 사용할 수 없다.")
    @ValueSource(ints = {0, -1, 46})
    void 로또_번호_범위_예외(int input) {
        // given
        // when & then
        assertThatThrownBy(() -> {
            LottoNumber.of(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("서로 같은 숫자를 구별할 수 있다.")
    void 객체_서로_같은_값_비교() {
        // given
        LottoNumber one = LottoNumber.of(1);
        LottoNumber otherOne = LottoNumber.of(1);

        // when
        boolean same = one.equals(otherOne);

        // then
        assertThat(same).isTrue();
    }
}