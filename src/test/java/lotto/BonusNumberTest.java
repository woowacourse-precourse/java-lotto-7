package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BonusNumberTest {
    @DisplayName("보너스 번호가 1에서 45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "", "46", "-1"})
    void 보너스_번호_범위_예외_테스트(String bonusNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(bonusNumber, List.of(1, 2, 3, 4, 5, 6)))
                .withMessageMatching("\\[ERROR] 번호는 1에서 45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1,2", " "})
    void 보너스_번호_숫자_예외_테스트(String bonusNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(bonusNumber, List.of(1, 2, 3, 4, 5, 6)))
                .withMessageMatching("\\[ERROR] 유효하지 않는 숫자 형식입니다.*");
    }

    @DisplayName("당첨 번호와 중복되는 숫자일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호와_보너스_번호_중복_예외_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber("1", List.of(1, 2, 3, 4, 5, 6)))
                .withMessageMatching("\\[ERROR] 중복된 로또 번호가 존재합니다.");
    }
}
