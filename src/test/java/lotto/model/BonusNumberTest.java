package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스 번호는 로또 번호 범위 내에 있어야 한다.")
    @ValueSource(ints = {0, 46})
    @ParameterizedTest
    void bonusNumberInRangeLotto(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45사이여야 합니다.");
    }

}