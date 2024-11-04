package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("유효한 로또 번호로 객체 생성")
    void constructor_validNumbers_shouldCreateLotto() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닌 경우 예외 발생")
    void constructor_invalidNumberCount_shouldThrowException() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 예외 발생")
    void constructor_duplicateNumbers_shouldThrowException() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 3, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어난 경우 예외 발생")
    void constructor_numberOutOfRange_shouldThrowException() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
