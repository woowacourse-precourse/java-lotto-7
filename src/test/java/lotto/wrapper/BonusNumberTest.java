package lotto.wrapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @DisplayName("보너스 번호는 숫자여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1.1", "", " "})
    void 보너스_번호는_숫자여야_한다(String inputNumber) {
        Assertions.assertThatThrownBy(() -> BonusNumber.of(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 정수여야 합니다.");
    }

    @DisplayName("보너스 번호는 1부터 45 사이여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void 보너스_번호는_1부터_45_사이여야_한다(String inputNumber) {
        Assertions.assertThatThrownBy(() -> BonusNumber.of(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
    }

}
