package lotto.domain.cost;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CostTest {
    @Test
    @DisplayName("1000 단위가 아닌 숫자는 구입 금액으로 설정할 수 없다.")
    void 숫자_단위_예외() {
        // given
        final int input = 999;

        // when & then
        assertThatThrownBy(() -> Cost.of(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("0 이하의 숫자는 구입 금액으로 설정할 수 없다.")
    @ValueSource(ints = {-1, 0})
    void 숫자_범위_예외(int input) {
        // given
        // when & then
        assertThatThrownBy(() -> Cost.of(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("50,000 원을 넘는 숫자는 구입 금액으로 설정할 수 없다.")
    @ValueSource(ints = {50001, 60000})
    void 숫자_범위_초과_예외(int input) {
        // given
        // when & then
        assertThatThrownBy(() -> Cost.of(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액을 통해 올바른 상품 개수를 반환할 수 있다.")
    void 구입_금액_계산() {
        // given
        final int input = 8000;

        // when
        Cost cost = Cost.of(input);

        // then
        assertThat(cost.getPurchaseCount()).isEqualTo(8);
    }
}