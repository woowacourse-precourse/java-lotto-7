package lotto.domain;

import lotto.constants.string.RangeError;
import lotto.constants.value.LottoRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class ComponentNumberTest {

    @Test
    @DisplayName("ComponentNumber는 지정된 범위를 벗어나면 에러가 난다")
    void testNumberRangerValidation() {

        //최대를 벗어난 경우
        assertThatThrownBy(() -> {
                    new ComponentNumber(LottoRule.MAXIMUM_NUMBER_RANGE.getInstance() + 1);
                }
        ).hasMessageContaining(RangeError.NUMBER.getInstance());

        //최소를 벗어난 경우
        assertThatThrownBy(() -> {
            new ComponentNumber(LottoRule.MINIMUM_NUMBER_RANGE.getInstance() - 1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RangeError.NUMBER.getInstance());

    }

    @Test
    @DisplayName("ComponentNumber는 내부의 값에따라 비교가 가능하다")
    void testEqualsMethod() {
        ComponentNumber num1 = new ComponentNumber(2);
        ComponentNumber num2 = new ComponentNumber(2);

        assertThat(num1).isEqualTo(num2);
    }
}
