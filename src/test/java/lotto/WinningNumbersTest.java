package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WinningNumbersTest {
    @DisplayName("당첨 번호의 개수가 6개가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "", "1,2,3,4,5,6,7"})
    void 당첨_번호_개수_예외_테스트(String winningNumbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(winningNumbers))
                .withMessageMatching("\\[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 포함되어 있을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호_중복_예외_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers("1,1,2,3,4,5"))
                .withMessageMatching("\\[ERROR] 중복된 로또 번호가 존재합니다.");
    }

    @DisplayName("당첨 번호가 1에서 45사이의 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46", "-1,2,3,4,5,6"})
    void 당첨_번호_범위_예외_테스트(String winningNumbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(winningNumbers))
                .withMessageMatching("\\[ERROR] 번호는 1에서 45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("당첨 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,1,2,3,4,5", "\\n,1,2,3,4,5"})
    void 당첨_번호_숫자_테스트(String winningNumbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(winningNumbers))
                .withMessageMatching("\\[ERROR] 유효하지 않는 숫자 형식입니다.*");
    }
}
