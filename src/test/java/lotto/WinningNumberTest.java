package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    @DisplayName("당첨 번호의 개수가 6보다 크면 예외가 발생한다.")
    @Test
    void 당첨_번호_개수_초과_검증_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of("1", "2", "3", "4", "5", "6", "7")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6보다 작으면 예외가 발생한다.")
    @Test
    void 당첨_번호_개수_미만_검증_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of("1", "2", "3", "4", "5")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호_중복_검증_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of("1", "3", "3", "4", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 공백이 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호_공백_검증_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of("1", "2", "", "4", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 입력이 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호_숫자_검증_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of("1", "2", "삼", "4", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1 ~ 45 범위 밖의 입력이 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호_범위_검증_초과_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of("1", "2", "47", "4", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1 ~ 45 범위 밖의 입력이 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호_범위_검증_미만_테스트() {
        assertThatThrownBy(() -> new WinningNumbers(List.of("0", "2", "3", "4", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
