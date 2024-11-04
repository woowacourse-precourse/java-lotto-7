package lotto.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @DisplayName("돈이 0원 이하, 10만원 초과로 입력될때 오류를 냅니다.")
    @ValueSource(ints = {-1000, -100000, 0, 110000, 100000000})
    void 돈이_잘못된_범위면_오류(int target) {
        assertThatThrownBy(() -> new Money(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_MONEY_RANGE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("돈이 1000원 단위가 아니면 오류를 냅니다.")
    @ValueSource(ints = {1001, 1999, 10001, 12300, 99999})
    void 돈이_잘못된_단위면_오류(int target) {
        assertThatThrownBy(() -> new Money(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_MONEY_UNIT.getMessage());
    }
}
