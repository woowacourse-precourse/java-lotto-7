package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 46})
    @DisplayName("보너스 번호는 1과 45 사이의 정수여야 한다")
    void numberOutOfRangeThrowException(int outRange) {
        assertThatThrownBy(() -> BonusNumber.from(outRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 정수여야 합니다.");
    }
}
