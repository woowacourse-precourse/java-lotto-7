package lotto.model.cost;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CostTest {

    @DisplayName("1000원 단위로 금액을 입력받지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 300, 2003, 4500, 50201})
    void validUnitCostTest(int cost) {
        // given

        // when

        // then
        assertThatThrownBy(() -> Cost.from(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1000원 단위로 입력해주세요.");
    }

    @DisplayName("금액에 음수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -2000, -10000, -300000})
    void negativeCostTest(int cost) {
        // given

        // when

        // then
        assertThatThrownBy(() -> Cost.from(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 음수를 입력할 수 없습니다.");
    }

    @DisplayName("금액에 0을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0})
    void blankCostTest(int cost) {
        // given

        // when

        // then
        assertThatThrownBy(() -> Cost.from(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액을 입력해주세요.");
    }

    @DisplayName("올바른 금액을 입력하면 금액을 저장한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 40000, 5000000})
    void CreateCostTest(int cost) {
        // given

        // when

        // then
        assertThat(Cost.from(cost).getCost())
                .isEqualTo(cost);
    }


}