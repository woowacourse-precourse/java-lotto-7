package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {
    @DisplayName("보너스 번호가 숫자가 아닌 입력이라면 예외가 발생한다")
    @Test
    void 보너스_번호_숫자_검증_테스트() {
        assertThatThrownBy(() -> new BonusNumber(List.of("일")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두개 이상의 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void 보너스_번호_개수_검증_테스트() {
        assertThatThrownBy(() -> new BonusNumber(List.of("1" , "2")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1 ~ 45 범위 밖의 입력이 있으면 예외가 발생한다.")
    @Test
    void 보너스_번호_범위_검증_초과_테스트() {
        assertThatThrownBy(() -> new BonusNumber(List.of("48")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1 ~ 45 범위 밖의 입력이 있으면 예외가 발생한다.")
    @Test
    void 보너스_번호_범위_검증_미만_테스트() {
        assertThatThrownBy(() -> new BonusNumber(List.of("0")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
