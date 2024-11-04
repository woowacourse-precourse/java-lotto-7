package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호가 1-45 사이일 때 정상적으로 생성된다")
    void createBonusNumber() {
        // given, when
        BonusNumber bonusNumber = new BonusNumber(45);

        // then
        assertThat(bonusNumber.getNumber()).isEqualTo(45);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 100})
    @DisplayName("보너스 번호가 1-45 범위를 벗어나면 예외가 발생한다")
    void validateBonusNumberRange(int number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45사이여야 합니다.");
    }
}
